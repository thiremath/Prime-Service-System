package primeService.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
    // public DataInputStream in = null;
    // public DataOutputStream out = null ;
    private InputStreamReader inputStreamReader ;
    private OutputStreamWriter outputStreamWriter ;
    private pair custom_Pair ;

    private xmlReader xReader = null ;
    private CheckPrime xPrime = null ;

    private BufferedReader bufferedReader ;
    private BufferedWriter bufferedWriter ;

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
            inputStreamReader = new InputStreamReader(socket.getInputStream()) ;
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream()) ;

            bufferedReader = new BufferedReader(inputStreamReader) ;
            bufferedWriter = new BufferedWriter(outputStreamWriter) ;
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        while(true){
            try {
                // if(bufferedReader.readLine() != null){
                    String line = bufferedReader.readLine() ;
                    // System.out.println(line+" line from client.");
                    if(line == null){
                        continue ;
                    }
                // }
                xReader = new xmlReader() ;
                xPrime = new CheckPrime() ;
                custom_Pair = xReader.read(line);
                String clientName = custom_Pair.clientName ;
                int Number = Integer.parseInt(custom_Pair.isPrime) ;
                try {
                    String intValue = custom_Pair.isPrime ;
                    String isPrime = xPrime.isPrime(Number) ;
                    String outputQuery = "<primeQueryResponse><intValue>"+intValue+"</intValue><isPrime>"+isPrime+"</isPrime></primeQueryResponse>" ;
                    // out.writeUTF(outputQuery);
                    bufferedWriter.write(outputQuery);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(0) ;
            }
        }
    }

    public void quit(){
            System.out.println("Closing connection");
            try {

                bufferedWriter.write("Server closed");
                bufferedWriter.newLine();
                bufferedWriter.flush();                

                bufferedReader.close();
                bufferedWriter.close();
                inputStreamReader.close();
                outputStreamWriter.close();
                socket.close();
            }
            catch (IOException i) {
                System.out.println(i);
            }
    }
   
}
