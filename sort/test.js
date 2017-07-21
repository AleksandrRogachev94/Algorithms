function swap(arr, i, j) {
  const temp = arr[i]
  arr[i] = arr[j]
  arr[j] = temp
}

function sort(arr) {
  let i, j

  for(i = 0; i < arr.length; i++) {
    for(j = i; j < arr.length; j++) {
      if(arr[j] < arr[i]) swap(arr, j, i)
    }
  }
}
