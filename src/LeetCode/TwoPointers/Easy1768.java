package LeetCode.TwoPointers;

public class Easy1768 {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    // Easy 1768. Merge Strings Alternately
    public static String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int min = Math.min(n1, n2);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < min; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if (n1 == min)
            result.append(word2.substring(min, n2));
        if (n2 == min)
            result.append(word1.substring(min, n1));
        return result.toString();
    }

}
