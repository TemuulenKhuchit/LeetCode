package Weekly.Contest429;

public class Question3 {

    public static void main(String[] args) {
        System.out.println(minLength("000001", 1));
        System.out.println(minLength("0000", 2));
        System.out.println(minLength("00", 2));
    }

    public static int minLength(String s, int numOps) {
        int maxSubstr = 1;
        int minSubstr = 1;

        int currCount = 1;
        int lastIndex = s.length() - 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                currCount++;
                if (currCount > maxSubstr) {
                    maxSubstr = currCount;
                    lastIndex = i;
                }
            }
            else currCount = 1;
        }

        if (numOps == 0)
            return maxSubstr;

        int changePosition = (int) Math.ceil(maxSubstr / (numOps + 1));

        minSubstr = (int) Math.floor(maxSubstr / (numOps + 1));
//        for (int i = lastIndex; i >= 0; i--) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//
//            }
//        }

        return minSubstr;
    }


}
