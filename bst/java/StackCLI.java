import java.util.*;

public class StackCLI {
  public static void main(String[] args) {

    ArrayStack<String> stack = new ArrayStack<String>();
    Scanner scanner = new Scanner(System.in);
    String s;

    System.out.println("Enter push/pop(-)");
    while(!(s = scanner.next()).equals("q")) {
      if(s.equals("-")) {
        System.out.println(stack.pop());
      } else {
        stack.push(s);
      }
    }

    scanner.close();
  }
}
