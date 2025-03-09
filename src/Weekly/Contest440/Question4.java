package Weekly.Contest440;

import java.util.ArrayList;
import java.util.Arrays;

public class Question4 {

    static class RMQ {
        int[][] st;
        int[] log;
        int n;

        RMQ(int[] arr, int n) {
            this.n = n;
            log = new int[n + 2];
            for (int i = 2; i <= n; i++)
                log[i] = log[i / 2] + 1;
            int K = log[n] + 1;
            st = new int[n + 1][K];
            for (int i = 1; i <= n; i++)
                st[i][0] = arr[i];
            for (int j = 1; j < K; j++)
                for (int i = 1; i + (1 << j) - 1 <= n; i++)
                    st[i][j] = Math.min(st[i][j - 1], st[i + (1 << (j - 1))][j - 1]);
        }

        int query(int L, int R) {
            if (L > R) return Integer.MAX_VALUE;
            int j = log[R - L + 1];
            return Math.min(st[L][j], st[R - (1 << j) + 1][j]);
        }
    }

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        int[] best = new int[n + 2];
        int[] second = new int[n + 2];
        int[] freq = new int[n + 2];
        Arrays.fill(best, 1, n + 2, n + 1);
        Arrays.fill(second, 1, n + 2, n + 1);

        for (int[] pair : conflictingPairs) {
            int a = pair[0], b = pair[1];
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            if (b < best[a]) {
                second[a] = best[a];
                best[a] = b;
                freq[a] = 1;
            } else if (b == best[a])
                freq[a]++;
            else if (b < second[a])
                second[a] = b;
        }

        int[] F = new int[n + 2];
        int[] M = new int[n + 2];
        F[n + 1] = n + 1;
        F[n] = best[n];
        M[n] = n;
        for (int i = n - 1; i >= 1; i--) {
            if (best[i] <= F[i + 1]) {
                F[i] = best[i];
                M[i] = i;
            } else {
                F[i] = F[i + 1];
                M[i] = M[i + 1];
            }
        }

        long origTotal = 0;
        for (int i = 1; i <= n; i++)
            origTotal += (long)(F[i] - i);

        ArrayList<Integer>[] indicesByM = new ArrayList[n + 2];
        for (int i = 1; i <= n; i++)
            indicesByM[i] = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int idx = M[i];
            indicesByM[idx].add(i);
        }

        RMQ rmq = new RMQ(best, n);

        long bestTotal = origTotal;

        for (int a = 1; a <= n; a++) {
            if (best[a] == n + 1) continue;
            if (freq[a] > 1) continue;
            int B = best[a];
            int newB = second[a];
            int T = (a < n ? F[a + 1] : n + 1);
            int effectiveCandidate = Math.min(newB, T);
            if (effectiveCandidate <= B) continue;

            long delta = 0;
            for (int i : indicesByM[a]) {
                int curOld = B;
                int candidate;
                if (i < a)
                    candidate = rmq.query(i, a - 1);
                else
                    candidate = n + 1;
                int newVal = Math.min(candidate, effectiveCandidate);
                int improvement = newVal - curOld;
                if (improvement < 0) improvement = 0;
                delta += improvement;
            }
            long candidateTotal = origTotal + delta;
            bestTotal = Math.max(bestTotal, candidateTotal);
        }

        return bestTotal;
    }
}
