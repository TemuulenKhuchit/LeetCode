package Weekly.Contest436;

public class Question3 {

    public static void main(String[] args) {
        String[] tests = {"3", "33", "04", "008", "16", "77", "19"};
        for (String s : tests)
            System.out.println("For s = " + s + "  →  " + countSubstrings(s));
    }

    public static long countSubstrings(String s) {
        int n = s.length();
        long ans = 0;

        int P3 = 0, P4 = 0, P6 = 0, P7 = 0, P8 = 0, P9 = 0;
        int[] freq3 = new int[3];
        freq3[0] = 1;
        int[] freq9 = new int[9];
        freq9[0] = 1;
        int[] freq6 = new int[6];
        freq6[0] = 1;
        int[][] freq7 = new int[6][7];
        freq7[0][0] = 1;

        int[] pow3 = {1, 3, 2, 6, 4, 5};
        int[] inv3 = {1, 5, 4, 6, 2, 3};

        for (int j = 0; j < n; j++) {
            int digit = s.charAt(j) - '0';

            P3 = (P3 + digit) % 3;
            P9 = (P9 + digit) % 9;
            P4 = (P4 * 2 + digit) % 4;
            P6 = (P6 * 4 + digit) % 6;
            P7 = (P7 * 3 + digit) % 7;
            P8 = (P8 * 2 + digit) % 8;

            if (digit == 0) {

            }
            else if (digit == 1 || digit == 2 || digit == 5)
                ans += (j + 1);
            else if (digit == 3)
                ans += freq3[P3];
            else if (digit == 4) {
                ans += 1;
                if (j >= 1 && P4 == 0)
                    ans += j;
            }
            else if (digit == 6) {
                int X = P6;
                int count6 = 0;
                if (X == 0) count6 = freq6[0] + freq6[3];
                else if (X == 2) count6 = freq6[2] + freq6[5];
                else if (X == 4) count6 = freq6[1] + freq6[4];
                ans += count6;
            }
            else if (digit == 7) {
                int sum7 = 0;
                int curP7 = P7;
                for (int m = 0; m < 6; m++) {
                    int r = ((j + 1) - m) % 6;
                    if (r < 0) r += 6;
                    int required = (curP7 * inv3[r]) % 7;
                    sum7 += freq7[m][required];
                }
                ans += sum7;
            }
            else if (digit == 8) {
                long count8 = 1;
                if (j >= 1) {
                    int prevDigit = s.charAt(j - 1) - '0';
                    if (((prevDigit * 2) + 8) % 8 == 0)
                        count8 += 1;
                }
                if (j >= 2)
                    if (P8 == 0)
                        count8 += (j - 1);
                ans += count8;
            }
            else if (digit == 9)
                ans += freq9[P9];

            freq3[P3]++;
            freq9[P9]++;
            freq6[P6]++;
            int modIndex = (j + 1) % 6;
            freq7[modIndex][P7]++;
        }

        return ans;
    }
}
