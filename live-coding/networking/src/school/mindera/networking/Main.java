package school.mindera.networking;

import school.mindera.networking.tcp.TCPServer;
import school.mindera.networking.udp.UDPServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Raw Socket

        // Netcat
        // nc -ulp 8080 - listen (udp) on port 8080
        // nc -u localhost 8000 - send data to host on port 8000
        // Using tcp? No need to use -u.

        // InetAddress

        // UDP
        // - DatagramSocket
        // - DatagramPacket

        // TCP
        // - Socket
        // - ServerSocket - .accept() -> Socket (clientSocket);

        try {
            // new UDPServer().start();
            new TCPServer().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
