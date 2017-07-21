class Stack::CLI
  def call
    stack = Stack::LinkedListStack.new()

    puts "Enter push/pop(-)"
    while((s = gets.strip) != "q") do
      if s == "-"
        puts stack.pop()
      else
        stack.push(s)
      end
      
      puts '----->Full Stack:'
      stack.each { |e| print "#{e} " }
      puts
    end
  end
end
