import java.util.*;

/**
 * Contains method for simulating the tile game using stack and queue.
 */
public class TileGame {

    /**
     * Simulates the tile game.
     * @param stack The stack of tiles (ArrayDeque used as a stack).
     * @param q The queue of additional tiles (Queue interface).
     * @return Number of turns it takes for the stack to become empty.
     */
    public static int tileGame(ArrayDeque<Integer> stack, Queue<Integer> q) {
        int turns = 0;

        while (!stack.isEmpty()) {
            turns++;
            int tile = stack.pop();

            if (tile == 1) {
                // Remove tile and one more from stack (if present)
                if (!stack.isEmpty()) stack.pop();
            } else if (tile == 2) {
                // Remove tile and two more from stack (if present)
                for (int i = 0; i < 2; i++) {
                    if (!stack.isEmpty()) stack.pop();
                }
            } else if (tile == 3) {
                // Remove tile, then push next three from queue to stack
                for (int i = 0; i < 3; i++) {
                    if (!q.isEmpty()) stack.push(q.poll());
                }
            }
        }

        return turns;
    }
}