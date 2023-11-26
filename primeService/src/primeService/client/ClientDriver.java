package primeService.client;
 
// A Java program for a Client
import java.io.*;
import java.net.*;
 
 
public class ClientDriver {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
 
    // constructor to put ip address and port
    public ClientDriver(String ipAddress, int port){
        ClientMenu clientMenu = new ClientMenu(this) ;
        // establish a connection
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connected");
 
            // takes input from terminal
            // input = new DataInputStream(System.in);
 
            // // sends output to the socket
            // out = new DataOutputStream(
            //  socket.getOutputStream());
 
            clientMenu.processClientMenu();
 
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }
 
        // string to read message from input
        String line = "";
 
        // keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch (IOException i) {
                System.out.println(i);
            }
        }
 
        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
 
    }
 
    public void setClientName(){
            
    }
 
    public void setClientNumber(){
 
    }
 
    public void getServerResponse(){
        out.writeUTF("");
    }
 
    public void quit(){
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }
 
}
 