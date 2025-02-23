package Weekly.Contest438;

public class Question3 {

    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902"));
        System.out.println(hasSameDigits("34789"));
    }

    static int[][] c5Table = new int[5][5];

    static {
        for (int a = 0; a < 5; a++)
            for (int b = 0; b < 5; b++)
                c5Table[a][b] = (b <= a) ? binomialMod5(a, b) : 0;
    }

    private static int binomialMod5(int a, int b) {
        if (b == 0 || b == a) return 1;
        if (b == 1 || b == a - 1) return a;
        int val = 1;
        val = factorial(a) / (factorial(b) * factorial(a - b));
        return val % 5;
    }

    private static int factorial(int x) {
        int f = 1;
        for (int i = 1; i <= x; i++) {
            f *= i;
        }
        return f;
    }

    private static int Cmod5(int n, int k) {
        int result = 1;
        while (n > 0 || k > 0) {
            int nDigit = n % 5;
            int kDigit = k % 5;
            if (kDigit > nDigit) {
                return 0;
            }
            result = (result * c5Table[nDigit][kDigit]) % 5;
            n /= 5;
            k /= 5;
        }
        return result;
    }

    private static int Cmod2(int n, int k) {
        return ((k & ~n) == 0) ? 1 : 0;
    }

    static int[][] combineMod2And5 = new int[2][5];

    static {
        for (int c2 = 0; c2 < 2; c2++) {
            for (int c5 = 0; c5 < 5; c5++) {
                int xVal = -1;
                for (int x = 0; x < 10; x++) {
                    if (x % 2 == c2 && x % 5 == c5) {
                        xVal = x;
                        break;
                    }
                }
                combineMod2And5[c2][c5] = xVal;
            }
        }
    }

    public static boolean hasSameDigits(String s) {
        int n = s.length();

        int[] d = new int[n];
        for (int i = 0; i < n; i++)
            d[i] = s.charAt(i) - '0';

        int[] D = new int[n - 1];
        for (int j = 0; j < n - 1; j++)
            D[j] = d[j] - d[j + 1];

        int bigN = n - 2;

        int sumMod10 = 0;
        for (int k = 0; k <= bigN; k++) {
            int c2 = Cmod2(bigN, k);
            int c5 = Cmod5(bigN, k);
            int c10 = combineMod2And5[c2][c5];
            int val = c10 * ((D[k] % 10 + 10) % 10);
            sumMod10 = (sumMod10 + val) % 10;
        }

        return sumMod10 == 0;
    }
}
