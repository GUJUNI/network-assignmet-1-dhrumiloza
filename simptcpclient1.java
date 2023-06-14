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

            // Send a message to the server
            String message = "Good Morning";  // Change this message to "Good Night" if desired
            out.println(message);

            // Receive and print the server's response
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close the socket
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
--------------------------------------------------------------------
output

C:\Users\ozadh\Downloads\tempt>java TCPClient
Server response: Good Morning!