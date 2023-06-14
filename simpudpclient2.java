Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
---------------------------------------------------------------------------------------------------------------
multiplication table 
---------------------------------------------------------------------------------------------------------------
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println("multiplication_table");

            String response = in.readLine();
            System.out.println("Received multiplication table from server:\n" + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
---------------------------------------------------------
output:
Received multiplication table from server:
1       2       3       4       5       6       7       8       9       10