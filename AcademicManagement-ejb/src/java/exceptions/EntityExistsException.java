package exceptions;

public class EntityExistsException extends Exception {

    public EntityExistsException() {
    }

    public EntityExistsException(String msg) {
        super(msg);
    }
}
