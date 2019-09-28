import java.net.*;
import java.io.*;

/*
 * Server
 */
public class Server{
  private Socket            socket;
  private ServerSocket      server;
  private DataInputStream  streamIn;

  public Server(int port){
    try{
      server = new ServerSocket(port);
      socket = server.accept();
      streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
      while (true) {
        String line = streamIn.readUTF();
        System.out.println(line);
      }

    } catch(IOException ioe){
      System.out.println("Error");
    }
    
  }

  public static void main(String[] agrs) {
    Server server = new Server(8375);
  }
}