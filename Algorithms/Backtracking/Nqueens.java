
import java.util.Arrays;

public class Nqueens {
    
    public static void main(String[] args) {
        int n = 8;

        boolean[][] board = new boolean[n][n];

        System.out.println(getValidNQueens(board, 0));
        // System.out.println(getValidNRooks(board, 0));

    }

    private static int getValidNQueens(boolean[][] board, int row) {

        if (row == board.length) {

            display(board, "Q");
            // All rows are traversed
            return 1;
        }
        int count = 0;
        // Traverse though single row , i.e all columns
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += getValidNQueens(board, row + 1);
                // System.out.println(count);
                board[row][col] = false;
            }

        }
        return count;

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // we need to check only for above rows in 3 directions
        // vertical, diagonalleft, diagonalright

        // for vertical so column = col

        for (int r = row - 1; r >= 0; r--) {
            if (board[r][col] == true) {
                return false;
            }
        }

        // for left diagonal
        for (int i = 1; i <= Math.min(row, col); i++) {
            if (board[row - 1][col - 1] == true) {
                return false;
            }
        }

        // for right diagonal
        for (int i = 1; i <= Math.min(row, board.length - col - 1); i++) {
            if (board[row - 1][col + 1] == true) {
                return false;
            }
        }
        return true;
    }

    private static int display(boolean[][] board, String ch) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                System.out.print(board[i][j] ? ch : ".");
            }
            System.out.println();
        }
        System.out.println();

        return 1;
    }

   
}
