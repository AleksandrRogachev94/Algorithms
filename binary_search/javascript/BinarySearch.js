class BinarySearch {
  static binarySearch(arr, key) {

    let l = arr.length;
    let left = 0; let right = l - 1;
    let mid;
    while(left <= right) {
      mid = left + ((right - left) / 2 | 0);
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
