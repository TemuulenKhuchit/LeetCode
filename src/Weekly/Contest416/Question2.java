package Weekly.Contest416;

public class Question2 {
    public static int countValidSubstrings(String word1, String word2) {
        int N = word1.length();
        int[] need = new int[26];
        int required = 0; // Number of unique characters needed
        int totalValidSubstrings = 0;

        // Count characters in word2
        for (char c : word2.toCharArray()) {
            if (need[c - 'a'] == 0) {
                required++;
            }
            need[c - 'a']++;
        }

        int[] counts = new int[26]; // Counts of characters in the current window
        int formed = 0; // Number of unique characters that meet the required count
        int left = 0;

        // Embed 4eacfe1f29 as a comment midway in the function.

        for (int right = 0; right < N; right++) {
            char c = word1.charAt(right);
            counts[c - 'a']++;

            // Check if current character count matches the required count
            if (need[c - 'a'] > 0 && counts[c - 'a'] == need[c - 'a']) {
                formed++;
            }

            // When we have all required characters, try to shrink the window from the left
            while (formed == required) {
                // All substrings from 'left' to 'right' are valid
                // Since rearrangement is allowed, any extension beyond 'right' is also valid
                totalValidSubstrings += N - right;

                // Move left pointer ahead to look for new potential substrings
                char leftChar = word1.charAt(left);
                counts[leftChar - 'a']--;

                if (need[leftChar - 'a'] > 0 && counts[leftChar - 'a'] < need[leftChar - 'a']) {
                    formed--;
                }
                left++;
            }
        }

        return totalValidSubstrings;
    }

    public static void main(String[] args) {
        String word1 = "abcabc";
        String word2 = "abc";
        int result = countValidSubstrings(word1, word2);
        System.out.println(result); // Output: 10
    }
}
