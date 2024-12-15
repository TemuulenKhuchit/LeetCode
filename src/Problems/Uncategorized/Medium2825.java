package Problems.Uncategorized;

public class Medium2825 {

    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("abc", "ad"));
    }

    // Medium 2825. Make String a Subsequence Using Cyclic Increments
    public static boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int p1 = 0;
        int p2 = 0;

        while (p1 < n1 && p2 < n2) {
            char c1 = str1.charAt(p1);
            char c2 = str2.charAt(p2);

            if (c1 == c2 || (char) (c1 == 'z' ? 'a' : c1 + 1) == c2)
                p2++;

            p1++;

            if (p2 == n2)
                return true;
        }

        return false;
    }
}
