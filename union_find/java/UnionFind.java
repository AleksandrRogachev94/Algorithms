import java.util.*;

public class UnionFind {
  public static void main(String[] args) {
    int p, q;
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter N");
    int N = scanner.nextInt();
    WQUPC uf = new WQUPC(N);

    System.out.println("Enter connections");
    while((p = scanner.nextInt()) != -1) {
      q = scanner.nextInt();

      if(!uf.connected(p, q)) {
        uf.union(p, q);
        System.out.format("%d %d\n", p, q);
      }
    }

    scanner.close();
  }
}
