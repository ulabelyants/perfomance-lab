import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task3 {

  public static void main(String[] args) throws IOException {

    ObjectMapper objectMapper = new ObjectMapper();
    Tests tests;
    Values values;

    //читаем файл tests.json и преобразовываем к типу Tests (структура ответа, имеет древовидную структуру)
    try (BufferedReader readerTests = new BufferedReader(
        new InputStreamReader(Files.newInputStream(new File(args[0]).toPath())))) {
      tests = objectMapper.readValue(readerTests, Tests.class);
    }

    //читаем файл values.json и преобразовываем к листу результатов тестов (List<Values>)
    try (BufferedReader readerValues = new BufferedReader(
        new InputStreamReader(Files.newInputStream(new File(args[1]).toPath())))) {
      values = objectMapper.readValue(readerValues, Values.class);
    }

    fillResult(tests.getTests(), values.getValues());

    //меняем в абсолютном пути первого файла, tests.json -> report.json,
    // чтобы результат (report.json) был в том же каталоге, что и tests.json
    String resultPath = args[0].replaceAll("tests.json", "report.json");

    objectMapper.writeValue(Paths.get(resultPath).toFile(), tests);
  }

  //рекурсивный метод, заполнения древовидной структуры Tests ответами values
  private static void fillResult(List<Test> tests, List<Value> values) {
    if (tests != null) {
      tests.forEach(test -> {
        if (test.getValues() == null) {
          values
              .stream()
              .filter(value -> value.getId().equals(test.getId()))
              .findAny()
              .ifPresent(value -> test.setValue(value.getValue()));
        } else {
          test.getValues().forEach(t -> {
                fillResult(t.getValues(), values);
                values.stream()
                    .filter(value -> value.getId().equals(t.getId()))
                    .findAny()
                    .ifPresent(value -> t.setValue(value.getValue()));
              }
          );
          values
              .stream()
              .filter(value -> value.getId().equals(test.getId()))
              .findAny()
              .ifPresent(value -> test.setValue(value.getValue()));
        }
      });
    }
  }
}
