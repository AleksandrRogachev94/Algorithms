class Node {
  constructor(item, nextItem) {
    this.item = item
    this.next = nextItem
  }
}

class LinkedListQueue {
  constructor() {
    this.first = null
    this.last = null
  }

  isEmpty() {
    return this.first === null
  }

  enqueue(item) {
    let oldLast = this.last
    this.last = new Node(item, null)
    if(this.isEmpty()) {
      this.first = this.last
    } else {
      oldLast.next = this.last
    }
  }

  dequeue() {
    if(this.isEmpty()) return null
    let item = this.first.item
    this.first = this.first.next
    if(this.isEmpty()) this.last = null
    return item
  }
}
