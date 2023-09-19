package dev.williamtrindade;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class RTTUDPClient {
    public static void main(String[] args) throws IOException {
        long milis = System.currentTimeMillis();

        // Get Data to send
        byte[] sendData = "REQUISICAO".getBytes();

        // Create Socket
        DatagramSocket clientSocket = new DatagramSocket();

        // Get IP Address
        InetAddress IPAddress = InetAddress.getByName("localhost");

        // Send Datagram to server
        sendPacket(clientSocket, sendData, IPAddress);

        // Receive Datagram from server
        String response = receivePacket(clientSocket);

        // Response
        // System.out.println("RESPONSE: " + response);

        System.out.println("RTT: " + ((System.currentTimeMillis() - milis)/2.0) + "ms");
        clientSocket.close();
    }

    private static String receivePacket(DatagramSocket clientSocket) throws IOException {
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        return new String(receivePacket.getData());
    }

    private static void sendPacket(DatagramSocket clientSocket, byte[] sendData, InetAddress IPAddress) throws IOException, IOException {
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
    }
}
