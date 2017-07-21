public class ArrayStack<Item> {

  private Item[] array;
  private int N;

  public ArrayStack() {
    array = (Item[]) new Object[1];
    N = 0;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void push(Item item) {
    if(N == array.length) resize(2 * array.length);
    array[N++] = item;
  }

  private void resize(int capacity) {
    int i;
    Item[] copy = (Item[]) new Object[capacity];
    for(i = 0; i < N; i++) {
      copy[i] = array[i];
    }
    array = copy;
  }

  public Item pop() {
    if(isEmpty()) return null;
    Item item = array[--N];
    if(N > 0 && N == array.length / 4) resize(array.length / 2);
    return item;
  }
}
