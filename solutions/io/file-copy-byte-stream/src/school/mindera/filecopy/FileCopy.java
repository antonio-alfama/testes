package school.mindera.filecopy;

import java.io.*;

public class FileCopy {

    public static void main(String[] args) {

        if (args.length != 2){
            System.err.println("It is expected to receive 2 arguments: <sourceFile> <destinationFile>");
            System.exit(1);
        }

        FileCopy fileCopy = new FileCopy();
        fileCopy.start(args[0],args[1]);
    }

    private void start(String sourceFile, String destinationFile) {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {

            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destinationFile);

            byte[] buffer = new byte[1024];

            int amountOfBytesRead = 0;
            int endOfFile = -1;

            while (amountOfBytesRead != endOfFile){

                out.write(buffer,0,amountOfBytesRead);
                amountOfBytesRead = in.read(buffer);

            }
            System.out.println("File " + sourceFile + " copied to " + destinationFile);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(in);
            closeStream(out);
            System.exit(1);
        }
    }

    private void closeStream(Closeable stream) {

        if (stream == null){
            return;
        }

        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

