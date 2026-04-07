import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple graphical Tic-Tac-Toe game using Java Swing.
 * It supports two-player interaction, turn tracking, and win detection.
 */
public class Driver {

    /**
     * The main method that creates and runs the TicTacToe window.
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Create the main window
        JFrame mainWindow = new JFrame();
        mainWindow.setTitle("Tic-Tac-Toe");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setSize(250, 250);
        mainWindow.setLocationRelativeTo(null);

        // Label to display game status (whose turn or who won)
        JLabel statusLabel = new JLabel("Game Status: Player 1's turn");
        mainWindow.add(statusLabel, BorderLayout.SOUTH);

        // Create a 3x3 grid panel for buttons
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3));

        // Array to store all 9 buttons (squares)
        JButton[] buttons = new JButton[9];

        // Boolean array to track whose turn it is (true = Player 1)
        final boolean[] isPlayer1Turn = { true };

        // Flag to stop the game after a win
        final boolean[] gameOver = { false };

        // Create and add buttons to the grid
        for (int i = 0; i < 9; ++i) {
            buttons[i] = new JButton(String.valueOf(""));
            buttons[i].setFont(new Font("Arial", Font.BOLD, 24));
            gridPanel.add(buttons[i]);

            int index = i; // required for use inside lambda

            // Add click event listener for each button
            buttons[i].addActionListener(e -> {
                // If the game is already over, do nothing
                if (gameOver[0]) return;

                // If button is already marked, ignore click
                String currentText = buttons[index].getText();
                if (currentText.equals("X") || currentText.equals("O")) return;

                // Mark button based on player turn and update status
                if (isPlayer1Turn[0]) {
                    buttons[index].setText("X");
                    statusLabel.setText("Game Status: Player 2's turn");
                } else {
                    buttons[index].setText("O");
                    statusLabel.setText("Game Status: Player 1's turn");
                }

                // Check for a win
                if (checkWin(buttons)) {
                    gameOver[0] = true;
                    String winner = isPlayer1Turn[0] ? "Player 1 (X)" : "Player 2 (O)";
                    statusLabel.setText(winner + " wins!");
                }

                // Switch turns
                isPlayer1Turn[0] = !isPlayer1Turn[0];
            });
        }

        // Add grid to center of window
        mainWindow.add(gridPanel, BorderLayout.CENTER);
        mainWindow.setVisible(true);
    }

    /**
     * Checks whether there is a winning combination on the board.
     * @param b the array of buttons representing the TicTacToe board
     * @return true if a player has won, false otherwise
     */
    private static boolean checkWin(JButton[] b) {
        // All winning patterns (rows, columns, diagonals)
        int[][] winPatterns = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
            {0, 4, 8}, {2, 4, 6}             // diagonals
        };

        for (int[] pattern : winPatterns) {
            String s1 = b[pattern[0]].getText();
            String s2 = b[pattern[1]].getText();
            String s3 = b[pattern[2]].getText();

            // Check if all three buttons are marked the same and not numbers
            if ((s1.equals("X") || s1.equals("O")) && s1.equals(s2) && s2.equals(s3)) {
                // Optionally highlight winning buttons
                b[pattern[0]].setBackground(Color.GREEN);
                b[pattern[1]].setBackground(Color.GREEN);
                b[pattern[2]].setBackground(Color.GREEN);
                return true;
            }
        }

        return false;
    }
}