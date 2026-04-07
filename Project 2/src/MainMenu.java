import javax.swing.*;
import java.awt.*;

/**
 * The MainMenu class creates the main menu window for the Tic-Tac-Toe game.
 * It includes the game title, a "Start Game" button to launch the game,
 * and an "Instructions" button to display game instructions.
 */
public class MainMenu extends JFrame {

    private JLabel gameName;         // Displays the game title
    private JLabel empty;            // Spacer label for layout spacing
    private JButton start;           // Button to start the game
    private JButton instructions;    // Button to show instructions

    /**
     * Constructs the MainMenu window, initializes UI components,
     * and adds action listeners to respond to user interactions.
     */
    public MainMenu() {
        JPanel panel = new JPanel();
        GridBagConstraints layoutConst;

        gameName = new JLabel("Tic-Tac-Toe");
        empty = new JLabel("             "); // Spacer
        start = new JButton("Start Game");
        instructions = new JButton("Instructions");

        // Launches the GameBoard when "Start Game" is clicked
        start.addActionListener((e -> {
            new GameBoard();
        }));

        // Launches the InstructionsFrame when "Instructions" is clicked
        instructions.addActionListener((e -> {
            new InstructionsFrame();
        }));

        panel.setLayout(new GridBagLayout());

        // Add game title
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 0;
        panel.add(gameName, layoutConst);

        // Add spacer
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        panel.add(empty, layoutConst);

        // Add start button
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 2;
        panel.add(start, layoutConst);

        // Add instructions button
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        panel.add(instructions, layoutConst);

        this.add(panel);

        this.setTitle("Tic-Tac-Toe");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null); // Center the window
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit entire application on close
    }
}