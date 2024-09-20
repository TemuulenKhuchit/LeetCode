public class StrategyExampleDivideAndConquer {
    static int count = 0;
    public static void main(String[] args) {
        int[] array = {200, 3, 42, -1561, 6, 7, 89, 595458, 156, 516, 155, -156, 516};
        System.out.println("Max value is: " + findMax(array));
        System.out.println("Function called " + count + " times.");
    }

    public static int findMax(int[] arr) {
        if (arr == null)
            return 0;
        return findMaxRecursive(0, arr.length - 1, arr);
    }

    public static int findMaxRecursive(int i, int j, int[] fullArray) {
        StrategyExampleDivideAndConquer.count++;
        if (i == j)
            return fullArray[i];
        int mid = (i + j) / 2;
        return Math.max(
                findMaxRecursive(i, mid, fullArray),
                findMaxRecursive(mid + 1, j, fullArray));
    }
}