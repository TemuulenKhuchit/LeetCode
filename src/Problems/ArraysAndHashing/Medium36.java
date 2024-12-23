package Problems.ArraysAndHashing;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Medium36 {

    public static void main(String[] args) {
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board3 = {
                {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
                {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
//        System.out.println(isValidSudoku(board1));
//        System.out.println(isValidSudoku(board2));
        System.out.println(isValidSudoku(board3));
    }

    // Medium 36. Valid Sudoku
    public static boolean isValidSudoku(char[][] board) {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (set1.contains(board[i][j]))
                        return false;
                    set1.add(board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (set2.contains(board[j][i]))
                        return false;
                    set2.add(board[j][i]);
                }
            }
            set1.clear();
            set2.clear();
        }

        int counter = 0;

        while (counter < 9) {
            int row = 3 * (counter / 3);
            int col = 3 * (counter % 3);
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (board[i][j] != '.') {
                        if (set1.contains(board[i][j]))
                            return false;
                        set1.add(board[i][j]);
                    }
                }
            }
            set1.clear();
            counter++;
        }

        return true;
    }
}
