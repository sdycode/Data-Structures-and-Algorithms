public class NRooks {public static void main(String[] args) {
    int n = 8;

    boolean[][] board = new boolean[n][n];

    System.out.println(getValidNRooks(board, 0));

}
    private static int getValidNRooks(boolean[][] board, int row) {
        int count = 0;
        if (row == board.length) {
            display(board, "R");
            return 1;
        }

        for (int col = 0; col < board[0].length; col++) {

            if(isSafeRook(board, row, col)){
                board[row][col] = true;
                count+= getValidNRooks(board, row+1);
                board[row][col]= false;
            }
            
        }
        return count;

    }

    private static boolean isSafeRook(boolean[][] board, int row, int col) {
        // we need to check only for above rows in 3 directions
        // vertical, diagonalleft, diagonalright

        // for vertical so column = col

        for (int r = row - 1; r >= 0; r--) {
            if (board[r][col] == true) {
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
