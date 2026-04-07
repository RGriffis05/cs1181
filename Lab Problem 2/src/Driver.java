import java.util.ArrayList;
import java.util.Collections;

/**
 * Driver class to demonstrate the sorting of Golfer objects
 */

public class Driver {
    /**
     * Main method to create and sort a list of Golfer objects
     * 
     * @param args 
     */
    public static void main(String[] args){
        Golfer g1 = new Golfer("Courtney", "Stormy", 3, 3);
        Golfer g2 = new Golfer("Smith", "Larkin", -3, 2);
        Golfer g3 = new Golfer("Smith", "Donnell", -3, 5);
    
    ArrayList<Golfer> Golfers = new ArrayList<Golfer>();
    Golfers.add(g1);
    Golfers.add(g2);
    Golfers.add(g3);

    System.out.println("Golfers unsorted: ");
    System.out.println(Golfers);

    Collections.sort(Golfers);

    System.out.println("Golfers sorted: ");
    System.out.println(Golfers);
    }
}
