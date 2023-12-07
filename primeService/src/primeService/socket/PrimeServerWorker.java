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

import primeService.server.AllPrimeQueries;
import primeService.server.ServerMenu;
import primeService.util.CheckPrime;
import primeService.util.pair;
import primeService.util.xmlReader;
import primeService.util.Debug;
import primeService.util.Debug.DebugLevel;

public class PrimeServerWorker extends Thread{

    public Socket socket = null;
    public ServerSocket server = null;
    private InputStreamReader inputStreamReader ;
    private OutputStreamWriter outputStreamWriter ;
    private pair custom_Pair ;

    private Debug debugObject = Debug.getInstance() ;

    private xmlReader xReader = null ;
    private CheckPrime xPrime = null ;

    private BufferedReader bufferedReader ;
    private BufferedWriter bufferedWriter ;

    public String choice ;
    public String clientQuery = null;
    public Scanner scanner ;
    public ServerMenu serverMenu ;
 
    public PrimeServerWorker(Socket socketIn){
        socket = socketIn ;
        try{ 
            inputStreamReader = new InputStreamReader(socket.getInputStream()) ;
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream()) ;
            bufferedReader = new BufferedReader(inputStreamReader) ;
            bufferedWriter = new BufferedWriter(outputStreamWriter) ;
        }
        catch(Exception e){
            // e.printStackTrace();
            Debug.writeError(e,null,DebugLevel.SERVERWORKER);
        }
    }

    public void run(){
        while(true){
            try {
                clientQuery = bufferedReader.readLine() ;
                if(clientQuery == null){
                    continue ;
                }
                AllPrimeQueries.addClientQuery(clientQuery);
                xReader = new xmlReader() ;
                xPrime = new CheckPrime() ;
                custom_Pair = xReader.read(clientQuery);
                String clientName = custom_Pair.clientName ;
                int Number = Integer.parseInt(custom_Pair.isPrime) ;

                String intValue = custom_Pair.isPrime ;
                String isPrime = xPrime.isPrime(Number) ;
                String outputQuery = "<primeQueryResponse><intValue>"+intValue+"</intValue><isPrime>"+isPrime+"</isPrime></primeQueryResponse>" ;
                Debug.writeMessage(intValue,DebugLevel.SERVERWORKER);
                Debug.writeMessage(isPrime,DebugLevel.SERVERWORKER);
                bufferedWriter.write(outputQuery);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            } catch (Exception e) {
                // e.printStackTrace();
                System.exit(0) ;
            }
        }
    }

    public void printClientQuery(){
        if(AllPrimeQueries.allQueries.size() != 0){
            System.out.println(AllPrimeQueries.allQueries.get(AllPrimeQueries.allQueries.size()-1));
        }
    }

    public void quit(){
            System.out.println("----------Closing connection----------");
            try {
                bufferedWriter.write("Server closed");
                bufferedWriter.newLine();
                bufferedWriter.flush();     
                socket.close();
                System.out.println("Connection closed.");
                System.exit(0);
            }
            catch (IOException e) {
                // Debug.writeError(e,null,DebugLevel.SERVERWORKER);
                // e.printStackTrace();
            }
            finally{
                try {
                    inputStreamReader.close();
                    outputStreamWriter.close();
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (Exception e) {
                    System.out.println(e);
                    System.exit(0);
                }
            }
    }
   
}
