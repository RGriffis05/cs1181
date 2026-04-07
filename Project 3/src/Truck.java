/**
 * The Truck class represents a truck used in the package delivery simulation.
 * <p>
 * Each truck has a unique identifier and records various times relevant to its delivery journey:
 * departure, arrival at the crossing, crossing, end of journey, and total trip time.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class Truck {
    /** The unique identifier for the truck. */
    private int id;

    /** The time (in minutes) when the truck departs from the depot. */
    private double departTime;

    /** The time (in minutes) when the truck arrives at the train crossing. */
    private double atCrossingTime;

    /** The time (in minutes) when the truck crosses the tracks. */
    private double crossTime;

    /** The time (in minutes) when the truck completes its delivery. */
    private double endTime;

    /** The total trip time (in minutes) from departure to delivery completion. */
    private double tripTime;

    /**
     * Constructs a new Truck with the given ID.
     * 
     * @param id The unique identifier for this truck.
     */
    public Truck(int id){
        this.id = id;
    }

    /**
     * Returns the unique identifier for this truck.
     * 
     * @return The truck's ID.
     */
    public int getId(){
        return id;
    }

    /**
     * Sets the time when the truck departs from the depot.
     * 
     * @param t The departure time in minutes.
     */
    public void setDepartTime(double t){
        departTime = t;
    }

    /**
     * Sets the time when the truck arrives at the crossing.
     * 
     * @param t The arrival time at the crossing in minutes.
     */
    public void setAtCrossingTime(double t){
        atCrossingTime = t;
    }

    /**
     * Sets the time when the truck crosses the tracks.
     * 
     * @param t The crossing time in minutes.
     */
    public void setCrossTime(double t){
        crossTime = t;
    }

    /**
     * Sets the time when the truck completes its delivery.
     * 
     * @param t The delivery completion time in minutes.
     */
    public void setEndTime(double t){
        endTime = t;
    }

    /**
     * Sets the total trip time for the truck from departure to delivery.
     * 
     * @param t The total trip time in minutes.
     */
    public void setTripTime(double t){
        tripTime = t;
    }

    /**
     * Returns the time when the truck departed from the depot.
     * 
     * @return The departure time in minutes.
     */
    public double getDepartTime(){
        return departTime;
    }

    /**
     * Returns the time when the truck arrived at the crossing.
     * 
     * @return The arrival time at the crossing in minutes.
     */
    public double getAtCrossingTime(){
        return atCrossingTime;
    }

    /**
     * Returns the time when the truck crossed the tracks.
     * 
     * @return The crossing time in minutes.
     */
    public double getCrossTime(){
        return crossTime;
    }

    /**
     * Returns the time when the truck completed its delivery.
     * 
     * @return The delivery completion time in minutes.
     */
    public double getEndTime(){
        return endTime;
    }

    /**
     * Returns the total trip time for the truck.
     * 
     * @return The total trip time in minutes.
     */
    public double getTripTime(){
        return tripTime;
    }
}