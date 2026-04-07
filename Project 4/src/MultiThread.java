import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * A multi-threaded brute-force password cracker for a ZIP file.
 * Uses the Zip4j library to attempt to extract a protected ZIP file
 * by generating and testing all possible 5-letter lowercase passwords.
 */
public class MultiThread {

    /** The ZIP file to crack. */
    static final String ZIP_NAME = "protected5.zip";

    /** The length of the password to brute-force. */
    static final int PASSWORD_LENGTH = 5;

    /** The alphabet used to generate passwords. */
    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    /** Indicates whether the password has been found by any thread. */
    static volatile boolean passwordFound = false;

    /** Stores the found password once discovered. */
    static String foundPassword = "";

    /** Number of threads to use for cracking. */
    static int numThreads = 1;  /**
                                Run time with 1 thread, 3,541,328 ms
                                Run time with 2 threads, 3,942,511 ms
                                Run time with 3 threads, 4,023,805 ms
                                Run time with 4 threads, 499,642 ms
                                Run time with 8 threads, 11657 ms
                                Run time with 16 threads, 18,024 ms
                                */

    /**
     * Main method that initiates the multithreaded brute-force attack.
     *
     * @param args command-line arguments (unused)
     */
    public static void main(String[] args){
        long timeStart = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();

        List<String> segments = threadsAlphabet(numThreads);
        for(int i = 0; i < numThreads; i++){
            Thread t = new Thread(new Worker(i, segments.get(i)));
            System.out.println("Thread " + i + " gets: " + segments.get(i));
            threads.add(t);
            t.start();
        }

        for(Thread t : threads){
            try{
                t.join();
            } catch (InterruptedException ie){
                ie.printStackTrace();
            }
        }

        long timeEnd = System.currentTimeMillis();

        if (passwordFound) {
            System.out.println("Password found: " + foundPassword);
        } else {
            System.out.println("Password not found.");
        }
        System.out.println("Time taken: " + (timeEnd - timeStart) + " ms");
    }

    /**
     * Splits the alphabet into approximately equal segments for each thread.
     *
     * @param numParts number of segments to divide the alphabet into
     * @return a list of alphabet segments, one per thread
     */
    public static List<String> threadsAlphabet(int numParts){
        List<String> parts = new ArrayList<>();
        int baseSize = ALPHABET.length() / numParts;
        int extra = ALPHABET.length() % numParts;
        int index = 0;

        for(int i = 0; i < numParts; i++){
            int partSize = baseSize + (i < extra ? 1: 0);
            parts.add(ALPHABET.substring(index, index + partSize));
            index += partSize;
        }

        return parts;
    }

    /**
     * Represents a worker thread that attempts to crack the password
     * using a subset of starting letters from the alphabet.
     */
    static class Worker implements Runnable {
        int id;
        String assignedLetters;
        long startTime;

        /**
         * Constructs a worker with an ID and assigned alphabet segment.
         *
         * @param id thread ID
         * @param assignedLetters segment of alphabet assigned to this thread
         */
        Worker(int id, String assignedLetters){
            this.id = id;
            this.assignedLetters = assignedLetters;
        }

        /**
         * Main execution logic for the worker thread.
         * Copies the ZIP file, then recursively generates and tests passwords.
         */
        @Override
        public void run(){
            startTime = System.currentTimeMillis();
            String zipCopy = "copy" + id + ".zip";
            String output = "contents-" + id;

            try{
                System.out.println("Thread " + id + ": checking for file " + ZIP_NAME + "...");
                System.out.println("Exists? " + Files.exists(Path.of(ZIP_NAME)));
                Files.copy(Path.of(ZIP_NAME), Path.of(zipCopy));
                passwords("", PASSWORD_LENGTH, zipCopy, output);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                cleanUp(zipCopy, output);
            }
        }

        /**
         * Recursively builds password combinations and attempts to extract the ZIP file.
         *
         * @param prefix current prefix of the password being built
         * @param length total length of passwords to try
         * @param zipFileName the ZIP file to crack
         * @param output the directory to extract the contents into
         * @throws Exception in case of I/O or Zip4j errors
         */
        private void passwords(String prefix, int length, String zipFileName, String output) throws Exception {
            if(passwordFound) return;

            if(prefix.length() == length){
                try{
                    System.out.println("Trying: " + prefix);
                    ZipFile zipFile = new ZipFile(zipFileName);
                    zipFile.setPassword(prefix);
                    zipFile.extractAll(output);
                    foundPassword = prefix;
                    passwordFound = true;
                } catch (ZipException ze){
                    // Wrong password; do nothing
                }
                return;
            }

            if(prefix.isEmpty()){
                for(char c : assignedLetters.toCharArray()){
                    passwords(prefix + c, length, zipFileName, output);
                }
            } else {
                for(char c = 'a'; c <= 'z'; c++){
                    passwords(prefix + c, length, zipFileName, output);
                }
            }
        }

        /**
         * Cleans up temporary files created by this thread after execution.
         *
         * @param zipFileName temporary ZIP copy used by this thread
         * @param output extracted contents directory used by this thread
         */
        private void cleanUp(String zipFileName, String output){
            try{
                Files.deleteIfExists(Path.of(zipFileName));

                File dir = new File(output);
                if(dir.exists()){
                    for(File file : dir.listFiles()){
                        file.delete();
                    }
                    dir.delete();
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}