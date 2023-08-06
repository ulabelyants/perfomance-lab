import java.util.ArrayList;
import java.util.List;

public class Task1 {

  public static void main(String[] args) {

    int n = Integer.valueOf(args[0]);
    int m = Integer.valueOf(args[1]);

    int i = 1;

    List<Integer> array = new ArrayList<>();

    do {
      array.add(i);
      i = (i + (m - 1));
      if (i > n) {
        i = i - n;
      }
    } while (i != 1);
    array.forEach(t -> System.out.print(t.toString()));
  }
}
