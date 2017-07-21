class Sort::Merge
  def self.merge(arr, aux, lo, mi, hi, &comparable)
    (lo..hi).each { |k| aux[k] = arr[k] }

    i = lo; j = mi + 1
    (lo..hi).each do |k|
      if(i > mi)
        arr[k] = aux[j]
        j += 1
      elsif j > hi
        arr[k] = aux[i]
        i += 1
      elsif comparable.call(aux[i], aux[j])
        arr[k] = aux[i]
        i += 1
      else
        arr[k] = aux[j]
        j += 1
      end
    end
  end

  def self.sort_rec(arr, aux, lo, hi, &comparable)
    return if lo >= hi
    mi = lo + (hi - lo) / 2
    sort_rec(arr, aux, lo, mi, &comparable)
    sort_rec(arr, aux, mi + 1, hi, &comparable)
    return if comparable.call(arr[mi], arr[mi + 1])
    merge(arr, aux, lo, mi, hi, &comparable)
  end

  def self.sort(arr, &comparable)
    aux = Array.new(arr.length)
    comparable ||= Proc.new { |a, b| a < b }
    self.sort_rec(arr, aux, 0, arr.length - 1, &comparable)
  end
end
