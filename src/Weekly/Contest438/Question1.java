package Weekly.Contest438;

public class Question1 {

    public static void main(String[] args) {
        System.out.println(hasSameDigits("3902"));
        System.out.println(hasSameDigits("34789"));
    }

    public static boolean hasSameDigits(String s) {
        while (s.length() > 2) {
            StringBuilder next = new StringBuilder();
            for (int i = 0; i < s.length() - 1; i++) {
                int d1 = s.charAt(i) - '0';
                int d2 = s.charAt(i + 1) - '0';
                int newDigit = (d1 + d2) % 10;
                next.append(newDigit);
            }
            s = next.toString();
        }
        return s.charAt(0) == s.charAt(1);
    }
}
