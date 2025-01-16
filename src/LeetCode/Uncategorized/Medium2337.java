package LeetCode.Uncategorized;

public class Medium2337 {

    public static void main(String[] args) {
        System.out.println(canChange("_L__R__R_", "L______RR"));
    }

    // Medium 2337. Move Pieces to Obtain a String
    public static boolean canChange(String start, String target) {
        int s_len = start.length();
        int f = 0;
        int t = 0;

        while (f < s_len || t < s_len) {
            while (f < s_len && start.charAt(f) == '_')
                f++;

            while (t < s_len && target.charAt(t) == '_')
                t++;

            if (f == s_len || t == s_len)
                return f == s_len && t == s_len;

            if (start.charAt(f) != target.charAt(t)
                    || (start.charAt(f) == 'L' && f < t)
                    || (start.charAt(f) == 'R' && f > t))
                return false;

            f++;
            t++;
        }

        return true;
    }
}
