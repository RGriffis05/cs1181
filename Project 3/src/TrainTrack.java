import java.io.*;
import java.util.*;

/**
 * The TrainTrack class represents the train schedule and manages
 * information about when the train blocks the crossing in the simulation.
 * <p>
 * This class reads a train schedule from a file and provides methods
 * to determine if the crossing is blocked at a particular time and
 * to print or query the train schedule.
 * </p>
 * 
 * @author Your Name
 * @version 1.0
 */
public class TrainTrack {

    /**
     * List of start times (in minutes) when the train begins blocking the crossing.
     */
    private List<Integer> startTimes = new ArrayList<>();

    /**
     * List of durations (in minutes) for each corresponding train block.
     */
    private List<Integer> durations = new ArrayList<>();

    /**
     * Constructs a TrainTrack object and loads the train schedule from a file.
     * <p>
     * The schedule file should contain lines of the form "start duration",
     * where start is the minute the train begins blocking the crossing and
     * duration is the number of minutes the crossing is blocked.
     * </p>
     * 
     * @param filename The path to the train schedule file.
     * @throws IOException If there is an error reading the file.
     */
    public TrainTrack(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("\\s+");
            if (parts.length == 2) {
                startTimes.add(Integer.parseInt(parts[0]));
                durations.add(Integer.parseInt(parts[1]));
            }
        }
        br.close();
    }

    /**
     * Determines if the crossing is blocked by a train at the specified time.
     * 
     * @param time The simulation time in minutes.
     * @return true if the crossing is blocked, false otherwise.
     */
    public boolean isBlocked(double time) {
        for (int i = 0; i < startTimes.size(); i++) {
            int start = startTimes.get(i);
            int end = start + durations.get(i);
            if (time >= start && time < end) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the next time after the specified moment when the crossing becomes unblocked.
     * 
     * @param time The current simulation time in minutes.
     * @return The time (in minutes) when the crossing will next be unblocked,
     *         or Double.POSITIVE_INFINITY if there are no more train blocks.
     */
    public double nextUnblockTime(double time) {
        for (int i = 0; i < startTimes.size(); i++) {
            int start = startTimes.get(i);
            int end = start + durations.get(i);
            if (time < end) {
                return end;
            }
        }
        return Double.POSITIVE_INFINITY;
    }

    /**
     * Prints the entire train schedule to the console in a readable format.
     */
    public void printSchedule() {
        System.out.println("TRAIN SCHEDULE");
        System.out.println("---------------");
        for (int i = 0; i < startTimes.size(); i++) {
            System.out.println(startTimes.get(i) + "-" + (startTimes.get(i) + durations.get(i)));
        }
        System.out.println();
    }

    /**
     * Returns the list of train block start times.
     * 
     * @return List of start times in minutes.
     */
    public List<Integer> getStartTimes() {
        return startTimes;
    }

    /**
     * Returns the list of train block durations.
     * 
     * @return List of durations in minutes.
     */
    public List<Integer> getDurations() {
        return durations;
    }
}