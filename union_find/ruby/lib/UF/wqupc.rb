# Weighted Quick Union with Path Comression

class UF::WQUPC
  attr_reader :parent, :size, :count

  def initialize(n)
    @n = n.to_i
    @parent = (0..@n-1).to_a
    @size = Array.new(@n, 1) # Size of subtree.
    @count = @n # number of components.
  end

  def union(p, q)
    return if connected?(p, q)
    pRoot = root(p)
    qRoot = root(q)

    if size[pRoot] > size[qRoot]
      @parent[qRoot] = pRoot
      size[pRoot] += size[qRoot]
    else
      @parent[pRoot] = qRoot
      size[qRoot] += size[pRoot]
    end
    @count -= 1
  end

  def connected?(p, q)
    root(p) == root(q)
  end

  private

    def root(i)
      while(parent[i] != i) do
        parent[i] = parent[parent[i]]
        i = parent[i]
      end
      i
    end
end
