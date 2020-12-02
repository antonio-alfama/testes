package school.mindera.exceptions.filemanager;

import school.mindera.exceptions.filemanager.exceptions.FileNotFoundException;
import school.mindera.exceptions.filemanager.exceptions.NotEnoughPermissionsException;
import school.mindera.exceptions.filemanager.exceptions.NotEnoughSpaceException;

public class FileManager {

    private File[] files;
    boolean loggedIn = false;

    public FileManager(int memoryCapacity) {
        this.files = new File[memoryCapacity];
    }

    public void login() {
        loggedIn = true;
    }

    public void logout() {
        loggedIn = false;
    }

    public void createFile(String name) throws NotEnoughPermissionsException, NotEnoughSpaceException {
        if (!loggedIn) {
            throw new NotEnoughPermissionsException();
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = new File(name);
                return;
            }
        }

        throw new NotEnoughSpaceException();
    }

    public void removeFile(String name) throws NotEnoughPermissionsException, FileNotFoundException {
        if (!loggedIn) {
            throw new NotEnoughPermissionsException();
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].getName().equals(name)) {
                files[i] = null;
                return;
            }
        }

        throw new FileNotFoundException();
    }

    public File getFile(String name) throws NotEnoughPermissionsException, FileNotFoundException {
        if (!loggedIn) {
            throw new NotEnoughPermissionsException();
        }

        for (int i = 0; i < files.length; i++) {
            if (files[i] != null && files[i].getName().equals(name)) {
                return files[i];
            }
        }

        throw new FileNotFoundException();
    }
}
