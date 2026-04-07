import javax.swing.*;

/**
 * A simple Java Swing GUI application that converts temperature from Fahrenheit to Celsius.
 * It includes input validation and error handling for invalid numeric input.
 */
public class Driver {

    /**
     * The main method that launches the GUI for the temperature converter.
     * 
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Create the main frame with a title
        JFrame myFrame = new JFrame("Temperature Converter");

        // Create a panel to hold all UI components
        JPanel panel = new JPanel();

        // Create UI labels and text fields
        JLabel farenheit = new JLabel("Farenheit: ");
        JLabel celsius = new JLabel("Celsius: " );
        JTextField input = new JTextField(5);    // Input field for Fahrenheit
        JTextField output = new JTextField(5);   // Output field for Celsius
        output.setEditable(false);               // Prevent user editing output

        // Create the convert button
        JButton convert = new JButton("Convert");

        /**
         * Action listener for the Convert button.
         * Reads the Fahrenheit input, validates it, converts to Celsius,
         * and displays the result in the output field.
         * If input is invalid, shows an error dialog.
         */
        convert.addActionListener((e) -> {
            try {
                String inputText = input.getText().trim();

                if (inputText.isEmpty()) {
                    throw new NumberFormatException("Input is empty");
                }

                double Farenheit = Double.parseDouble(inputText);
                double Celsius = (Farenheit - 32) * 5 / 9;

                output.setText(String.format("%.2f", Celsius));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(
                    null,
                    "Please enter a valid number for Farenheit.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE
                );
                output.setText("");
            }
        });

        // Add components to the panel
        panel.add(farenheit);
        panel.add(input);
        panel.add(celsius);
        panel.add(output);
        panel.add(convert);

        // Add the panel to the frame and configure frame settings
        myFrame.add(panel);
        myFrame.setSize(500, 500);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }
}