/**
 * Driver class to demonstrate and test the LinkedList implementation.
 */
public class Driver {

    /**
     * The main method creates a LinkedList, adds items, and prints the first, last,
     * and penultimate items.
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("Falcons");
        list.add("Bears");
        list.add("Titans");
        list.add("Eagles");
        list.add("Panthers");
        list.add("Cowboys");
        list.add("Steelers");
        list.add("49ers");
        list.add("Vikings");
        list.add("Saints");
        list.add("Seahawks");

        // Print all items in the list
        list.print();
        System.out.println("\n");

        // Print the first, last, and penultimate items
        System.out.println("First item: " + list.getFirst());
        System.out.println("Last item: " + list.getLast());
        System.out.println("Penultimate item: " + list.getPenultimate());
    }
}