package LeetCode.ArraysAndHashing;

public class Easy14 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char prefix = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length())
                    return result.toString();
                if (prefix != str.charAt(i))
                    return result.toString();
            }
            result.append(prefix);
        }
        return result.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        String minString = strs[0];

        for (String str : strs) {
            if (str.length() < minString.length()) {
                minString = str;
            }
        }

        for (int i = 0; i < minString.length(); i++) {
            boolean isSimilar = true;
            char letter = strs[0].charAt(i);
            if (strs.length > 1) {
                for (String str : strs) {
                    if (letter != str.charAt(i)) {
                        isSimilar = false;
                        break;
                    }
                }
            }
            if (isSimilar)
                prefix.append(letter);
            else
                break;
        }

        return prefix.toString();
    }

}
