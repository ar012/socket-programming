import java.net.*;
import java.io.*;

/**
 * Client
 */
public class Client {

  Socket socket;
  DataInputStream console;
  DataOutputStream streamOut;

  public Client(String serverName, int serverPort){

    try {
      socket = new Socket(serverName, serverPort);
      console = new DataInputStream(System.in);
      streamOut = new DataOutputStream(socket.getOutputStream()); 
    } catch (Exception e) {
      System.out.println("Error");
    }

    while (true) {
      try {
        String line="";
        line = console.readLine();
        streamOut.writeUTF(line);
        streamOut.flush();  
      } catch (Exception ioe) {
        System.out.println("Error");
      }
    }
  }

  public static void main(String args[]) {
    Client client = new Client(args[0], Integer.parseInt(args[1]));
  }
}