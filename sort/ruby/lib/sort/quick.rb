class Sort::Quick
  def self.shuffle(arr)
    arr.each.with_index do |el, i|
      r = rand(0..i)
      arr[i], arr[r] = arr[r], arr[i] if i != r
    end
  end

  def self.partition(arr, lo, hi, &comparable)
    i = lo - 1; j = hi + 1
    loop do
      begin
        i+= 1
      end while comparable.call(arr[i], arr[lo]) && i <= hi
      begin
        j-= 1
      end while comparable.call(arr[lo], arr[j])
      break if i >= j
      arr[i], arr[j] = arr[j], arr[i]
    end
    arr[lo], arr[j] = arr[j], arr[lo]
    j
  end

  def self.sortRec(arr, lo, hi, &comparable)
    return if lo >= hi
    j = partition(arr, lo, hi, &comparable)
    sortRec(arr, lo, j-1, &comparable)
    sortRec(arr, j+1, hi, &comparable)
  end

  def self.threeSortRec(arr, lo, hi, &comparable)
    return if lo >= hi
    i = lo; lt = lo; gt = hi
    v = arr[lo]

    while i <= gt do
      if arr[i] < v
        arr[i], arr[lt] = arr[lt], arr[i]
        i += 1; lt += 1
      elsif arr[i] > v
        arr[gt], arr[i] = arr[i], arr[gt]
        gt -= 1
      else
        i += 1
      end
    end

    threeSortRec(arr, lo, lt - 1)
    threeSortRec(arr, gt + 1, hi)
  end

  def self.sort(arr, &comparable)
    comparable ||= Proc.new { |a, b| a < b }
    shuffle(arr)
    threeSortRec(arr, 0, arr.length - 1, &comparable)
  end
end
