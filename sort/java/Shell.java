import java.util.*;

public class Shell {

  private static boolean less(Comparable v, Comparable w) {
    return v.compareTo(w) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable swap = a[i];
    a[i] = a[j];
    a[j] = swap;
  }

  public static boolean isSorted(Comparable[] a) {
    for(int i = 1; i < a.length; i++) {
      if(less(a[i], a[i-1])) return false;
    }
    return true;
  }

  public static void sort(Comparable[] arr) {
    int i, j;
    int N = arr.length;

    int h = 1;
    while(h < N/3) h = 3*h + 1;
    while(h >= 1) {
      for(i = h; i < arr.length; i++) {
        for(j = i; j >= h; j-= h) {
          if(less(arr[j], arr[j-h])) {
            exch(arr, j, j-h);
          } else {
            break;
          }
        }
      }
      h = h/3;
    }
  }
}
