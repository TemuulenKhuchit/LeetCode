package LeetCode.Backtrack;

import java.util.*;

public class Hard51 {
    private int n;
    private List<List<String>> solutions = new ArrayList<>();

    public static void main(String[] args) {
        Hard51 obj = new Hard51();
        System.out.println(obj.solveNQueens(4));
    }

    // Hard 51. N-Queens
    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        char[][] emptyBoard = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                emptyBoard[i][j] = '.';

        backtrack(0, new HashSet<>(), new HashSet<>(), new HashSet<>(), emptyBoard);
        return solutions;
    }

    private void backtrack(int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, char[][] state) {
        if (row == n) {
            solutions.add(createBoard(state));
            return;
        }

        for (int col = 0; col < n; col++) {
            int currDiagonal = row - col;
            int currAntiDiagonal = row + col;

            if (cols.contains(col) || diagonals.contains(currDiagonal) || antiDiagonals.contains(currAntiDiagonal))
                continue;

            cols.add(col);
            diagonals.add(currDiagonal);
            antiDiagonals.add(currAntiDiagonal);
            state[row][col] = 'Q';

            backtrack(row + 1, diagonals, antiDiagonals, cols, state);

            cols.remove(col);
            diagonals.remove(currDiagonal);
            antiDiagonals.remove(currAntiDiagonal);
            state[row][col] = '.';
        }
    }

    private List<String> createBoard(char[][] state) {
        List<String> board = new ArrayList<>();
        for (int row = 0; row < n; row++)
            board.add(new String(state[row]));
        return board;
    }
}
