package school.mindera.streams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        // Reader
            // InputStreamReader
                // FileReader
            // BufferedReader
        // Writer
            // OutputStreamWriter
                // FileWriter
            // BufferedWriter

        // USE THIS TO READ INPUT 👇
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println((in.readLine()));
        } catch (IOException ex ) {
            System.out.println(ex);
        }

        FileManager.writeToFileWithBuffer(FileManager.readFileWithBuffer());

    }
}
