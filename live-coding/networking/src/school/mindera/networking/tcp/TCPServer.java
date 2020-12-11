package school.mindera.networking.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    private static final int port = 8000;

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        while (serverSocket.isBound()) {
            System.out.println("WAITING FOR CONNECTION 💿");

            Socket clientSocket = serverSocket.accept();

            System.out.println("ACCEPTED CONNECTION FROM "
                    + clientSocket.getInetAddress().getHostName()
                    + ":" + clientSocket.getPort());

            BufferedReader socketReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter socketWriter = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String message;

            while (clientSocket.isConnected()) {
                message = socketReader.readLine();

                if (message == null) {
                    break;
                }

                System.out.println("CLIENT SAYS: " + message);

                String messageToSend = message.toUpperCase();

                socketWriter.write(messageToSend);
                socketWriter.newLine();
                socketWriter.flush();
            }

            socketReader.close();
            socketWriter.close();
            clientSocket.close();
        }

        serverSocket.close();
    }
}
