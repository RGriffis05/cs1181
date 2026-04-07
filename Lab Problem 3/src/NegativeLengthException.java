/**
 * A custom checked exception thrown when a negative length value is provided
 */

public class NegativeLengthException extends Exception {

    /**
     * Constructs a NegativeLengthException with a specified message
     * 
     * @param message the detail message about the exception
     */

    public NegativeLengthException(String message){
        super(message);

    }

}
