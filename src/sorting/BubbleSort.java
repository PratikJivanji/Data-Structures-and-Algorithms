import java.util.Arrays;

public class BubbleSort {

  public static Integer[] bubbleSort(Integer[] array) { //loop swaping adjacent items if in wrong order
    int temp;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j + 1]) { 
          temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {
    Integer[] array = {2, 3, 1, 5, 4};
    Arrays.stream(bubbleSort(array)).forEach(System.out::println);
  }
}