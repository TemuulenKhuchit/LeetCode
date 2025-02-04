package LeetCode.SlidingWindow;

public class Medium424 {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }

    // Medium 424. Longest Repeating Character Replacement
    public static int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        int[] frequencyMap = new int[26];
        int maxFrequency = 0;

        for (end = 0; end < s.length(); end++) {
            int currentChar = s.charAt(end) - 'A';
            frequencyMap[currentChar]++;
            maxFrequency = Math.max(maxFrequency, frequencyMap[currentChar]);

            if (end - start + 1 - maxFrequency > k) {
                int outgoingChar = s.charAt(start) - 'A';
                frequencyMap[outgoingChar]--;
                start++;
            }
        }

        return end - start;
    }
}
