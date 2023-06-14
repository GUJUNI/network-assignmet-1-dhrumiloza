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

 class TCPClient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1";  // Server IP address
        int serverPort = 12345;         // Server port number

        try {
            // Create a socket connection to the server
            Socket socket = new Socket(serverIP, serverPort);

            // Get input and output streams for the socket
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send a line of text to the server
            String line = "Hello, how are you?";  // Change this line as desired
            out.println(line);

            // Receive and print the server's response
            String response = in.readLine();
            System.out.println("Total number of words: " + response);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
-----------------------------------------------------------------
output
C:\Users\ozadh\Downloads\tempt>java TCPClient
Total number of words: 4