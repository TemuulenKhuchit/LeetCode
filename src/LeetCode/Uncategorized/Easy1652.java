package LeetCode.Uncategorized;

public class Easy1652 {

    public static void main(String[] args) {
        decrypt(new int[]{5, 7, 1, 4}, 3);
        decrypt(new int[]{1, 2, 3, 4}, 0);
        decrypt(new int[]{2, 4, 9, 3}, -2);
    }

    // Easy 1652. Defuse the Bomb
    public static int[] decrypt(int[] code, int k) {
        int len = code.length;
        int[] res = new int[len];
        if (k == 0)
            return res;

        if (k > 0) {
            for (int i = 0; i < len; i++) {
                int sum = 0;
                int counter = 1;
                while (counter <= k) {
                    int index = (i + counter) % len;
                    sum += code[index];
                    counter++;
                }
                res[i] = sum;
            }
        }

        else {
            k *= -1;
            for (int i = 0; i < len; i++) {
                int sum = 0;
                int counter = 1;
                while (counter <= k) {
                    int index = i - counter >= 0 ? i - counter : i - counter + len;
                    sum += code[index];
                    counter++;
                }
                res[i] = sum;
            }
        }

        return res;
    }
}
