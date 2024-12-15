package Problems.Uncategorized;

public class Easy2558 {
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
    }

    // Easy 2558. Take Gifts From the Richest Pile
    public static long pickGifts(int[] gifts, int k) {
        while (k > 0) {
            int maxIndex = 0;
            for (int i = 0; i < gifts.length; i++) {
                if (gifts[i] > gifts[maxIndex])
                    maxIndex = i;
            }
            gifts[maxIndex] = (int) Math.floor(Math.sqrt(gifts[maxIndex]));
            k--;
        }

        long sum = 0;
        for (int i = 0; i < gifts.length; i++)
            sum += gifts[i];

        return sum;
    }
}
