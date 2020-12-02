package school.mindera.streams;

import java.io.*;

public class FileManager {

    public static final String FILEPATH = "resources/test.txt";
    public static final String WRITE_FILEPATH = "resources/file.txt";

    private FileManager() {
    }

    public static String readFile() {

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(FILEPATH);

            char[] buffer = new char[1024];

            int num = fileReader.read(buffer);

            if (num == -1) {
                System.out.println("Nothing to read");
                return "";
            }

            return new String(buffer);

        } catch (IOException ex) {
            System.out.println(ex);
        } finally {
            if (fileReader == null) {
                return null;
            }

            try {
                fileReader.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

        return "";
    }


    public static String readFileWithBuffer() {

        String result = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {

            String line;

            while ((line = reader.readLine()) != null) {
                result += line + "\n";
            }

        } catch (IOException ex) {
            System.out.println(ex);
        }

        return result;

    }

    public static void writeToFileWithBuffer(String string) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(WRITE_FILEPATH))) {
            writer.write(string);
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
