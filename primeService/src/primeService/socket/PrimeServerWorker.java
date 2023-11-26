package primeService.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import primeService.server.ServerMenu;
import primeService.util.CheckPrime;
import primeService.util.pair;
import primeService.util.xmlReader;

public class PrimeServerWorker extends Thread{

    public Socket socket = null;
    public ServerSocket server = null;
    public DataInputStream in = null;
    public DataOutputStream out = null ;
    public String choice ;
    public Scanner scanner ;
    public ServerMenu serverMenu ;
 
    public PrimeServerWorker(Socket socketIn)
    {
        socket = socketIn ;
    }

    public void run(){
        try
        { 
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        while(true){
            try {
                xmlReader.read(in.readUTF());
                String clientName = pair.clientName ;
                int Number = Integer.parseInt(pair.isPrime) ;
                try {
                    String intValue = pair.isPrime ;
                    String isPrime = CheckPrime.isPrime(Number) ;
                    String outputQuery = "<primeQueryResponse><intValue>"+intValue+"</intValue><isPrime>"+isPrime+"</isPrime></primeQueryResponse>" ;
                    out.writeUTF(outputQuery);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            } catch (Exception e) {
                // e.printStackTrace();
                // System.exit(0) ;
            }
        }
    }

    public void quit(){
            System.out.println("Closing connection");
            try {
                in.close();
                socket.close();
            }
            catch (IOException i) {
                System.out.println(i);
            }
    }
   
}
