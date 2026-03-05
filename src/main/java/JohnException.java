/**
 * Represents application-specific exceptions for user-facing errors.
 */
public class JohnException extends Exception {
    /**
     * Creates an exception with the given message.
     *
     * @param Message Exception message.
     */
    public JohnException(String Message){
        super(Message);
    }
}
