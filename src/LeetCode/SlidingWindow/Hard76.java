package LeetCode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class Hard76 {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    // Hard 76. Minimum Window Substring
    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (m == 0 || n == 0 || m < n)
            return "";

        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray())
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);

        int need = mapT.size();
        int found = 0;

        int l = 0, r = 0;
        int[] ans = {-1, 0, 0}; // Window length, left, right

        Map<Character, Integer> mapC = new HashMap<>();

        while (r < m) {
            char c = s.charAt(r);
            mapC.put(c, mapC.getOrDefault(c, 0) + 1);

            if (mapT.containsKey(c) && mapC.get(c).intValue() == mapT.get(c).intValue())
                found++;

            while (l <= r && found == need) {
                c = s.charAt(l);
                if (ans[0] == -1 || ans[0] > r - l + 1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                mapC.put(c, mapC.get(c) - 1);
                if (mapT.containsKey(c) && mapC.get(c).intValue() < mapT.get(c).intValue())
                    found--;

                l++;
            }

            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

}
