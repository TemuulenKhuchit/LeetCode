package Weekly.Contest433;

public class Question3 {

    public static void main(String[] args) {
        int n1 = 4;
        int[][] cost1 = {
                {3, 5, 7}, // house 0
                {6, 2, 9}, // house 1
                {4, 8, 1}, // house 2
                {7, 3, 5}  // house 3
        };
        long ans1 = minCost(n1, cost1);
        System.out.println(ans1);  // Expected: 9
    }

    public static long minCost(int n, int[][] cost) {
        int half = n / 2;

        long[][] dpPrev = new long[3][3];
        long[][] dpCurr = new long[3][3];
        final long INF = Long.MAX_VALUE / 2;

        for (int cL = 0; cL < 3; cL++) {
            for (int cR = 0; cR < 3; cR++) {
                if (cL == cR)
                    dpPrev[cL][cR] = INF;
                else
                    dpPrev[cL][cR] = cost[0][cL] + cost[n - 1][cR];
            }
        }

        for (int i = 1; i < half; i++) {
            for (int cL = 0; cL < 3; cL++)
                for (int cR = 0; cR < 3; cR++)
                    dpCurr[cL][cR] = INF;

            for (int cL = 0; cL < 3; cL++) {
                for (int cR = 0; cR < 3; cR++) {
                    if (cL == cR)
                        continue;
                    long pairCost = cost[i][cL] + cost[n - 1 - i][cR];

                    long bestPrev = INF;
                    for (int prevL = 0; prevL < 3; prevL++) {
                        for (int prevR = 0; prevR < 3; prevR++) {
                            if (prevL == prevR) continue;
                            if (prevL == cL) continue;
                            if (prevR == cR) continue;

                            long candidate = dpPrev[prevL][prevR];
                            if (candidate < bestPrev)
                                bestPrev = candidate;
                        }
                    }

                    if (bestPrev != INF)
                        dpCurr[cL][cR] = bestPrev + pairCost;
                }
            }

            for (int cL = 0; cL < 3; cL++)
                for (int cR = 0; cR < 3; cR++)
                    dpPrev[cL][cR] = dpCurr[cL][cR];
        }

        long answer = INF;
        for (int cL = 0; cL < 3; cL++) {
            for (int cR = 0; cR < 3; cR++) {
                if (cL == cR) continue;
                answer = Math.min(answer, dpPrev[cL][cR]);
            }
        }
        return answer;
    }
}
