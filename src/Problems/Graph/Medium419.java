package Problems.Graph;

public class Medium419 {
    private int m;
    private int n;

    public static void main(String[] args) {
        Medium419 medium419 = new Medium419();
        char[][] grid = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}
        };
        medium419.countBattleships(grid);
    }

    // 419. Battleships in a Board
    public int countBattleships(char[][] board) {
        m = board.length;
        n = board[0].length;
        int boards = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'X') {
                    dfs(board, row, col);
                    boards++;
                }
            }
        }

        System.out.println(boards);
        return boards;
    }

    public void dfs(char[][] board, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] == '.')
            return;

        board[row][col] = '.';
        dfs(board, row + 1, col);
        dfs(board, row, col + 1);
    }
}
