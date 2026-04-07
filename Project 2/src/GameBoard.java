import javax.swing.*;
import java.awt.*;

/**
 * A simple Tic-Tac-Toe game implemented using Java Swing.
 * The game allows two players to take turns and determines a winner or a draw.
 */
public class GameBoard extends JFrame {

    private JPanel gamePanel;
    private JButton square;
    private JLabel status;
    private int turnCounter = 0;
    private boolean gameOver = false; // track if game is over
    private JButton[] squares = new JButton[9]; // Array to store board buttons

    /**
     * Constructs the game window, initializes UI components,
     * and sets up the Tic-Tac-Toe board with 9 buttons and a status label.
     */
    public GameBoard() {

        gamePanel = new JPanel();
        status = new JLabel("Turn: X");

        this.setTitle("Tic-Tac-Toe");
        gamePanel.setLayout(new GridLayout(4, 3)); // 3x3 grid + status label

        for (int i = 0; i < 9; i++) {

            square = new JButton();
            squares[i] = square; // store reference to each button
            gamePanel.add(square);

            int index = i;

            square.addActionListener((e) -> {
                if (gameOver) return; // Exit early if game is already over

                if ((turnCounter % 2 == 0)) {
                    ((JButton) e.getSource()).setText("X");
                    ((JButton) e.getSource()).setEnabled(false);
                    turnCounter++;
                    status.setText("Turn: O");
                } else {
                    ((JButton) e.getSource()).setText("O");
                    ((JButton) e.getSource()).setEnabled(false);
                    turnCounter++;
                    status.setText("Turn: X");
                }

                // Check for win or draw
                if (checkWinner()) {
                    String winner = ((JButton) e.getSource()).getText();
                    status.setText("Winner: " + winner);
                    disableAllButtons();
                    gameOver = true;
                } else if (turnCounter == 9) {
                    status.setText("It's a draw!");
                    gameOver = true;
                }
            });
        }

        gamePanel.add(status);
        this.add(gamePanel);

        this.setSize(250, 250);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //I had help this line of code from https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JFrame.html?is-external=true
    }

    /**
     * Checks if there is a winner on the board.
     *
     * @return true if a player has won the game, false otherwise
     */
    private boolean checkWinner() {
        String[][] board = new String[3][3];

        // Convert flat button array into 2D string array for easier checking
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = squares[i].getText();
        }

        // Check rows and columns for a win
        for (int i = 0; i < 3; i++) {
            if (!board[i][0].isEmpty() &&
                board[i][0].equals(board[i][1]) &&
                board[i][1].equals(board[i][2])) {
                return true;
            }

            if (!board[0][i].isEmpty() &&
                board[0][i].equals(board[1][i]) &&
                board[1][i].equals(board[2][i])) {
                return true;
            }
        }

        // Check diagonals for a win
        if (!board[0][0].isEmpty() &&
            board[0][0].equals(board[1][1]) &&
            board[1][1].equals(board[2][2])) {
            return true;
        }

        if (!board[0][2].isEmpty() &&
            board[0][2].equals(board[1][1]) &&
            board[1][1].equals(board[2][0])) {
            return true;
        }

        return false;
    }

    /**
     * Disables all buttons on the board, ending the game.
     */
    private void disableAllButtons() {
        for (JButton b : squares) {
            b.setEnabled(false);
        }
    }
}