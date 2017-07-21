def binary_search(arr, key)

  l = arr.length
  left = 0; right = l - 1
  while left <= right do
    mid = left + (right - left) / 2
    if key < arr[mid]
      right = mid - 1
    elsif key > arr[mid]
      left = mid + 1
    else
      return mid
    end
  end
  return -1
end
