class QuickUnion {

  constructor(N) {
    var i
    this.id = []
    for(i = 0; i < N; i++) {
      this.id.push(i)
    }
  }

  root(i) {
    while(i != this.id[i]) i = this.id[i]
    return i
  }

  connected(p, q) {
    return this.root(p) == this.root(q)
  }

  union(p, q) {
    var pRoot = this.root(p)
    var qRoot = this.root(q)

    this.id[pRoot] = qRoot
    console.log(this.id)
  }
}
