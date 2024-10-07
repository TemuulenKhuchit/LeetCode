package Problems;

public class DSADivideAndConquer {
    static int twoWayCounter = 0;
    static int threeWayCounter = 0;

    public static void main(String[] args) {
        int[] array = {200, 3, 42, -1561, 6, 7, 89, 595458, 156, 516, 155, -156, 516};

        System.out.println("Two way search's Max value is: " + findMax(array));
        System.out.println("Two way search's Function called " + twoWayCounter + " times.");
    }

    public static int findMax(int[] array) {
        if (array == null)
            return 0;

        return findMaxRecursive(0, array.length - 1, array);
    }

    public static int findMaxRecursive(int i, int j, int[] array) {
        if (i == j)
            return array[i];

        DSADivideAndConquer.twoWayCounter++;
        int mid = (i + j) / 2;

        return Math.max(
                findMaxRecursive(i, mid, array),
                findMaxRecursive(mid + 1, j, array));
    }
}