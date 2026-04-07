import javax.swing.*;
import java.io.*;
import java.nio.file.*;

/**
 * A JFrame window that displays a scrollable text area for showing game instructions.
 * The instructions are read from a specified text file ("Instructions.txt").
 */
public class InstructionsFrame extends JFrame {

    private JScrollPane scroll;
    private JTextArea instructions;
    private JPanel panel;

    /**
     * Constructs the InstructionsFrame window, sets up the layout and components,
     * and loads the instructions text file into the text area.
     */
    public InstructionsFrame() {

        this.setTitle("Tic-Tac-Toe");

        panel = new JPanel();

        instructions = new JTextArea();
        instructions.setEditable(false);

        scroll = new JScrollPane(instructions,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panel.add(scroll);
        this.add(panel);

        loadTextFile("Instructions.txt");

        this.setSize(500, 500);
        this.setLocationRelativeTo(null); // center the frame on screen
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //I got this line of code from https://docs.oracle.com/en/java/javase/11/docs/api/java.desktop/javax/swing/JFrame.html?is-external=true
    }

    /**
     * Loads the content of a text file and displays it in the text area.
     *
     * @param filePath The path to the text file to be read.
     */
    private void loadTextFile(String filePath) {
        try {
            String content = Files.readString(Paths.get(filePath));
            instructions.setText(content);
        } catch (IOException e) {
            instructions.setText("Error reading file:\n" + e.getMessage());
        }
    }
}