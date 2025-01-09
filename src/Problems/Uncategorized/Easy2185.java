package Problems.Uncategorized;

public class Easy2185 {

    public static void main(String[] args) {
        System.out.println(prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at"));
    }

    // Easy 2185. Counting Words With a Given Prefix
    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words)
            if (word.startsWith(pref))
                count++;
        return count;
    }

}
