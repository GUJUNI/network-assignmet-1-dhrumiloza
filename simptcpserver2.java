Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------
 <p 2> TCP client-server program in Java that allows the client to send a line of text to the server.
 The server will count the total number of words in the line and send the count back to the client.
=------------------------------------------------------------------------------------------------------
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

                // Read the client's line of text
                String line = in.readLine();
                System.out.println("Received line from client: " + line);

                // Count the number of words in the line
                String[] words = line.split("\\s+");
                int wordCount = words.length;

                // Send the word count back to the client
                out.println(wordCount);

                // Close the client socket
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
