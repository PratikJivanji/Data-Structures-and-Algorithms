import java.util.*;

public class MyQueue {
    LinkedList<Int> ll = new LinkedList<Int>();

   public MyQueue() {
   }

    public int peek() {
        return ll.peek();
    }

    public void enqueue(int value) {
        ll.add(value);
    }

    public void dequeue() {
        ll.remove();
    }

    public void get() {
        ll.remove();
    }

    public void printQueue() {
        System.out.println(ll.toString());
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }
}