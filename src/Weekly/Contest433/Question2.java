package Weekly.Contest433;

import java.util.Arrays;

public class Question2 {

    static final int MOD = 1000000007;
    static long[] fact;      // factorials
    static long[] invFact;   // inverse factorials (for binomial coefficients)

    public static void main(String[] args) {
        // Example usage / test:
        int[] nums1 = {1, 2, 3};
        int k1 = 2;
        System.out.println(minMaxSums(nums1, k1)); // Expected 24

        int[] nums2 = {5, 0, 6};
        int k2 = 1;
        System.out.println(minMaxSums(nums2, k2)); // Expected 22

        int[] nums3 = {1, 1, 1};
        int k3 = 2;
        System.out.println(minMaxSums(nums3, k3)); // Expected 12

    }


    public static int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        buildFactorials(n);

        long result = 0L;
        for (int i = 0; i < n; i++) {
            long waysMax = 0;
            for (int r = 1; r <= k; r++) {
                int choose = r - 1;
                if (choose <= i)
                    waysMax = (waysMax + comb(i, choose)) % MOD;
                else
                    break;
            }

            long waysMin = 0;
            for (int r = 1; r <= k; r++) {
                int choose = r - 1;
                if (choose <= (n - 1 - i))
                    waysMin = (waysMin + comb(n - 1 - i, choose)) % MOD;
                else
                    break;
            }

            long val = nums[i] % MOD;
            long contribution = val * ((waysMax + waysMin) % MOD) % MOD;
            result = (result + contribution) % MOD;
        }

        return (int) result;
    }

    /**
     * Precompute factorials and inverse factorials up to n for fast binomial coefficients.
     */
    private static void buildFactorials(int n) {
        fact = new long[n + 1];
        invFact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % MOD;
        invFact[n] = modExp(fact[n], MOD - 2, MOD);
        for (int i = n - 1; i >= 0; i--)
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
    }

    /**
     * Computes nCr = n! / (r! * (n-r)!) in O(1), given precomputed factorials & inverses.
     */
    private static long comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * ((invFact[r] * invFact[n - r]) % MOD) % MOD;
    }

    /**
     * Fast exponentiation (binary exponentiation) to compute (base^exp) % mod.
     */
    private static long modExp(long base, long exp, int mod) {
        long result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)
                result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

}
