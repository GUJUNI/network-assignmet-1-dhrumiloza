Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------
<p 1> a TCP client-server program in Java that allows the client to send "Good Morning" or "Good Night" messages to the server.
 The server will respond with a corresponding message based on the time of the day
----------------------------------------------------------------------------------------------------------------------
import java.io.*;
import java.net.*;

 class TCPServer {
    public static void main(String[] args) {
        int portNumber = 12345;  // Port number on which the server listens

        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(portNumber);

            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                // Wait for a client connection
                Socket clientSocket = serverSocket.accept();

                // Get input and output streams for the client socket
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Read the client's message
                String message = in.readLine();
                System.out.println("Received message from client: " + message);

                // Generate server's response based on the time of the day
                String response;
                int hour = java.time.LocalTime.now().getHour();
                if (hour < 12) {
                    response = "Good Morning!";
                } else {
                    response = "Good Night!";
                }

                // Send the response back to the client
                out.println(response);

                // Close the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
