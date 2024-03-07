package uz.pdp.blogging.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message){
        super(message + " is already exists");
    }
}
