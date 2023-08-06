import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task2 {

  public static void main(String[] args) throws IOException {

    Point centePoint;
    double radius;

    //читаем файл tests.json и преобразовываем к типу Tests (структура ответа, имеет древовидную структуру)
    try (BufferedReader readerTests = new BufferedReader(
        new InputStreamReader(Files.newInputStream(new File(args[0]).toPath())))) {

      List<String> baseData = new ArrayList<>();
      while (readerTests.ready()) {
        String line = readerTests.readLine();
        baseData.add(line);
      }

      //координаты цента окружности.
      String[] centre = baseData.get(0).split(" ");
      float x0 = Float.valueOf(centre[0]);
      float y0 = Float.valueOf(centre[1]);
      centePoint = new Point(x0, y0);

      radius = Double.valueOf(baseData.get(1));
    }

    List<Point> points = new ArrayList<>();
    //читаем файл values.json и преобразовываем к листу результатов тестов (List<Values>)
    try (BufferedReader pointsReader = new BufferedReader(
        new InputStreamReader(Files.newInputStream(new File(args[1]).toPath())))) {

      while (pointsReader.ready()) {
        String line = pointsReader.readLine();

        String[] pointCoordinate = line.split(" ");
        float x = Float.valueOf(pointCoordinate[0]);
        float y = Float.valueOf(pointCoordinate[1]);

        points.add(new Point(x, y));
      }
    }

    System.out.println(
        points.stream().map(point -> checkEntry(centePoint, point, radius)).map(Object::toString)
            .collect(Collectors.joining(" ")));

  }


  //проверка входения точки в радиус окружности
  public static int checkEntry(Point centre, Point point, double radius) {

    double r = Math.sqrt(
        Math.pow(point.getX() - centre.getX(), 2) + Math.pow(point.getY() - centre.getY(), 2));

    if ((radius) == r) {
      return 0;
    } else if (radius > r) {
      return 1;
    } else {
      return 2;
    }
  }

  public static class Point {

    float x;
    float y;

    public Point(float x, float y) {
      this.x = x;
      this.y = y;
    }

    public float getX() {
      return x;
    }

    public float getY() {
      return y;
    }
  }

}
