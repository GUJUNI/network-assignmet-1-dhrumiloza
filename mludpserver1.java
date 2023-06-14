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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

 class UDPServer {
    private static final int PORT = 12345;
    private static final int THREAD_POOL_SIZE = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("Server started.");

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

                serverSocket.receive(receivePacket);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                String numberString = new String(receivePacket.getData()).trim();
                int number = Integer.parseInt(numberString);

                Runnable clientHandler = new ClientHandler(serverSocket, clientAddress, clientPort, number);
                executorService.execute(clientHandler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

class ClientHandler implements Runnable {
    private DatagramSocket serverSocket;
    private InetAddress clientAddress;
    private int clientPort;
    private int number;

    public ClientHandler(DatagramSocket serverSocket, InetAddress clientAddress, int clientPort, int number) {
        this.serverSocket = serverSocket;
        this.clientAddress = clientAddress;
        this.clientPort = clientPort;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connected to client: " + clientAddress);

            StringBuilder responseBuilder = new StringBuilder();
            for (int i = 1; i <= 10; i++) {
                int result = number * i;
                String line = number + " x " + i + " = " + result + "\n";
                responseBuilder.append(line);
            }
            String response = responseBuilder.toString();

            byte[] sendData = response.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            System.out.println("Sent multiplication table to client: " + clientAddress);
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
