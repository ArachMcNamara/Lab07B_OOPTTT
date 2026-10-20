public class TTTBoard {

    private String[][] board;

    public TTTBoard() {
        board = new String[3][3];
        resetBoard();
    }

    public boolean makeMove(int row, int col, String symbol) {
        if (board[row][col].equals("")) {
            board[row][col] = symbol;
            return true;
        }
        return false;
    }

    public String getCell(int row, int col) {
        return board[row][col];
    }

    public void resetBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = "";
            }
        }
    }

    public boolean checkWin(String symbol) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(symbol)
                    && board[i][1].equals(symbol)
                    && board[i][2].equals(symbol))
                return true;

            if (board[0][i].equals(symbol)
                    && board[1][i].equals(symbol)
                    && board[2][i].equals(symbol))
                return true;
        }

        if (board[0][0].equals(symbol)
                && board[1][1].equals(symbol)
                && board[2][2].equals(symbol))
            return true;

        if (board[0][2].equals(symbol)
                && board[1][1].equals(symbol)
                && board[2][0].equals(symbol))
            return true;

        return false;
    }

    public boolean checkTie() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c].equals("")) {
                    return false;
                }
            }
        }
        return true;
    }
}