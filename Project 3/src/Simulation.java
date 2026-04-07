import java.util.*;
import java.io.*;

/**
 * The Simulation class models the discrete event simulation for the package delivery system.
 * <p>
 * It manages the creation and scheduling of trucks, drones, and train events, and
 * processes the simulation event queue in time order. At the end of the simulation,
 * delivery statistics are printed to the console.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
public class Simulation {

    /** Number of packages a truck can carry. */
    private static final int TRUCK_CAPACITY = 10;

    /** Offset (in minutes) between each truck's departure. */
    private static final double TRUCK_OFFSET = 15.0;

    /** Time (in minutes) for a truck to drive from the depot to the crossing. */
    private static final double TRUCK_TO_CROSSING = 100.0;

    /** Time (in minutes) required for a truck to cross the train tracks. */
    private static final double TRUCK_CROSS_TIME = 1.0;

    /** Time (in minutes) for a truck to travel from the crossing to the destination. */
    private static final double TRUCK_FINISH = 900.0;

    /** Total number of packages to deliver in the simulation. */
    private int numPackages;

    /** Fraction of packages delivered by drones (e.g., 0.25 for 25%). */
    private double percentByDrone;

    /** Number of drones used in the simulation. */
    private int numDrones;

    /** Number of trucks used in the simulation. */
    private int numTrucks;

    /** List of Drone objects participating in the simulation. */
    private List<Drone> drones = new ArrayList<>();

    /** List of Truck objects participating in the simulation. */
    private List<Truck> trucks = new ArrayList<>();

    /** TrainTrack object modeling the schedule of train crossings. */
    private TrainTrack trainTrack;

    /** Priority queue holding all scheduled events (ordered by event time and type). */
    private PriorityQueue<Event> eventQueue = new PriorityQueue<>();

    /** Map from truck ID to Truck object for quick lookup. */
    private Map<Integer, Truck> truckMap = new HashMap<>();

    /**
     * Constructs a new Simulation object and sets up the trucks, drones, and train schedule.
     *
     * @param numPackages    Total number of packages to deliver.
     * @param percentByDrone Fraction of packages delivered by drones (e.g., 0.25 for 25%).
     * @param scheduleFile   File name of the train schedule.
     * @throws IOException   If there is an error reading the train schedule file.
     */
    public Simulation(int numPackages, double percentByDrone, String scheduleFile) throws IOException {
        this.numPackages = numPackages;
        this.percentByDrone = percentByDrone;
        this.trainTrack = new TrainTrack(scheduleFile);
        this.numDrones = (int) Math.round(numPackages * percentByDrone);
        int truckPackages = numPackages - numDrones;
        this.numTrucks = (int) Math.ceil(truckPackages / (double) TRUCK_CAPACITY);

        for (int i = 0; i < numDrones; i++) {
            drones.add(new Drone(i));
        }
        for (int i = 0; i < numTrucks; i++) {
            Truck t = new Truck(i);
            trucks.add(t);
            truckMap.put(i, t);
        }
    }

    /**
     * Runs the event-driven simulation, processing truck and train events in time order.
     * <p>
     * Schedules all initial events, then processes them until the event queue is empty.
     * Handles truck departures, arrivals, waiting at the crossing, crossing, and completion,
     * as well as train arrival and departure at the crossing.
     * </p>
     */
    public void run() {
        // Schedule truck starts
        for (int i = 0; i < numTrucks; i++) {
            eventQueue.add(new Event(i * TRUCK_OFFSET, Event.Type.TRUCK_START, i));
        }

        // Schedule train events
        List<Integer> starts = trainTrack.getStartTimes();
        List<Integer> durations = trainTrack.getDurations();
        for (int i = 0; i < starts.size(); i++) {
            eventQueue.add(new Event(starts.get(i), Event.Type.TRAIN_ARRIVE, -1));
            eventQueue.add(new Event(starts.get(i) + durations.get(i), Event.Type.TRAIN_LEAVE, -1));
        }

        double now = 0.0;
        Set<Integer> trucksWaiting = new LinkedHashSet<>();

        while (!eventQueue.isEmpty()) {
            Event e = eventQueue.poll();
            now = e.getTime();

            switch (e.getType()) {
                case TRUCK_START:
                    Truck truck = truckMap.get(e.getTruckId());
                    truck.setDepartTime(now);
                    System.out.printf("%.1f: TRUCK #%d begins journey%n", now, truck.getId());
                    double arrival = now + TRUCK_TO_CROSSING;
                    truck.setAtCrossingTime(arrival);
                    eventQueue.add(new Event(arrival, Event.Type.TRUCK_ARRIVE, truck.getId()));
                    break;

                case TRUCK_ARRIVE:
                    truck = truckMap.get(e.getTruckId());
                    if (trainTrack.isBlocked(now) || !trucksWaiting.isEmpty()) {
                        System.out.printf("%.1f: TRUCK #%d waits at crossing%n", now, truck.getId());
                        trucksWaiting.add(truck.getId());
                    } else {
                        System.out.printf("%.1f: TRUCK #%d crosses crossing%n", now, truck.getId());
                        truck.setCrossTime(now);
                        double end = now + TRUCK_CROSS_TIME + TRUCK_FINISH;
                        truck.setEndTime(end);
                        // Schedule TRUCK_END after full delivery
                        eventQueue.add(new Event(end, Event.Type.TRUCK_END, truck.getId()));
                    }
                    break;

                case TRAIN_ARRIVE:
                    System.out.printf("%.1f: TRAIN arrives at crossing%n", now);
                    break;

                case TRAIN_LEAVE:
                    System.out.printf("%.1f: TRAIN leaves crossing%n", now);
                    double t = now + 1.0;
                    for (int truckId : trucksWaiting) {
                        System.out.printf("%.1f: TRUCK #%d crosses crossing%n", t, truckId);
                        Truck waitingTruck = truckMap.get(truckId);
                        waitingTruck.setCrossTime(t);
                        double end = t + TRUCK_CROSS_TIME + TRUCK_FINISH;
                        waitingTruck.setEndTime(end);
                        // Schedule TRUCK_END after full delivery
                        eventQueue.add(new Event(end, Event.Type.TRUCK_END, truckId));
                        t += 1.0;
                    }
                    trucksWaiting.clear();
                    break;

                case TRUCK_END:
                    truck = truckMap.get(e.getTruckId());
                    System.out.printf("%.1f: TRUCK #%d completes journey%n", now, truck.getId());
                    truck.setTripTime(now - truck.getDepartTime());
                    break;
            }
        }
    }

    /**
     * Prints summary statistics for all trucks and drones after the simulation is complete.
     * <ul>
     *   <li>Number of drones and trucks used</li>
     *   <li>Train schedule</li>
     *   <li>Trip time for each truck</li>
     *   <li>Average and maximum truck trip times</li>
     *   <li>Drone trip time and total drone time</li>
     *   <li>Total time for all packages to be delivered</li>
     * </ul>
     */
    public void printStats() {
        System.out.printf("%nWith %.1f%% drones and %d packages,%n", percentByDrone * 100, numPackages);
        System.out.printf("There will be:\n -%d drones\n -%d trucks%n\n", numDrones, numTrucks);
        trainTrack.printSchedule();

        double truckTotal = 0.0;
        double truckMax = 0.0;

        for (Truck t : trucks) {
            double trip = t.getTripTime();
            truckTotal += trip;
            if (trip > truckMax) truckMax = trip;
        }

        double truckAvg = truckTotal / trucks.size();
        System.out.println("STATS\n----------");

        for (Truck t : trucks) {
            System.out.printf("TRUCK #%d total trip time: %.1f minutes%n", t.getId(), t.getTripTime());
        }
        System.out.printf("\nTRUCK AVG TRIP TIME: %.1f minutes%n", truckAvg);
        System.out.printf("TRUCK TOTAL TIME: %.1f minutes%n", truckMax);

        Drone d = new Drone(0);
        double droneTripTime = d.getTripTime();
        System.out.printf("\nDRONE TRIP TIME: %.1f minutes%n", droneTripTime);
        System.out.printf("DRONE TOTAL TIME: %.1f minutes%n", droneTripTime);
        System.out.printf("\nTOTAL TIME: %.1f minutes%n\n", Math.max(truckMax, droneTripTime));
        System.out.println("THIS ENDS THE SIMULATION");
    }
}