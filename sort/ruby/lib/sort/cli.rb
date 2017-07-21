class Sort::CLI
  def call
    puts "Enter N"
    n = gets.strip.to_i
    puts "Enter Elements"
    arr = Array.new(n) { gets.strip.to_i }

    Sort::Quick.sort(arr)
    puts '------> After Sorting:'
    puts arr.inspect
  end
end
