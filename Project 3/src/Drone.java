/**
 * The Drone class models a single drone used for package delivery.
 * <p>
 * Each drone is assigned a unique identifier and uses a constant
 * acceleration to determine its delivery trip time.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class Drone {
    /**
     * The acceleration of the drone in meters per minute squared.
     * This value is used to calculate delivery trip time.
     */
    public static final double droneAcceleration = 34.6; // m/min^2

    /**
     * The unique identifier for the drone.
     */
    private int id;

    /**
     * Constructs a Drone object with a specific ID.
     * 
     * @param id The unique identifier for the drone.
     */
    public Drone(int id){
        this.id = id;
    }

    /**
     * Calculates and returns the time required for the drone to complete its trip.
     * <p>
     * The drone travels a fixed distance (12,000 meters) using constant acceleration.
     * The trip time is computed using the formula: time = sqrt(2 * distance / acceleration)
     * </p>
     * 
     * @return The trip time for the drone, in minutes.
     */
    public double getTripTime(){
        double distance = 12000; // meters
        return Math.sqrt(2 * distance / droneAcceleration);
    }
}