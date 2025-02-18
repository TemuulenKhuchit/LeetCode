package LeetCode.Backtrack;

public class Medium79 {

    private char[][] board;
    private String word;
    private int rows;
    private int cols;

    public static void main(String[] args) {
        Medium79 obj = new Medium79();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(obj.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        rows = board.length;
        cols = board[0].length;

        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                if (backtrack(row, col, 0))
                    return true;
        return false;
    }

    private boolean backtrack(int row, int col, int index) {
        if (index >= word.length())
            return true;

        if (row < 0 || row == rows || col < 0 || col == cols || board[row][col] != word.charAt(index))
            return false;

        board[row][col] = '#';

        boolean bottom = backtrack(row + 1, col, index + 1);
        boolean top = backtrack(row - 1, col, index + 1);
        boolean left = backtrack(row, col - 1, index + 1);
        boolean right = backtrack(row, col + 1, index + 1);

        board[row][col] = word.charAt(index);
        return bottom || top || left || right;
    }

}
