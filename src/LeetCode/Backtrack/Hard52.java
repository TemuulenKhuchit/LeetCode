package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hard52 {
    private int n;

    public static void main(String[] args) {
        Hard52 obj = new Hard52();
        System.out.println(obj.totalNQueens(4));
    }

    // Hard 51. N-Queens
    public int totalNQueens(int n) {
        this.n = n;
        return backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    private int backtrack(int row, Set<Integer> diags, Set<Integer> antiDiags, Set<Integer> cols) {
        if (row == n)
            return 1;

        int solutions = 0;
        for (int col = 0; col < n; col++) {
            int currDiag = row - col;
            int currAntiDiag = row + col;

            if (diags.contains(currDiag) || antiDiags.contains(currAntiDiag) || cols.contains(col))
                continue;

            diags.add(currDiag);
            antiDiags.add(currAntiDiag);
            cols.add(col);

            solutions += backtrack(row + 1, diags, antiDiags, cols);

            diags.remove(currDiag);
            antiDiags.remove(currAntiDiag);
            cols.remove(col);
        }

        return solutions;
    }
}
