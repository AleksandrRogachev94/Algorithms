class Sort::Insertion
  def self.sort(arr, &comparable)
    comparable ||= Proc.new { |a, b| a < b }

    arr.length.times do |i|
      i.downto(1) do |j|
        if comparable.call(arr[j], arr[j-1])
          arr[j], arr[j-1] = arr[j-1], arr[j]
        else
          break
        end
      end
    end
  end
end
