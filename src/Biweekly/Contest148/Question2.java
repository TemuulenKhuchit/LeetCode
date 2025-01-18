package Biweekly.Contest148;

import java.util.Arrays;

public class Question2 {

    public static void main(String[] args) {
        int[] arr = {-7, 9, 5};
        int[] brr = {7, -2, -5};
        int k = 2;
        System.out.println(minCost(arr, brr, k));
    }

    public static long minCost(int[] arr, int[] brr, int k) {
        int n = arr.length;

        long costNoRearr = 0;
        for (int i = 0; i < n; i++)
            costNoRearr += Math.abs(arr[i] - brr[i]);

        int[] arrSorted = arr.clone();
        int[] brrSorted = brr.clone();
        Arrays.sort(arrSorted);
        Arrays.sort(brrSorted);

        long costRearrElements = 0;
        for (int i = 0; i < n; i++)
            costRearrElements += Math.abs(arrSorted[i] - brrSorted[i]);
        long costWithRearr = costRearrElements + k;

        return Math.min(costNoRearr, costWithRearr);
    }

}
