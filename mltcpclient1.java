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

 class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Send the "time" command to the server
            out.println("time");

            // Read and print the server's response
            String serverResponse = in.readLine();
            System.out.println("Current time: " + serverResponse);

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
------------------------------------------------------------
output

C:\Users\ozadh\Downloads\tempt>java Client
Current time: Wed Jun 14 01:11:11 IST 2023
