function merge(arr, aux, lo, mi, hi, compareFun) {
  let i, j, k
  for(k = lo; k <= hi; k++) aux[k] = arr[k]

  i = lo; j = mi + 1

  for(k = lo; k <= hi; k++) {
    if(i > mi) arr[k] = aux[j++]
    else if (j > hi) arr[k] = aux[i++]
    else if (compareFun(aux[i], aux[j])) arr[k] = aux[i++]
    else arr[k] = aux[j++]
  }
}

function sortRec(arr, aux, lo, hi, compareFun) {
  if(lo >= hi) return;
  const mi = lo + Math.floor((hi - lo) / 2)
  sortRec(arr, aux, lo, mi, compareFun)
  sortRec(arr, aux, mi + 1, hi, compareFun)
  if(compareFun(arr[mi], arr[mi + 1])) return;
  merge(arr, aux, lo, mi, hi, compareFun)
}

function sort(arr, compareFun = (a, b) => a < b) {
  let aux = new Array(arr.length)
  sortRec(arr, aux, 0, arr.length-1, compareFun)
}
