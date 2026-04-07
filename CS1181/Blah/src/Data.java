import java.io.*;
import java.awt.*;

public class Data {

    static class CouldNotWriteToFile extends Exception {
        public CouldNotWriteToFileException(String message){
            super(message);
        }
    }

    //returns a boolean
    public static boolean writeData(String person, Color c){
        PrintWriter pw = null;

        try{

            pw = new PrintWriter(new File("data.csv"));
            pw.write(person + ", " + c.toString());

        } catch(IOException ioe) {

            throw new CouldNotWriteToFileException("could not write to data.csv");
            return false;
        } finally {
            pw.close();
        }

        return true;
    }

}
