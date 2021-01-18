package school.mindera.networking.brokenphone.server;

import school.mindera.networking.brokenphone.utils.Messages;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class BrokenPhoneServer {

    private static final int CLIENT_TIMEOUT = 5000;
    private static final int PORT = 8000;

    private ServerSocket server;
    private Socket client;

    private BufferedReader reader;
    private BufferedWriter writer;

    private List<String> messages;

    public void start() {
        try {
            this.init();

            while (server.isBound()) {
                this.handleConnection();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void init() throws IOException {
        System.out.println(Messages.SERVER_START);

        server = new ServerSocket(PORT);
        messages = new ArrayList<>();
    }

    private void handleConnection() throws IOException {
        System.out.println(Messages.WAITING_FOR_CONNECTION);

        client = server.accept();

        System.out.println(Messages.CONNECTION_ESTABLISHED);
        System.out.println(client.getInetAddress().getHostName() + ":" + client.getPort());

        this.setUpStreams();

        this.sendClientMessage(Messages.CLIENT_WELCOME_MESSAGE);

        while (client.isConnected()) {
            this.handleClientMessage();
            this.sendClientMessage(buildMessage());
        }
    }

    private void setUpStreams() throws IOException {
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
    }

    private void handleClientMessage() throws IOException {
        String messageReceived = null;

        try {
            client.setSoTimeout(CLIENT_TIMEOUT);
            messageReceived = reader.readLine();
        } catch (SocketTimeoutException ex) {
            System.out.println(Messages.CLIENT_TIMEOUT);
            this.handleConnection();
            client.close();
        }

        if (messageReceived == null) {
            return;
        }

        System.out.println(Messages.MESSAGE_RECEIVED);
        System.out.println(messageReceived);

        messages.add(messageReceived);
    }

    private void sendClientMessage(String message) throws IOException {
        System.out.println(Messages.SENDING_MESSAGE);

        writer.write(message);
        writer.newLine();
        writer.flush();
    }

    private String buildMessage() {
        String lastMessage = messages.get(messages.size() - 1);

        StringBuilder messageToSend = new StringBuilder(lastMessage.substring(0, lastMessage.length() / 2));

        for (int i = 0; i < messages.size() - 2; i++) {
            String message = messages.get(i);

            messageToSend
                    .append(" ")
                    .append(message.substring(message.length() / 2).trim())
                    .append(" ");
        }

        return messageToSend.append(lastMessage.substring(lastMessage.length() / 2)).toString();
    }
}
