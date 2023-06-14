Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------------
<p 1> a multithreaded TCP client and server program in Java that includes a feature to show the current time
------------------------------------------------------------------------------------------------------

import java.io.*;
import java.net.*;

 class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        int portNumber = 1234;

        try {
            serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is running and waiting for client connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Create a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandler.start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (serverSocket != null)
                serverSocket.close();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.equalsIgnoreCase("time")) {
                    String time = getCurrentTime();
                    out.println(time);
                } else {
                    out.println("Invalid command");
                }
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }

    private String getCurrentTime() {
        // Get the current time
        java.util.Date date = new java.util.Date();
        return date.toString();
    }
}
