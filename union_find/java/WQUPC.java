import java.util.*;

public class WQUPC {

  private int[] parent;
  private int[] size;
  private int count;

  public WQUPC(int N) {
    int i;
    count = N;
    parent = new int[N];
    size = new int[N];
    for(i = 0; i < N; i++) {
      parent[i] = i;
      size[i] = 1;
    }
  }

  private int root(int i) {
    while(i != parent[i]) {
      parent[i] = parent[parent[i]];
      i = parent[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    if(connected(p, q)) return;
    int pRoot = root(p);
    int qRoot = root(q);

    if(size[pRoot] > size[qRoot]) {
      parent[qRoot] = pRoot;
      size[pRoot] += size[qRoot];
    } else {
      parent[pRoot] = qRoot;
      size[qRoot] += size[pRoot];
    }
    count--;

    System.out.println(Arrays.toString(parent));
  }
}
