Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------
------------------------------------------------------------------------------
p 2 > a multithreaded UDP program for a client and server to calculate the cube and circle properties in Java.
-------------------------------------------------------------------------------------------
import java.net.*;

 class UDPClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            String operation = "circle";
            double radius = 3.5;

            String requestData = operation + ":" + radius;
            byte[] sendData = requestData.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String response = new String(receivePacket.getData()).trim();
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
-----------------------------------------------------------------------
output :
C:\Users\ozadh\Downloads\tempt>java UDPClient
Area of circle with radius 3.5 is 38.48451000647496, Circumference is 21.991148575128552
