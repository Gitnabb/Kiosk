/**
 * This class represents a custom exception,
 * supposedly to be used whenever we are reading a unwanted
 * negative input from the Scannner /reader.
 *
 *  @author <Andreas Øie>
 *  @version 1.0
 */

public class NegativeIntegerException extends Exception {

    /**
     * Constructs the NegativeIntegerException with a given message
     * @param message the message to be outputed to the user
     */
    public NegativeIntegerException(String message) {
        super(message);
    }

}
