function sort(arr, compareFunction = (a, b) => a < b ) {
  let i, j, min

  for(i = 0; i < arr.length; i++) {
    min = i
    for(j = i+1; j < arr.length; j++) {
      if(compareFunction(arr[j], arr[min])) {
        min = j
      }
    }
    swap(arr, i, min)
  }
}

function swap(arr, i, j) {
  let swap = arr[i]
  arr[i] = arr[j]
  arr[j] = swap
}
