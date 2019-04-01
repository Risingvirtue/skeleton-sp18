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
        ArrayDeque<Integer> arr = new ArrayDeque<>();
        arr.addLast(0);
        arr.addLast(1);
        arr.get(0);
        arr.addLast(3);
        arr.addFirst(4);
        arr.addLast(5);
        arr.addLast(6);
        arr.removeLast();
        arr.removeLast();
        arr.removeFirst();
        arr.removeLast();
        arr.addFirst(12);
        arr.removeLast();
        arr.removeLast();
        arr.addLast(15);
        arr.removeFirst();
        arr.addFirst(17);
        arr.get(0);
        arr.removeFirst();


        System.out.println(arr.removeLast());
    }
}
