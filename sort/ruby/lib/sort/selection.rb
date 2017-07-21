class Sort::Selection
  def self.sort(arr, &comparable)
    comparable ||= Proc.new { |a, b| a < b }

    arr.length.times do |i|
      min = i
      (i + 1).upto(arr.length-1) do |j|
        if comparable.call(arr[j], arr[min])
          min = j
        end
      end
      arr[i], arr[min] = arr[min], arr[i] if i != min
    end
  end
end
