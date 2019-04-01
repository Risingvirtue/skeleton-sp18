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
        arr.addFirst(1);
        arr.addLast(3);
        arr.addFirst(5);
        arr.addLast(2);
        arr.addLast(4);
        //arr.printDeque();


        checkEquals(arr.removeFirst(), 5);
        checkEquals(arr.get(2), 2);
        checkEquals(arr.size(), 4);



        ArrayDeque<Integer> arr2 = new ArrayDeque<>();
        arr2.addFirst(1);
        arr2.addLast(3);
        arr2.addFirst(5);
        arr2.addLast(2);
        arr2.addLast(4);
        arr2.addLast(-1);
        arr2.addLast(-2);
        arr2.addFirst(7);

        arr2.addFirst(8);

        int[] equalArr = new int[]{8,7,5,1,3,2,4,-1, -2};

        for (int i = 0; i < 5; i++) {
            checkEquals(equalArr[i], arr2.get(i));
        }

    }
}
