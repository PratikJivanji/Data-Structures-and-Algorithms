import java.util.ArrayList;
import java.util.Arrays;

public class Array {

  private Object[] data;
  private int capacity;
  private int length;

  public Array () {
    capacity = 1;
    length = 0;
    data = new Object[1];
  }

  public Object get(int index) {
    return data[index];
  }

  public void push(Object obj) {
    if(capacity == length) {
      data = Arrays.copyOf(data, capacity * 2);
      capacity *= 2;
    }
    data[length] = obj;
    length++;
  }

  public Object pop() {
    Object popped = data[length - 1];
    data[length - 1] = null;
    length--;
    return popped;
  }

  public Object delete(int index) {
    Object itemToDelete = data[index];
    shiftItems(index);
    return itemToDelete;
  }

  public void shiftItems(int index) {
    for (int i = index; i < length - 1; i++) {
      data[i] = data[i + 1];
    }
    data[length - 1] = null;
    length--;
  }

  public static void main(String[] args) {
    Array array = new Array();
    array.push("Hello");
    array.push("World");

    for (int i = 0; i < array.length; i++) {
      System.out.println(array.get(i));
    }
  }
}