import java.util.*;

public class Merge {

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

  public static void merge(Comparable[] arr, Comparable[] aux, int lo, int mi, int hi) {
    int i, j, k;
    for(k = lo; k <= hi; k++) aux[k] = arr[k];

    i = lo; j = mi + 1;
    for(k = lo; k <= hi; k++) {
      if(i > mi) arr[k] = aux[j++];
      else if(j > hi) arr[k] = aux[i++];
      else if (less(aux[i], aux[j])) arr[k] = aux[i++];
      else arr[k] = aux[j++];
    }
  }

  public static Comparable[] merge2Arrays(Comparable[] arr1, Comparable[] arr2) {
    Comparable[] result = new Comparable[arr1.length + arr2.length];

    int i = 0, j = 0, k;

    for(k = 0; k < result.length; k++) {
      if(i >= arr1.length) result[k] = arr2[j++];
      else if(j >= arr2.length) result[k] = arr1[i++];
      else if(less(arr1[i], arr2[j])) result[k] = arr1[i++];
      else result[k] = arr2[j++];
    }

    return result;
  }

  public static void sort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
    if(lo >= hi) return;
    int mi = lo + (hi - lo) / 2;
    sort(arr, aux, lo, mi);
    sort(arr, aux, mi + 1, hi);
    if(less(arr[mi], arr[mi + 1])) return;
    merge(arr, aux, lo, mi, hi);
  }

  public static void sort(Comparable[] arr) {
    Comparable[] aux = new Comparable[arr.length];
    sort(arr, aux, 0, arr.length - 1);
  }
}
