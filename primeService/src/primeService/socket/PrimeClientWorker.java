package primeService.socket;
 
import java.io.*;
import java.net.*;
import java.util.Scanner;
 
 
public class PrimeClientWorker {
    private Socket socket = null;
    private DataOutputStream out = null;
    private DataInputStream in = null;
    public String choice = "0";
    public String name = null;
    public String number = null;
    Scanner scanner ;

    public PrimeClientWorker(Socket socketIn){
        socket = socketIn ;  
    }

    public void run(){
        try {
            scanner = new Scanner(System.in); 
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
            return;
        }
    }
 
    public void setClientName(){
        try {
            name = scanner.nextLine() ;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void setClientNumber(){
        try {
            String tempNumber = scanner.nextLine() ;
            if(Integer.parseInt(tempNumber) > 3){
                number = tempNumber ;
            }
            else{
                System.err.println("Invalid Input.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void getServerResponse(){
        String inputLine = "<primeQuery><clientName>"+name+"</clientName><isPrime>"+number+"</isPrime></primeQuery>" ;        
        try {
            out.writeUTF(inputLine);
            String line=in.readUTF();
            System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void quit(){
        try {
            scanner.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i);
        }
    }
 
}
 
