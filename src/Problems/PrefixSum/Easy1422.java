package Problems.PrefixSum;

public class Easy1422 {

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }

    // Easy 1422. Maximum Score After Splitting a String
    public static int maxScore(String s) {
        int n = s.length();
        int[] lps = new int[n - 1];
        int ls = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '0')
                ls++;
            lps[i] = ls;
        }
        int[] rps = new int[n - 1];
        int rs = 0;
        for (int i = n - 1; i > 0; i--) {
            if (s.charAt(i) == '1')
                rs++;
            rps[i - 1] = rs;
        }
        int max = 0;
        for (int i = 0; i < n - 1; i++)
            max = Math.max(max, lps[i] + rps[i]);
        return max;
    }

}
