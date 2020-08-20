import java.util.Arrays;

public class QuickSort {

  public static Integer[] quickSort(Integer[] array, int left, int right){ //like merge but around a pivot
    int pivot;
    int partitionIndex;

    if(left < right) {
      pivot = right;
      partitionIndex = partition(array, pivot, left, right);
      quickSort(array, left, partitionIndex - 1); //sort left and right
      quickSort(array, partitionIndex + 1, right);
    }
    return array;
  }

  public static int partition(Integer[] array, int pivot, int left, int right){
    int pivotValue = array[pivot];
    int partitionIndex = left;

    for(int i = left; i < right; i++) {
      if(array[i] < pivotValue){
        swap(array, i, partitionIndex);
        partitionIndex++;
      }
    }
    swap(array, right, partitionIndex);
    return partitionIndex;
  }

  private static void swap(Integer[] array, int index1, int index2) {
    int temp = array[index1];
    array[index1] = array[index2];
    array[index2] = temp;
  }

  public static void main(String[] args) {
    Integer[] array = {2, 3, 1, 5, 4, 7, 8, 6};
    System.out.println(Arrays.asList(quickSort(array, 0 , array.length - 1)));
  }
}