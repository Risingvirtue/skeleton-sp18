public class LinkedListDeque<T> {
    public class ListNode {

        T item;
        ListNode prev;
        ListNode next;
        ListNode(ListNode prev, T x, ListNode next) {
            this.prev = prev;
            item = x;
            this.next = next;
        }
    }

    int size;
    ListNode sentinel;
    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /** Adds an item to the front of the Deque. */
    public void addFirst(T x) {
        ListNode insert = new ListNode(sentinel, x, sentinel.next);
        sentinel.next = insert;
        size++;
    }
    /** Adds an item to the back of the Deque. */
    public void addLast(T x) {
        ListNode insert = new ListNode(sentinel.prev, x, sentinel);
        sentinel.prev = insert;
        size++;
    }
    /**  Returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return size == 0;
    }
    /** Returns the number of items in the Deque. */
    public int size() {
        return size;
    }
    /** Prints the items in the Deque from first to last, separated by a space. */
    public void printDeque() {
        StringBuffer sb = new StringBuffer();
        ListNode pointer = sentinel.next;

        while (pointer != sentinel) {
            sb.append(pointer.item);
            pointer = pointer.next;

            if (pointer != sentinel) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    /** Removes and returns the item at the front of the Deque.
     * If no such item exists, returns null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        ListNode removedNode = sentinel.next;
        T firstItem = removedNode.item;
        sentinel.next = removedNode.next;
        sentinel.next.prev = sentinel;
        size--;
        return firstItem;
    }

    /** Removes and returns the item at the back of the Deque.
     * If no such item exists, returns null. */
    public T removeLast() {

        return sentinel.item;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
     * If no such item exists, returns null. Must not alter the deque
     */
    public T get(int index) {
        return sentinel.item;
    }
}
