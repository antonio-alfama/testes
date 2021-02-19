package school.mindera.exceptions.filemanager;

import school.mindera.exceptions.filemanager.exceptions.FileNotFoundException;
import school.mindera.exceptions.filemanager.exceptions.NotEnoughPermissionsException;
import school.mindera.exceptions.filemanager.exceptions.NotEnoughSpaceException;

public class Main {

    public static void main(String[] args) {

        FileManager fileDaniManager = new FileManager(2);

        //
        try {
            fileDaniManager.createFile("Batata.dani");
        } catch (NotEnoughPermissionsException | NotEnoughSpaceException e) {
            System.out.printf("[ERROR] %s [End of error]%n", e.getMessage());
        }

        fileDaniManager.login();

        try {
            fileDaniManager.createFile("Jooins.dani");
            System.out.println(fileDaniManager.getFile("Jooins.dani"));
        } catch (NotEnoughPermissionsException | FileNotFoundException | NotEnoughSpaceException e) {
            System.out.printf("[ERROR] %s [End of error]%n", e.getMessage());
        }

        try {
            fileDaniManager.createFile("Canetas.dani");
            System.out.println(fileDaniManager.getFile("Canetas.dani"));

            fileDaniManager.createFile("Portooooo.dani");
            System.out.println(fileDaniManager.getFile("Canetas.dani"));
        } catch (NotEnoughPermissionsException | FileNotFoundException | NotEnoughSpaceException e) {
            System.out.printf("[ERROR] %s [End of error]%n", e.getMessage());
        }

        try {
            fileDaniManager.removeFile("Caneta.dani");
        } catch (NotEnoughPermissionsException | FileNotFoundException e) {
            System.out.printf("[ERROR] %s [End of error]%n", e.getMessage());
        }

        try {
            fileDaniManager.removeFile("Canetas.dani");
            System.out.println("File deleted");
        } catch (NotEnoughPermissionsException | FileNotFoundException e) {
            System.out.printf("[ERROR] %s [End of error]%n", e.getMessage());
        }

        try {
            System.out.println(fileDaniManager.getFile("Canetas.dani"));
        } catch (NotEnoughPermissionsException | FileNotFoundException e) {
            System.out.printf("[ERROR] %s [End of error]%n", e.getMessage());
        }


    }

}
