class WQUPC {
  constructor(N) {
    var i
    this.count = N
    this.parent = []
    this.size = []
    for(i = 0; i < N; i++) {
      this.parent.push(i)
      this.size.push(1)
    }
  }

  root(i) {
    while(i != this.parent[i]) {
      this.parent[i] = this.parent[this.parent[i]]
      i = this.parent[i]
    }
    return i
  }

  connected(p, q) {
    return this.root(p) == this.root(q)
  }

  union(p, q) {
    if(this.connected(p, q)) return;
    var pRoot = this.root(p)
    var qRoot = this.root(q)

    if(this.size[pRoot] > this.size[qRoot]) {
      this.parent[qRoot] = pRoot;
      this.size[pRoot] += this.size[qRoot]
    } else {
      this.parent[pRoot] = qRoot;
      this.size[qRoot] += this.size[pRoot];
    }
    this.count--;

    console.log(this.parent)
  }
}
