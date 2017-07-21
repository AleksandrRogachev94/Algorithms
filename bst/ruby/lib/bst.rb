require 'pry'

class Node
  attr_accessor :left, :right, :key, :val

  def initialize(key, val)
    @key = key
    @val = val
  end
end

class BST

  def initialize(&comparator)
    @comparator = comparator || Proc.new { |a, b| a < b }
  end

  def get(key)
    x = @root
    while !x.nil?
      if @comparator.call(x.key, key)
        x = x.left
      elsif @comparator.call(key, x.key)
        x = x.right
      else
        return x.val
      end
    end
  end

  def put(key, val)
    @root = putRec(@root, key, val)
  end

  def min
    x = @root
    while x && !x.left.nil?
      x = x.left
    end
    x
  end

  def max
    x = @root
    while x && !x.right.nil?
      x = x.right
    end
    x
  end

  private

    def putRec(node, key, val)
      return Node.new(key, val) if node.nil?
      if @comparator.call(key, node.key)
        node.left = putRec(node.left, key, val)
      elsif @comparator.call(node.key, key)
        node.right = putRec(node.right, key, val)
      else
        node.val = val
      end
      node
    end
end

bst = BST.new
puts bst.min.inspect
puts bst.max.inspect
bst.put("b", 1)
bst.put("c", 2)
bst.put("a", 3)
bst.put("d", 4)
puts bst.min.inspect
puts bst.max.inspect
