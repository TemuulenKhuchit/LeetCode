package Problems.Uncategorized;

public class Easy14 {
    public static String longestCommonPrefix(String[] strs) {
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
