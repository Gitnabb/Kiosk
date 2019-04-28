/**
 * This class represents a custom exception,
 * supposedly to be used whenever we are reading a
 * unwanted input from the Scannner /reader.
 */

public class IncorrectInputException extends Exception {

    /**
     * Constructs the IncorrectInputException with a given message
     * @param message the message to be outputed to the user
     */
    public IncorrectInputException(String message) {
        super(message);
    }

}
