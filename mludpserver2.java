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

                String requestData = new String(receivePacket.getData()).trim();

                Runnable clientHandler = new ClientHandler(serverSocket, clientAddress, clientPort, requestData);
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
    private String requestData;

    public ClientHandler(DatagramSocket serverSocket, InetAddress clientAddress, int clientPort, String requestData) {
        this.serverSocket = serverSocket;
        this.clientAddress = clientAddress;
        this.clientPort = clientPort;
        this.requestData = requestData;
    }

    @Override
    public void run() {
        try {
            System.out.println("Connected to client: " + clientAddress);

            String[] requestParts = requestData.split(":");
            String operation = requestParts[0];

            String response;
            if (operation.equalsIgnoreCase("cube")) {
                int number = Integer.parseInt(requestParts[1]);
                response = calculateCube(number);
            } else if (operation.equalsIgnoreCase("circle")) {
                double radius = Double.parseDouble(requestParts[1]);
                response = calculateCircle(radius);
            } else {
                response = "Invalid operation";
            }

            byte[] sendData = response.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);

            System.out.println("Sent response to client: " + clientAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String calculateCube(int number) {
        int cube = number * number * number;
        return "Cube of " + number + " is " + cube;
    }

    private String calculateCircle(double radius) {
        double area = Math.PI * radius * radius;
        double circumference = 2 * Math.PI * radius;
        return "Area of circle with radius " + radius + " is " + area + ", Circumference is " + circumference;
    }
}
-----------------------------------------------------------------------
output :
C:\Users\ozadh\Downloads\tempt>java UDPClient
Area of circle with radius 3.5 is 38.48451000647496, Circumference is 21.991148575128552