package LeetCode.PrefixSum;

public class Medium2381 {

    public static void main(String[] args) {
        int[][] shifts = new int[][]{{4, 8, 0}, {4, 4, 0}, {2, 4, 0}, {2, 4, 0},
                {6, 7, 1}, {2, 2, 1}, {0, 2, 1}, {8, 8, 0}, {1, 3, 1}};
        System.out.println(shiftingLetters("xuwdbdqik", shifts));
    }

    // Medium 2381.Shifting Letters II
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int[] diffArray = new int[n];
        for (int[] shift : shifts) {
            int direction = (shift[2] == 1) ? 1 : -1;
            diffArray[shift[0]] += direction;
            if (shift[1] + 1 < n)
                diffArray[shift[1] + 1] -= direction;
        }
        int cumulativeSum = 0;
        for (int i = 0; i < n; i++) {
            cumulativeSum = (cumulativeSum + diffArray[i]) % 26 + 26;
            result.append((char) ('a' + (s.charAt(i) - 'a' + cumulativeSum) % 26));
        }
        return result.toString();
    }

}
