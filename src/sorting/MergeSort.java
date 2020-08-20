import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

  public static Integer[] mergeSort(Integer[] array) {
    return mergeSort(new ArrayList<>(Arrays.asList(array))).toArray(new Integer[0]);
  }

  public static List<Integer> mergeSort(List<Integer> array) {
    if (array.size() == 1) {
      return array;
    }

    List<Integer> left = array.subList(0, array.size() / 2); // Split Array in into right and left
    List<Integer> right = array.subList(array.size() / 2, array.size());
    return merge(mergeSort(left), mergeSort(right));
  }

  public static List<Integer> merge(List<Integer> left, List<Integer> right) {
    List<Integer> merged = new ArrayList<>();
    int leftIndex = 0;
    int rightIndex = 0;
    
    while (leftIndex < left.size() && rightIndex < right.size()) { //merge until done with one of the sides
      if (left.get(leftIndex) <= right.get(rightIndex)) { 
        merged.add(left.get(leftIndex));
        leftIndex++;
      } else {
        merged.add(right.get(rightIndex));
        rightIndex++;
      }
    }

    merged.addAll(left.subList(leftIndex, left.size())); //merge because we know they are sorted
    merged.addAll(right.subList(rightIndex, right.size()));
    return merged;
  }

  public static void main(String[] args) {
    Integer[] array = {2, 3, 1, 5, 4, 7, 8, 6};
    Arrays.stream(mergeSort(array)).forEach(System.out::println);
  }
}