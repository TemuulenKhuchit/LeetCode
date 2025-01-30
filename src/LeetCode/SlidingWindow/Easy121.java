package LeetCode.SlidingWindow;

public class Easy121 {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // Easy 121. Best Time to Buy and Sell Stock
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice)
                minPrice = price;
            else if (price - minPrice > maxProfit)
                maxProfit = price - minPrice;
        }
        return maxProfit;
    }

}
