package LeetCode.Uncategorized;

public class Easy3042 {

    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs(new String[]{"a", "aba", "ababa", "aa"}));
    }

    // Easy 3042. Count Prefix and Suffix Pairs I
    public static int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++)
                if (isPrefixAndSuffix(words[i], words[j]))
                    count++;
        return count;
    }

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }

}
