/**
 * The Driver class contains the main method and launches the
 * package delivery simulation for CS1181 Project 3.
 * <p>
 * To run the simulation, this class creates a {@link Simulation}
 * object, specifying the number of packages, the percentage of
 * packages delivered by drones, and the filename containing the
 * train schedule. The simulation is then executed, and statistics
 * are printed to the console.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class Driver {
    /**
     * The percentage of packages delivered by drones.
     * <p>
     * Adjust this value to optimize the delivery system and find the
     * percentage that minimizes total delivery time.
     * </p>
     */
    public static final double PERCENT_BY_DRONE = 0.25;

    /**
     * The entry point for the package delivery simulation.
     * <p>
     * This method creates a Simulation object, runs the simulation,
     * and prints the results. If an error occurs while reading the
     * train schedule file or during simulation execution, a stack
     * trace is printed.
     * </p>
     * 
     * @param args Not used.
     */
    public static void main(String[] args){
        try{
            Simulation sim = new Simulation(1500, PERCENT_BY_DRONE, "train_schedule.txt");
            sim.run();
            sim.printStats();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
