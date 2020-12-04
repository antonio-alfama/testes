package school.mindera.game.game.utils;

import java.io.*;

public class SaveManager {

    private static final String SAVE_FILEPATH = "resources/saved.game";

    private SaveManager() {
    }

    public static String load() {

        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILEPATH))) {

            String line;

            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }

        } catch (IOException ex) {
            System.err.println(ex);
        }

        return result.toString();

    }

    public static void save(String save) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILEPATH))) {
            writer.write(save);
        } catch (IOException ex) {
            System.err.println(ex);
        }

    }
}
