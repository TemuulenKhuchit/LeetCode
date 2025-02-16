package Weekly.Contest437;

public class Question1 {
    // For testing the solution
    public static void main(String[] args) {
        System.out.println(hasSpecialSubstring("aabaa", 2));
    }

    public static boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        if (k > n)
            return false;

        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            int j = i;
            while (j < n && s.charAt(j) == c)
                j++;
            int count = j - i;
            if (count == k) {
                if (i > 0 && s.charAt(i - 1) == c)
                    continue;
                if (j < n && s.charAt(j) == c)
                    continue;
                return true;
            }
            i = j;
        }
        return false;
    }

}
