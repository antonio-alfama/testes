package school.mindera.exceptions.filemanager.exceptions;

public class NotEnoughPermissionsException extends FileManagerException {
    public NotEnoughPermissionsException() {
        super(NOT_ENOUGH_PERMISSIONS);
    }
}
