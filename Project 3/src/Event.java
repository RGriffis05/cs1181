/**
 * The Event class represents a significant occurrence in the package delivery simulation,
 * such as a truck or train event, and is used in the event queue for discrete event simulation.
 * <p>
 * Each event records the time at which it occurs, its type, and an associated truck ID
 * (or -1 for train events).
 * </p>
 * 
 * Implements {@link Comparable} to allow events to be sorted by time and by priority.
 * 
 * @author Your Name
 * @version 1.0
 */
public class Event implements Comparable<Event> {

    /**
     * The Type enumeration defines all possible event types in the simulation.
     */
    public enum Type {
        TRUCK_START,   // A truck begins its journey
        TRUCK_ARRIVE,  // A truck arrives at the crossing
        TRUCK_WAIT,    // A truck waits at the crossing (if blocked)
        TRUCK_CROSS,   // A truck crosses the crossing
        TRUCK_END,     // A truck completes its delivery journey
        TRAIN_ARRIVE,  // A train arrives and blocks the crossing
        TRAIN_LEAVE    // A train leaves and unblocks the crossing
    }

    /**
     * The time at which this event occurs (in simulation minutes).
     */
    private double time;

    /**
     * The type of this event.
     */
    private Type type;

    /**
     * The truck ID associated with this event.
     * Use -1 for train events.
     */
    private int truckId;

    /**
     * Constructs an Event with the specified time, type, and truck ID.
     * 
     * @param time    The time at which the event occurs.
     * @param type    The type of the event.
     * @param truckId The ID of the truck associated with the event, or -1 for train events.
     */
    public Event(double time, Type type, int truckId) {
        this.time = time;
        this.type = type;
        this.truckId = truckId;
    }

    /**
     * Returns the time at which this event occurs.
     * 
     * @return The event time, in minutes.
     */
    public double getTime() {
        return time;
    }

    /**
     * Returns the type of this event.
     * 
     * @return The event type.
     */
    public Type getType() {
        return type;
    }

    /**
     * Returns the truck ID associated with this event.
     * For train events, this will be -1.
     * 
     * @return The truck ID, or -1 for train events.
     */
    public int getTruckId() {
        return truckId;
    }

    /**
     * Compares this event with another for ordering in the event queue.
     * <p>
     * Events are first ordered by event time. If times are equal, train events have priority over truck events.
     * If there is still a tie, a truck arrival is prioritized before a truck crossing at the same time.
     * </p>
     * 
     * @param other The other event to compare to.
     * @return Negative if this event should come before the other, positive if after, zero if equal.
     */
    @Override
    public int compareTo(Event other) {
        if(this.time != other.time) {
            return Double.compare(this.time, other.time);
        }
        // Train events always come before truck events at the same time
        if(this.type.toString().startsWith("TRAIN") && !other.type.toString().startsWith("TRAIN")) {
            return -1;
        }
        if((!this.type.toString().startsWith("TRAIN")) && other.type.toString().startsWith("TRAIN")) {
            return 1;
        }
        // Truck arrival before truck crossing if simultaneous
        if(this.type == Type.TRUCK_ARRIVE && other.type == Type.TRUCK_CROSS) {
            return -1;
        }
        if(this.type == Type.TRUCK_CROSS && other.type == Type.TRUCK_ARRIVE) {
            return 1;
        }
        return 0;
    }
}