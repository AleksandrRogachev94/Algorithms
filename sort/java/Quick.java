import java.util.*;

public class Quick {

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

  public static void shuffle(Comparable[] arr) {
    Random rand = new Random();
    int i, r;
    for(i = 0; i < arr.length; i++) {
      r = rand.nextInt(i + 1);
      if(r != i) exch(arr, i, r);
    }
  }

  public static int partition(Comparable[] arr, int lo, int hi) {
    int i, j, k;

    j = hi + 1; i = lo;
    while(true) {
      while(i < hi && less(arr[++i], arr[lo]));
      while(less(arr[lo], arr[--j]));

      if(i >= j) break;
      exch(arr, i, j);
    }
    exch(arr, lo, j);
    return j;
  }

  public static void sort(Comparable[] arr, int lo, int hi) {
    if(lo >= hi) return;
    int j = partition(arr, lo, hi);
    sort(arr, lo, j-1);
    sort(arr, j+1, hi);
  }

  public static void threeSort(Comparable[] arr, int lo, int hi) {
    int lt = lo, gt = hi, i = lo, cmp;
    if(lo >= hi) return;
    Comparable v = arr[lo];

    while(i <= gt) {
      cmp = arr[i].compareTo(v);
      if(cmp < 0) {
        exch(arr, i, lt);
        i++; lt++;
      } else if(cmp > 0) {
        exch(arr, i, gt);
        gt--;
      } else {
        i++;
      }
    }

    threeSort(arr, lo, lt-1);
    threeSort(arr, gt+1, hi);
  }

  public static void sort(Comparable[] arr) {
    shuffle(arr);
    threeSort(arr, 0, arr.length - 1);
  }
}
