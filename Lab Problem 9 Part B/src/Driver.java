import java.util.*;

/**
 * Driver class to test the TileGame simulation.
 * <p>
 * This class initializes a stack and a queue of integers as specified in the
 * assignment and calls the tileGame method to determine the number of turns
 * required for the stack to become empty. The result is then printed to the console.
 * </p>
 */
public class Driver {

    /**
     * The main method creates a queue and stack of integers with sample values,
     * calls the TileGame.tileGame() method, and prints the number of turns taken
     * to finish the game.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Initialize the queue with the given sequence of integers
        Queue<Integer> q = new ArrayDeque<>(Arrays.asList(1, 2, 2, 1, 3, 1, 2, 1, 2, 3));
        
        // Initialize the stack with the given sequence (bottom to top: 2, 1, 2, then push 3 on top)
        ArrayDeque<Integer> stack = new ArrayDeque<>(Arrays.asList(2, 1, 2));
        stack.push(3);

        // Call the tileGame method and get the number of turns taken to finish
        int turns = TileGame.tileGame(stack, q);

        // Print the result
        System.out.println("Stack and queue took " + turns + " turns to finish playing.");
    }
}
