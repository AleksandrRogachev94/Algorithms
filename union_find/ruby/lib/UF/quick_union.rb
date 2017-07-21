# Array as a tree

class UF::QuickUnion
  attr_reader :id

  def initialize(n)
    @n = n.to_i
    @id = (0..@n-1).to_a
  end

  def union(p, q)
    return if self.connected?(p, q)
    pRoot = self.root(p)
    qRoot = self.root(q)

    @id[pRoot] = qRoot
  end

  def connected?(p, q)
    root(p) == root(q)
  end

  private

    def root(i)
      while(id[i] != i) do
        i = id[i]
      end
      i
    end
end
