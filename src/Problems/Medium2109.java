package Problems;

public class Medium2109 {

    public static void main(String[] args) {
        addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15});
    }

    // Medium 2109. Adding Spaces to a String
    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int leap = 0;
        for (int space : spaces) {
            for (int i = 0; i < space - leap; i++)
                sb.append(s.charAt(i + leap));
            sb.append(' ');
            leap = space;
        }

        for (int i = 0; i < s.length() - spaces[spaces.length - 1]; i++)
            sb.append(s.charAt(i + spaces[spaces.length - 1]));

        System.out.println(sb);
        return sb.toString();
    }
}
