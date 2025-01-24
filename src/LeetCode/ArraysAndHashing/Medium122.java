package LeetCode.ArraysAndHashing;

public class Medium122 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // Medium 122. Best Time to Buy and Sell Stock II
    public static int maxProfit(int[] prices) {
        int total = 0;
        int maxVal = Integer.MAX_VALUE;
        int minVal = maxVal;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < maxVal) {
                total += maxVal - minVal;
                maxVal = prices[i];
                minVal = maxVal;
            }
            else maxVal = prices[i];
        }
        return total + maxVal - minVal;
    }

}
