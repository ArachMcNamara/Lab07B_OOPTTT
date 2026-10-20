import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends JFrame {

    private TTTBoard board;
    private TTTTileButton[][] buttons;

    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public Game() {

        board = new TTTBoard();

        playerX = new Player("X");
        playerO = new Player("O");
        currentPlayer = playerX;

        buttons = new TTTTileButton[3][3];

        setTitle("Tic Tac Toe");
        setSize(400, 400);
        setLayout(new GridLayout(3, 3));

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {

                TTTTileButton btn = new TTTTileButton(r, c);
                btn.setFont(new Font("Arial", Font.BOLD, 50));

                btn.addActionListener(e -> {

                    TTTTileButton clicked =
                            (TTTTileButton) e.getSource();

                    int row = clicked.getRow();
                    int col = clicked.getCol();

                    if (board.makeMove(row, col,
                            currentPlayer.getSymbol())) {

                        clicked.setText(
                                currentPlayer.getSymbol());

                        if (board.checkWin(
                                currentPlayer.getSymbol())) {

                            JOptionPane.showMessageDialog(
                                    this,
                                    currentPlayer.getSymbol()
                                            + " Wins!");

                            resetGame();
                        }
                        else if (board.checkTie()) {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Tie Game!");

                            resetGame();
                        }
                        else {
                            switchTurn();
                        }
                    }
                });

                buttons[r][c] = btn;
                add(btn);
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void switchTurn() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }

    private void resetGame() {

        board.resetBoard();
        currentPlayer = playerX;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setText("");
            }
        }
    }
}