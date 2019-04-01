public class ArrayDequeTest {

    public static boolean checkEquals(int expected, int actual) {
        if (expected != actual) {
            System.out.println("Expected " + expected + ", found " + actual);
        } else {
            System.out.println("Size matches");
        }
        return expected == actual;

    }

    public static void main(String[] args) {
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.removeFirst();
        ArrayDeque.addLast(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.addLast(5);
        ArrayDeque.printDeque();
        ArrayDeque.removeLast();
        ArrayDeque.removeLast();
        ArrayDeque.printDeque();
        ArrayDeque.addFirst(8);
        ArrayDeque.addLast(9);
        ArrayDeque.addFirst(10);
        ArrayDeque.addLast(11);
        ArrayDeque.get(3);
        ArrayDeque.removeLast();
        ArrayDeque.get(1);
        ArrayDeque.addFirst(15);
        ArrayDeque.removeFirst();
        ArrayDeque.get(4);
        ArrayDeque.removeFirst();
        ArrayDeque.removeFirst();
        ArrayDeque.get(1);

        ArrayDeque.removeLast();
        System.out.println(ArrayDeque.removeFirst());


    }
}
