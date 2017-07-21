require 'pry'

class MaxHeap
  def initialize(&comparator)
    @arr = Array.new(1)
    @comparator = comparator || Proc.new { |a, b| a < b }
  end

  def size
    @arr.length - 1
  end

  def empty?
    size <= 0
  end

  def insert(item)
    @arr.push(item)
    swim(@arr.length - 1)
  end

  def delMax
    return if empty?

    @arr[1], @arr[@arr.length-1] = @arr[@arr.length-1], @arr[1]
    max = @arr.pop
    sink(1)
    max
  end

  private

    def swim(k)
      while k > 1 && @comparator.call(@arr[k/2], @arr[k]) do
        @arr[k/2], @arr[k] = @arr[k], @arr[k/2]
        k = k / 2
      end
      puts @arr.inspect
    end

    def sink(k)
      while 2 * k < @arr.length do
        j = 2 * k
        j += 1 if (j < @arr.length - 1) && @comparator.call(@arr[j], @arr[j+1])
        break if !@comparator.call(@arr[k], @arr[j])
        @arr[k], @arr[j] = @arr[j], @arr[k]
        k = j
      end
      puts @arr.inspect
    end
end

h = MaxHeap.new
h.insert("T")
h.insert("P")
h.insert("R")
h.insert("N")
h.insert("H")
h.insert("O")
h.insert("A")
h.insert("E")
h.insert("I")
h.insert("G")
h.insert("S")
puts h.delMax
