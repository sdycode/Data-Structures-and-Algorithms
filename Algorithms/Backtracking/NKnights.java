public class NKnights {
static int tcount = 0;
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(placeKnight(board, 0, 0, 4));
        // System.out.println(placeKnightFromVideo(board, 0, 0, 4));
        System.out.println("tcount "+tcount);
        // default is false
    }

    private static int placeKnightFromVideo(boolean[][] board, int row, int col, int knights) {
        int count = 0;
        if (knights == 0) {
            tcount++;
            display(board, "K");
            return 1;
        }
        if (row == board.length - 1 && col == board.length) {
            return count;
        }

        if (col == board.length) {
            count+=      placeKnightFromVideo(board, row + 1, 0, knights);
            return count;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count+=     placeKnightFromVideo(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        count +=    placeKnightFromVideo(board, row, col + 1, knights);
        return count;
    }
    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }

        return true;
    }

    // do not repeat yourself, hence created this function
    static boolean isValid(boolean[][] board, int row, int col) {
        if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
            return true;
        }
        return false;
    }
    private static int placeKnight(boolean[][] board, int row, int col, int knights) {
        int count = 0;

        if (knights == 0) {
            display(board, "K");
            tcount++;
            return 1;
        }
        for (int colm = 0; colm < board[row].length; colm++) {
            if (isSafeKnight(board, row, col)) {

                if (colm == board[row].length - 1) {
                    board[row][col] = true;
                    count += placeKnight(board, row + 1, 0, knights - 1);
                    board[row][col] = false;
                } else {
                    board[row][col] = true;
                    count += placeKnight(board, row, colm + 1, knights - 1);
                    board[row][col] = false;
                }
            }
        }
        return count;
    }

    private static boolean isSafeKnight(boolean[][] board, int row, int col) {
        int[][] positions = new int[][] {
                { row - 1, col - 2 }, { row - 1, col + 2 },
                { row - 2, col - 1 }, { row - 2, col + 1 },

        };
        for (int i = 0; i < positions.length; i++) {
            if (positions[i][0] >= 0 && positions[i][0] < board.length
                    && (positions[i][1] >= 0 && positions[i][1] < board.length)) {
                // System.out.println(board[row][col] + " " + row + " " + col);
                if (board[row][col] == true) {
                    return false;
                }

            }
        }

        return true;
    }

    private static void display(boolean[][] board, String ch) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                System.out.print(board[row][col] == true ? ch : ".");
            }
            System.out.println();

        }
        System.out.println();
        System.out.println();

    }
}
