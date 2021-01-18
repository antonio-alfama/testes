package school.mindera.networking.simplewebserver.server;

import javax.activation.MimetypesFileTypeMap;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;

// SIMPLE WEB SERVER
// - Receive http requests
// - Implement only for *.html files
// - If / should respond with /index.html or respond with the requested file/path
// - Files should be on ./resources/ folder
//
// request = "/index.html";
// path = "./resources" + request;

public class WebServer {

    private int port = 8000;

    private ServerSocket server;
    private Socket client;

    private FileInputStream fileInputStream;
    private BufferedReader bReader;
    private DataOutputStream outputStream;

    public void start() throws IOException {

        server = new ServerSocket(port);

        while (server.isBound()) {

            client = server.accept();

            bReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outputStream = new DataOutputStream(client.getOutputStream());

            String firstLine = bReader.readLine();
            System.out.println(firstLine);
            String[] headers = firstLine.split(" ");

            try {
                response(headers);
                System.out.println("Success");

            } catch (Exception e) {
                errorResponse();
                System.out.println("File not found");

            } finally {
                outputStream.close();
                fileInputStream.close();
            }
        }

    }

    public void response(String[] headers) throws Exception {
        String path = "./resources" + (headers[1].equals("/") ? "/index.html" : headers[1]);
        File file = new File(path);

        sendResponse(file, 200);
    }

    public void errorResponse() {
        String path = "./resources/404.html";
        File file = new File(path);

        try {
            sendResponse(file, 404);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void sendResponse(File file, int statusCode) throws IOException {
        fileInputStream = new FileInputStream(file.getPath());

        String responseHeader = createResponseHeader(statusCode, getContentType(file), file.length());
        outputStream.writeBytes(responseHeader);

        byte[] buffer = new byte[1024];
        int bytes;

        while ((bytes = fileInputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytes);
        }
    }

    private String getContentType(File file) throws IOException {
        Path source = Paths.get(file.getPath());
        MimetypesFileTypeMap m = new MimetypesFileTypeMap(source.toString());
        return m.getContentType(file);
    }

    public String createResponseHeader(int statusCode, String contentType, float contentLength) {

        String[] contentT = contentType.split("/");
        return "HTTP/1.1 " + statusCode + " \r\n" +
                "Content-Type: " + contentType + (contentT[0].equals("text") ? "; charset=UTF-8" : "") +"\r\n" +
                "Content-Length: " + contentLength + "\r\n" +
                "\r\n";

    }
}