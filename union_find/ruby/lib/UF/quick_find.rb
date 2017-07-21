class UF::QuickFind
  attr_reader :id

  def initialize(n)
    @n = n.to_i
    @id = (0..@n-1).to_a
  end

  def union(p, q)
    return if self.connected?(p, q)
    pid = self.id[p]
    qid = self.id[q]

    @id = self.id.map do |idEl|
      idEl == pid ? qid : idEl
    end
  end

  def connected?(p, q)
    self.id[p] == self.id[q]
  end
end
