Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------
<p 2>a multithreaded TCP client and server program in Java that calculates the age of a person 
based on their birth year.
--------------------------------------------------------------------------------------------------------
import java.io.*;
import java.net.*;
import java.time.*;

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
                try {
                    int birthYear = Integer.parseInt(inputLine);
                    int age = calculateAge(birthYear);
                    out.println("Your age is: " + age);
                } catch (NumberFormatException e) {
                    out.println("Invalid input. Please enter a valid birth year.");
                }
            }

            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        }
    }

    private int calculateAge(int birthYear) {
        // Get the current year
        int currentYear = Year.now().getValue();

        // Calculate the age
        return currentYear - birthYear;
    }
}
----------------------------------------------------------------------------------
output
C:\Users\ozadh\Downloads\tempt>java Client
Enter your birth year: 2001
Your age is: 22
