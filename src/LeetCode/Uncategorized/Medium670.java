package LeetCode.Uncategorized;

public class Medium670 {

    public static void main(String[] args) {
        maximumSwap(2736);
        maximumSwap(9973);
        maximumSwap(1993);
    }

    public static int maximumSwap(int num) {
        if (num < 10)
            return num;

        char[] chars = ("" + num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int max = i;
            for (int j = chars.length - 1; j >= i; j--) {
                if (chars[j] > chars[i] && chars[j] > chars[max])
                    max = j;
            }
            if (max != i) {
                char temp = chars[i];
                chars[i] = chars[max];
                chars[max] = temp;
                break;
            }
        }

        System.out.println(chars);
        return Integer.parseInt(new String(chars));
    }

}
