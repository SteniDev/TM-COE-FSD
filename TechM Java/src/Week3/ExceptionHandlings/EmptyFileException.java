package Week3.ExceptionHandlings;

public class EmptyFileException extends Exception {
    public EmptyFileException(String message) {
        super(message);
    }
}
