package school.mindera.networking.simplewebserver;

import school.mindera.networking.simplewebserver.server.WebServer;

public class Main {

    public static void main(String[] args) {
        try {
            new WebServer().start();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
