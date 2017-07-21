import java.util.*;

public class Selection {

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
    int i, j, min;
    for(i = 0; i < arr.length; i++) {
      min = i;
      for(j = i+1; j < arr.length; j++) {
        if(less(arr[j], arr[min])) {
          min = j;
        }
      }
      if (i != min) exch(arr, i, min);
    }
  }
}
