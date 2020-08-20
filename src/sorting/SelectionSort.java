import java.util.Arrays;

public class SelectionSort {

  public static Integer[] selectionSort(Integer[] array) { //finds next item in unsorted and appends it to sorted
    for (int i = 0; i < array.length; i++) {
      int minValue = array[i];
      int minIndex = i;
      
      for (int j = i + 1; j < array.length; j++) {
        if (minValue > array[j]) {
          minValue = array[j];
          minIndex = j;
        }
      }

      int temp = array[i];
      array[i] = minValue;
      array[minIndex] = temp;
    }
    return array;
  }

  public static void main(String[] args) {
    Integer[] array = {2, 3, 1, 5, 4};
    Arrays.stream(selectionSort(array)).forEach(System.out::println);
  }
}