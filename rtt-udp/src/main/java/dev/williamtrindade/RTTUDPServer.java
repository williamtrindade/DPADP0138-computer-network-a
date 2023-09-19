package dev.williamtrindade;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RTTUDPServer {
    public static void main(String[] args) throws IOException {
        // Create socket
        DatagramSocket serverSocket = new DatagramSocket(9876);

        byte[] receiveData = new byte[1024];
        byte[] response;

        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            // Receive
            String receivedString = receivePacket(serverSocket, receivePacket);
            response = "RECEIVED".getBytes();

            // Receive IP Address
            InetAddress IPAddress = receivePacket.getAddress();

            // Receive Port
            int port = receivePacket.getPort();

            DatagramPacket sendPacket = new DatagramPacket(response, response.length, IPAddress, port);
            serverSocket.send(sendPacket);
        }
    }

    private static String receivePacket(DatagramSocket serverSocket, DatagramPacket receivePacket) throws IOException, IOException {
        serverSocket.receive(receivePacket);
        return new String(receivePacket.getData());
    }
}
