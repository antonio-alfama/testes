package school.mindera.exceptions.filemanager.exceptions;

public class FileManagerException extends Exception {

    protected static final String FILE_NOT_FOUND = "The requested file was not found.";
    protected static final String NOT_ENOUGH_PERMISSIONS = "Clearance level not high enough.";
    protected static final String NOT_ENOUGH_SPACE = "The disk is full, please free some space.";

    public FileManagerException(String message) {
        super(message);
    }
}
