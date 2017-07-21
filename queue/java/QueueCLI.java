import java.util.*;

public class QueueCLI {
  public static void main(String[] args) {

    ArrayQueue<String> stack = new ArrayQueue<String>();
    Scanner scanner = new Scanner(System.in);
    String s;

    System.out.println("Enter queue/dequeue(-)");
    while(!(s = scanner.next()).equals("q")) {
      if(s.equals("-")) {
        System.out.println(stack.dequeue());
      } else {
        stack.enqueue(s);
      }
    }

    scanner.close();
  }
}
