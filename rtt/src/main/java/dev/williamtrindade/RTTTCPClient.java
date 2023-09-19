package dev.williamtrindade;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class RTTTCPClient {
    public static void main(String[] args) throws IOException {
        long milis = System.currentTimeMillis();
        Socket socket = new Socket("localhost", 8080);
        socket.getOutputStream().write("PING".getBytes());
        byte[] res = new byte[100];
        socket.getInputStream().read(res);
        System.out.println(Arrays.toString(res)); // RESPOSTA
        System.out.println("RTT: " + ((System.currentTimeMillis() - milis)/2.0) + "ms");
        socket.close();
    }
}
