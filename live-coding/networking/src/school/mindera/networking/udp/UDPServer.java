package school.mindera.networking.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPServer {

    private static final int port = 8000;

    public void start() throws IOException {

        DatagramSocket serverSocket = new DatagramSocket(port);
        byte[] receivedData = new byte[1024];

        while (serverSocket.isBound()) {
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

            System.out.println("WAITING FOR DATAGRAM PACKET 🤖\n");
            serverSocket.receive(receivedPacket);

            InetAddress address = receivedPacket.getAddress();
            int port = receivedPacket.getPort();

            String message = new String(receivedPacket.getData(), 0, receivedPacket.getLength(), StandardCharsets.UTF_8);

            System.out.println("COMMUNICATION FROM " + address.getHostName() + ":" + port);
            System.out.println(message);

            String messageToSend = message.toUpperCase();

            byte[] dataToSend = messageToSend.getBytes(StandardCharsets.UTF_8);

            DatagramPacket packetToSend = new DatagramPacket(dataToSend, dataToSend.length, address, port);
            serverSocket.send(packetToSend);
        }

        serverSocket.close();
    }

}
