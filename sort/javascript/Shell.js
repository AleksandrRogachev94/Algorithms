function sort(arr, compareFunction = (a, b) => a < b ) {
  let i, j, h = 1

  while(h < arr.length/3) h = 3*h + 1

  while(h >= 1) {
    for(i = h; i < arr.length; i++) {
      for(j = i; j >= h; j-= h) {
        if(compareFunction(arr[j], arr[j-h])) {
          swap(arr, j, j-h)
        } else {
          break
        }
      }
    }
    h = h / 3
  }
}

function swap(arr, i, j) {
  let swap = arr[i]
  arr[i] = arr[j]
  arr[j] = swap
}
