package school.mindera.exceptions.filemanager.exceptions;

public class NotEnoughSpaceException extends FileManagerException {
    public NotEnoughSpaceException() {
        super(NOT_ENOUGH_SPACE);
    }
}
