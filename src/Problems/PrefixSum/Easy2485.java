package Problems.PrefixSum;

public class Easy2485 {

    public static void main(String[] args) {
        System.out.println(pivotInteger(8));
    }

    // Easy 2485. Find the Pivot Integer
    public static int pivotInteger(int n) {
        if (n == 1) return 1;
        int total = (n + 1) * n / 2;
        int currSum = 0;
        for (int i = 1; i <= n; i++) {
            if (currSum + currSum + i == total)
                return i;
            currSum += i;
        }
        return -1;
    }

}
