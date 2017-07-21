class UF::CLI
  def call
    puts "Enter N"
    n = gets.strip

    uf = UF::WQUPC.new(n)

    puts "Enter unions"
    while((p = gets.strip.to_i) != -1) do
      q = gets.strip.to_i
      uf.union(p, q)
      puts uf.parent.inspect
    end

    binding.pry
  end
end
