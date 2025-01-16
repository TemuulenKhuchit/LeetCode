package LeetCode.Uncategorized;

public class Medium2516 {

    public static void main(String[] args) {
        System.out.println(takeCharacters("aabaaaacaabc", 2));
        System.out.println(takeCharacters("a", 1));
    }

    // Medium 2516. Take K of Each Character From Left and Right
    public static int takeCharacters(String s, int k) {
        int n = s.length();
        int[] total = new int[3];

        for (char c : s.toCharArray())
            total[c - 'a']++;

        for (int qty : total)
            if (qty < k) return -1;

        int[] window = new int[3];
        int left = 0;
        int maxWindow = 0;

        for (int right = 0; right < n; right++) {
            window[s.charAt(right) - 'a']++;

            while (left <= right
                    && (total[0] - window[0] < k
                    || total[1] - window[1] < k
                    || total[2] - window[2] < k)
            ) {
                window[s.charAt(left) - 'a']--;
                left++;
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        return n - maxWindow;
    }

}
