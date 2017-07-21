import java.util.*;

public class BinarySearch {

  public static int binarySearch(int[] arr, int key) {

    int l = arr.length;
    int left = 0; int right = l - 1;
    int mid;
    while(left <= right) {
      mid = left + (right - left) / 2;
      if(key < arr[mid]) {
        right = mid - 1;
      } else if(key > arr[mid]) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
