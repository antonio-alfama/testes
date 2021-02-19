package school.mindera.exceptions.filemanager.exceptions;

public class FileNotFoundException extends FileManagerException {
    public FileNotFoundException() {
        super(FILE_NOT_FOUND);
    }
}
