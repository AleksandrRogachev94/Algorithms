public class LinkedListQueue<Item> {
  private Node first;
  private Node last;

  private class Node {
    Item item;
    Node next;

    Node(Item item, Node next) {
      this.item = item;
      this.next = next;
    }
  }

  public boolean isEmpty() {
    return first == null;
  }

  public void enqueue(Item item) {
    Node oldLast = last;
    last = new Node(item, null);

    if(isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
  }

  public Item dequeue() {
    if(isEmpty()) return null;
    Item item = first.item;
    first = first.next;
    if(isEmpty()) last = null;
    return item;
  }
}
