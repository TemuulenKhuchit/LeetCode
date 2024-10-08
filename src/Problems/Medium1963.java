package Problems;

import java.util.*;

public class Medium1963 {

    public static void main(String[] args) {

        minSwaps("][][");
        minSwaps("]]][[[");
        minSwaps("");

    }

    public static int minSwaps(String s) {
        if (s == null)
            return 0;

        int swaps = 0;
        int open = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[')
                open++;
            else {
                if (open > 0)
                    open--;
                else {
                    open++;
                    swaps++;
                }
            }
        }

        System.out.println(swaps);

        return swaps;
    }


}