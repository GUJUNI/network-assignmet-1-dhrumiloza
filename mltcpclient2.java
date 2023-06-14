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

class Client {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 1234;

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter your birth year: ");
            String birthYear = stdIn.readLine();

            // Send the birth year to the server
            out.println(birthYear);

            // Read and print the server's response
            String serverResponse = in.readLine();
            System.out.println(serverResponse);

            out.close();
            in.close();
            stdIn.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
