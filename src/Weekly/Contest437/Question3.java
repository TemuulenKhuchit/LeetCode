package Weekly.Contest437;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question3 {

    public static void main(String[] args) {
        String s = "zhqzqqcpamgiykmcozsphnnqtebbetwtwtbfrucxgcmpshiuus";
        System.out.println(maxSubstringLength(s, 8));
    }

    public static boolean maxSubstringLength(String s, int k) {
        int n = s.length();
        if (k == 0)
            return true;

        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, n);
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> candidates = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (last[c] == -1)
                continue;
            int start = first[c];
            if (start != s.indexOf(s.charAt(start)))
                continue;
            int end = last[c];
            int j = start;
            boolean valid = true;

            while (j <= end) {
                int letter = s.charAt(j) - 'a';
                if (first[letter] < start) {
                    valid = false;
                    break;
                }
                end = Math.max(end, last[letter]);
                j++;
            }

            if (valid && !(start == 0 && end == n - 1))
                candidates.add(new int[]{start, end});
        }

        candidates.sort(Comparator.comparingInt(interval -> interval[1]));
        int count = 0, lastEnd = -1;
        for (int[] inter : candidates) {
            if (inter[0] > lastEnd) {
                count++;
                lastEnd = inter[1];
            }
        }

        return count >= k;
    }

}
