import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertionSort {

  public static Integer[] insertionSort(Integer[] array) { //take unsorted value and put it in sorted list
    List<Integer> list = new LinkedList<>(Arrays.asList(array));

    for (int i = 1; i < list.size(); i++) { 
      if (list.get(i) <= list.get(0)) { 
        list.add(0, list.get(i)); 
        list.remove(i + 1);
      } else {
        if (list.get(i) < list.get(i - 1)) {
          for (int j = 1; j < i; j++) {
            if (list.get(i) >= list.get(j - 1) && list.get(i) < list.get(j)) {
              list.add(j, list.get(i));
              list.remove(i + 1);
            }
          }
        }
      }
    } 
    return list.toArray(new Integer[0]);
  }

  public static void main(String[] args) {
    Integer[] array = {2, 3, 1, 5, 4};
    Arrays.stream(insertionSort(array)).forEach(System.out::println);
  }
}