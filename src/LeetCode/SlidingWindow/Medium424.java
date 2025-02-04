package LeetCode.SlidingWindow;

public class Medium424 {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }

    // Medium 424. Longest Repeating Character Replacement
    public static int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int[] freqMap = new int[26];
        int maxFreq = 0;

        for (end = 0; end < s.length(); end++) {
            freqMap[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[s.charAt(end) - 'A']);
            if (end - start + 1 - maxFreq > k) {
                freqMap[s.charAt(start) - 'A']--;
                start++;
            }
        }

        return end - start;
    }
}
