public class LinkedListStack<Item> {
  private Node first;

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

  public void push(Item item) {
    first = new Node(item, first);
  }

  public Item pop() {
    if(isEmpty()) return null;
    Item item = first.item;
    first =  first.next;
    return item;
  }
}
