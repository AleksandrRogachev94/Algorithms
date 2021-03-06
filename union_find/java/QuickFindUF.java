import java.util.*;

public class QuickFindUF {

  private int[] id;

  public QuickFindUF(int N) {
    int i;
    id = new int[N];
    for(i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public void union(int p, int q) {
    int i;
    int pid = id[p];
    int qid = id[q];
    for(i = 0; i < id.length; i++) {
      if(pid == id[i]) id[i] = qid;
    }

    System.out.println(Arrays.toString(id));
  }
}
