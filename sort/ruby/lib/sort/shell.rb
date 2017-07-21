class Sort::Shell
  def self.sort(arr, &comparable)
    comparable ||= Proc.new { |a, b| a < b }
    n = arr.length
    h = 1
    while(h < n/3) do
      h = 3*h + 1
    end

    while(h >= 1) do
      h.upto(n-1) do |i|
        i.step(h, -h) do |j|
          if comparable.call(arr[j], arr[j-h])
            arr[j], arr[j-h] = arr[j-h], arr[j]
          else
            break
          end
        end
      end
      h = h/3
    end
  end
end
