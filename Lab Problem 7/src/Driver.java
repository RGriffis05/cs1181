import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Demonstrates the usage of the generic ComponentList class.
 */
public class Driver {
    /**
     * Program entry point. Creates a JFrame and adds a ComponentList with sample labels.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Set up JFrame
        JFrame frame = new JFrame("ComponentList");
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        // Create ComponentList with JLabels
        ComponentList<JLabel> colorList = new ComponentList<>(new ArrayList<>(Arrays.asList(
            new JLabel("Cyan"),
            new JLabel("White"),
            new JLabel("Blue"),
            new JLabel("Black")
        )));

        // Add more components as described in the assignment
        colorList.add(new JLabel("Cyan"));
        colorList.setComponentAtIndex(0, new JLabel("Red"));

        // Add ComponentList to the main panel
        root.add(colorList);

        frame.setContentPane(root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 200); // Set window size here
        frame.setVisible(true);
    }
}
