package LeetCode.Backtrack;

public class Medium1079 {

    public static void main(String[] args) {
        System.out.println(numTilePossibilities("AAABBC"));
    }

    // Medium 1079. Letter Tile Possibilities
    public static int numTilePossibilities(String tiles) {
        int[] charCnt = new int[26];
        for (char c : tiles.toCharArray())
            charCnt[c - 'A']++;
        return findSeqs(charCnt);
    }

    private static int findSeqs(int[] charCnt) {
        int total = 0;

        for (int pos = 0; pos < 26; pos++) {
            if (charCnt[pos] == 0)
                continue;

            total++;
            charCnt[pos]--;
            total += findSeqs(charCnt);
            charCnt[pos]++;
        }

        return total;
    }
}
