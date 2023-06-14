Name       - Dhrumil oza
Roll no    - 26
Subject    - Advanced Networking
Assignment - 1
Course     - mca2
-----------------------------------------------------------------------------------------
<p 6>which reads data from a file and generate a message digest and prints it
-------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------
import java.security.MessageDigest;
import java.util.Scanner;

 class MessageDigestExample {
   public static void main(String args[]) throws Exception{
	  
      //Reading data from user
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter the message");
      String message = sc.nextLine();
	  
      //Creating the MessageDigest object  
      MessageDigest md = MessageDigest.getInstance("SHA-256");

      //Passing data to the created MessageDigest Object
      md.update(message.getBytes());
      
      //Compute the message digest
      byte[] digest = md.digest();      
      
      System.out.println(digest);  
     
      //Converting the byte array in to HexString format
      StringBuffer hexString = new StringBuffer();
      for (int i = 0;i<digest.length;i++) {
         hexString.append(Integer.toHexString(0xFF & digest[i]));
      }
      System.out.println("Hex format : " + hexString.toString());     
   }
}
--------------------------------------------------------------------
output :-

Enter the message
hello user
[B@4459eb14
Hex format : b371a0ad941d7d294f63e6d0843e5588b62931b48c7f13d9c3e81b7715d1bf1