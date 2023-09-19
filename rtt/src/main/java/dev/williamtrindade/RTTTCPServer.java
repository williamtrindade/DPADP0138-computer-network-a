package dev.williamtrindade;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RTTTCPServer {
    public static void main(String[] args) throws IOException {
        Socket socket;
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            socket = serverSocket.accept();
        }
        byte[] buffer = new byte[100];
        int nBytes = socket.getInputStream().read(buffer);
        System.out.println(new String(buffer, 0, nBytes) + " Recebido");
        socket.getOutputStream().write("PONG".getBytes());
        socket.close();
    }
}
