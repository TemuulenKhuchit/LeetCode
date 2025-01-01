package Problems.Uncategorized;

public class Easy1422 {

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
    }

    public static int maxScore(String s) {
        int n = s.length();
        int max = 0;
        for (int i = 1; i < n; i++) {
            int curr = 0;
            for (int j = 0; j < i; j++)
                if (s.charAt(j) == '0')
                    curr++;
            for (int k = n - 1; k >= i; k--)
                if (s.charAt(k) == '1')
                    curr++;
            max = Math.max(max, curr);
        }
        return max;
    }

}
