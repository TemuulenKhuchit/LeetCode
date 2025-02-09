package Weekly.Contest436;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question2 {

    public static void main(String[] args) {
        int[] groups = {10, 15, 20};
        int[] elements = {2, 3, 5};

        int[] result = assignGroups(groups, elements);
        System.out.println("Assigned element indices for each group: " + Arrays.toString(result));
    }

    public static int[] assignGroups(int[] groups, int[] elements) {
        int MAX = 100000;

        int[] smallestIndex = new int[MAX + 1];
        Arrays.fill(smallestIndex, -1);
        for (int j = 0; j < elements.length; j++) {
            int val = elements[j];
            if (smallestIndex[val] == -1)
                smallestIndex[val] = j;
        }

        int n = groups.length;
        int[] assigned = new int[n];

        for (int i = 0; i < n; i++) {
            int g = groups[i];
            int candidate = Integer.MAX_VALUE;

            for (int d = 1; d * d <= g; d++) {
                if (g % d == 0) {
                    int d1 = d;
                    int d2 = g / d;

                    if (smallestIndex[d1] != -1)
                        candidate = Math.min(candidate, smallestIndex[d1]);

                    if (d1 != d2 && smallestIndex[d2] != -1)
                        candidate = Math.min(candidate, smallestIndex[d2]);
                }
            }

            assigned[i] = (candidate == Integer.MAX_VALUE) ? -1 : candidate;
        }

        return assigned;
    }

}
