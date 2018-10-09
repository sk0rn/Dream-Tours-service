package utils.exceptions;

public class InvalidNumberOfArgumentsException extends RuntimeException {

    public InvalidNumberOfArgumentsException() {
        super("Invalid number of arguments");
    }

    public InvalidNumberOfArgumentsException(String message) {
        super(message);
    }
}
