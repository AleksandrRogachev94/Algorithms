class QuickFind {

  constructor(N) {
    var i
    this.id = []
    for(i = 0; i < N; i++) {
      this.id.push(i)
    }
  }

  connected(p, q) {
    return this.id[p] == this.id[q];
  }

  union(p, q) {
    var i;
    var pid = this.id[p];
    var qid = this.id[q];
    for(i = 0; i < this.id.length; i++) {
      if(pid == this.id[i]) this.id[i] = qid;
    }

    console.log(this.id)
  }
}
