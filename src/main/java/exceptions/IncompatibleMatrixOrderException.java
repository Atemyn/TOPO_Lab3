package exceptions;

public class IncompatibleMatrixOrderException extends MatrixOperationException {
    public IncompatibleMatrixOrderException(String message) {
        super(message);
    }
}
