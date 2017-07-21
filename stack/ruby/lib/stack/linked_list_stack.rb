class Stack::LinkedListStack
  include Enumerable
  class Node
    attr_accessor :next, :item

    def initialize(item, nextNode)
      self.next = nextNode
      self.item = item
    end
  end

  def isEmpty?
    @first.nil?
  end

  def push(item)
    @first = Node.new(item, @first)
  end

  def pop
    return if isEmpty?
    item = @first.item
    @first = @first.next
    item
  end

  def each(&block)
    current = @first
    while(current) do
      block.call(current.item)
      current = current.next
    end
  end
end
