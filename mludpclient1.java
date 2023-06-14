Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
<P 1> a multithreaded UDP program for a client and server to generate a multiplication table in Java.
-------------------------------------------------------------------------------------------------------
import java.net.*;

 class UDPClient {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName(SERVER_IP);

            int number = 7;

            String numberString = Integer.toString(number);
            byte[] sendData = numberString.getBytes();
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
-------------------------------------------------------------
output:
C:\Users\ozadh\Downloads\tempt>java UDPClient
7 x 1 = 7
7 x 2 = 14
7 x 3 = 21
7 x 4 = 28
7 x 5 = 35
7 x 6 = 42
7 x 7 = 49
7 x 8 = 56
7 x 9 = 63
7 x 10 = 70
