function sort(arr, compareFunction = (a, b) => a < b ) {
  let i, j

  for(i = 0; i < arr.length; i++) {
    for(j = i; j > 0; j--) {
      if(compareFunction(arr[j], arr[j-1])) {
        swap(arr, j, j-1)
      } else {
        break
      }
    }
  }
}

function swap(arr, i, j) {
  let swap = arr[i]
  arr[i] = arr[j]
  arr[j] = swap
}
