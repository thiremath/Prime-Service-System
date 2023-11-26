package primeService.client;
 
// A Java program for a Client
import java.io.*;
import java.net.*;
import java.util.Scanner;
 
 
public class ClientDriver {
    // initialize socket and input output streams
    private Socket socket = null;
    private BufferedReader input = null;
    private DataOutputStream out = null;
    public String choice ;
    public String name ;
    public String number ;
    Scanner scanner ;
    ClientMenu clientMenu ;

    // constructor to put ip address and port
    public ClientDriver(String ipAddress, int port){
        clientMenu = new ClientMenu(this) ;
        choice = "0" ;
        name = null ;
        number = null ;
        // establish a connection
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connected");
 
            // takes input from terminal
            // input = new DataInputStream(System.in);
            input = new BufferedReader(new InputStreamReader(System.in)); 

            // // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            scanner = new Scanner(System.in);

            while(!choice.equals("4")){
                clientMenu.displayClientMenu();
                choice = scanner.nextLine() ;
                clientMenu.processClientMenu(choice);
            }
 
        }
        catch (UnknownHostException u) {
            System.out.println(u);
            return;
        }
        catch (IOException i) {
            System.out.println(i);
            return;
        }
  
    }
 
    public void setClientName(){
        try {
            name = input.readLine() ;
            System.out.println(name+" Name!");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void setClientNumber(){
        try {
            number = input.readLine() ;
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void getServerResponse(){
        String pair = name+" "+number ;
        try {
            out.writeUTF(pair);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void quit(){
        try {
            System.out.println("loki");
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }
 
}
 