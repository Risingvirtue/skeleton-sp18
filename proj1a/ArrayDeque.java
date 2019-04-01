public class ArrayDeque<Item> {
    Item[] arr;
    int head;
    int size;
    public ArrayDeque() {
        arr = (Item[]) new Object[8];
        head = 0;
        size = 0;
    }

    /** Adds an item to the front of the Deque. */
    public void addFirst(Item x) {
        if (size == arr.length) {
            resize(size * 2);
        }
        handleHead(head, -1);

        arr[head] = x;
        size++;
    }
    /** Adds an item to the back of the Deque. */
    public void addLast(Item x) {
        if (size == arr.length) {
            resize(size * 2);
        }
        int insert = (head + size) % arr.length;
        arr[insert] = x;
        size++;

    }
    /**  Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }

    public void resize(int newSize) {
        Item[] newArr = (Item[]) new Object[newSize];
        int numLeft = arr.length - head;
        System.arraycopy(arr, head, newArr, 0, numLeft);
        if (numLeft < size) {
            System.arraycopy(arr, 0, newArr, numLeft, size - numLeft);
        }
        arr = newArr;
        head = 0;
    }

    /** Returns the number of items in the Deque. */
    public int size() {
        return size;
    }
    /** Prints the items in the Deque from first to last, separated by a space. */
    public void printDeque() {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i != size - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    public void handleHead(int head, int increment)  {
        head += increment;
        if (head < 0) {
            head += arr.length;
        } else if (head >= arr.length) {
            head -= arr.length;
        }

        this.head = head;
    }

    /** Removes and returns the item at the front of the Deque. If no such item exists, returns null. */
    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        if (size * 4 < arr.length) {
            resize(size / 2);
        }

        Item first = get(0);

        arr[head] = null;

        handleHead(head, 1);

        size--;
        return first;
    }

    /** Removes and returns the item at the back of the Deque. If no such item exists, returns null. */
    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        if (size * 4 < arr.length) {
            resize(size / 2);
        }
        int lastNum = (head + size) % arr.length;
        Item last = get(size - 1);
        arr[lastNum] = null;
        size--;
        return last;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque
     */
    public Item get(int index) {
        int newIndex = (index + head) % arr.length;

        return arr[newIndex];
    }
}
