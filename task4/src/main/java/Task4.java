import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Task4 {

    public static void main(String[] args) throws IOException {

        //считываешь первый аргумент с cmd и строим по нему экзепляр файла
        File file = new File(args[0]);
        FileInputStream fileInputStream = new FileInputStream(file);

        List<Integer> array = new ArrayList<>();

        //базовая конструкция считывания из фала строк по строчно с использованием конструкции try with resources
        try (BufferedReader bufferedReader = new BufferedReader(
            new InputStreamReader(fileInputStream))) {
            //пока в файле есть строки, читаем и каждую, преобразуем к типу integer и складываем в лист array.
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                array.add(Integer.valueOf(line));
            }
        }

        //поиск среднего значения типа double, иначе если в массиве array нет значения бросить исключение "Среднее не определено"
        double avgDouble = array
            .stream()
            .mapToInt(r -> r)
            .average()
            .orElseThrow(() -> new RuntimeException("Среднее не определено"));

        //округляем значение avgDouble до типа int, с помощью Math.round(..)
        int avgInt = (int) Math.round(avgDouble);

        //определяем сумму операций, вычитая из каждого элемента массива среднее значение (по модулю)
        //и все операции суммируем методом sum
        final int sum = array.stream()
            .map(i -> Math.abs(i - avgInt))
            .mapToInt(r -> r)
            .sum();

        System.out.println(sum);
    }
}
