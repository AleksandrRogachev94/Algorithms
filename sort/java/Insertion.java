import java.util.*;

public class Insertion {

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
    for(i = 0; i < arr.length; i++) {
      for(j = i; j > 0; j--) {
        if(less(arr[j], arr[j-1])) {
          exch(arr, j, j-1);
        } else {
          break;
        }
      }
    }
  }
}
