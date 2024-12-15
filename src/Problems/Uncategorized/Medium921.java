package Problems.Uncategorized;

public class Medium921 {

    public static void main(String[] args) {
        minAddToMakeValid("())");
        minAddToMakeValid("(((");
    }

    public static int minAddToMakeValid(String s) {
        if (s == null)
            return 0;

        int need = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') open++;
            else close++;
            if (close > open) {
                open++;
                need++;
            }
        }

        if (open > close)
            need += open - close;

        return need;
    }

}
