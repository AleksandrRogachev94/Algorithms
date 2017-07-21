public class ArrayQueue<Item> {

  private Item[] array;
  private int N;
  private int first;
  private int last;

  public ArrayQueue() {
    array = (Item[]) new Object[1];
    N = first = last = 0;
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public void enqueue(Item item) {
    if(N == array.length) resize(2 * array.length);
    array[last++] = item;
    if(last == array.length) last = 0;
    N++;
  }

  private void resize(int capacity) {
    int i;
    Item[] copy = (Item[]) new Object[capacity];
    for(i = 0; i < N; i++) {
      copy[i] = array[(first + i) % array.length];
    }
    array = copy;
    first = 0;
    last = N;
  }

  public Item dequeue() {
    if(isEmpty()) return null;
    Item item = array[first];
    array[first] = null;
    N--;
    first++;
    if(first == array.length) first = 0;

    if(N > 0 && N == array.length / 4) resize(array.length / 2);
    return item;
  }
}
