package primeService.socket;
 
import java.io.*;
import java.net.*;
import java.util.Scanner;

import primeService.util.Debug;
import primeService.util.Debug.DebugLevel;
 
 
public class PrimeClientWorker extends Thread {
    private Socket socket = null;

    private InputStreamReader inputStreamReader ;
    private OutputStreamWriter outputStreamWriter ;

    private BufferedReader bufferedReader ;
    private BufferedWriter bufferedWriter ;

    private DebugLevel debugLevel = DebugLevel.CLIENTWORKER ;

    public String choice = "0";
    public String name = null;
    public String number = null;
    
    Scanner scanner = new Scanner(System.in);

    public PrimeClientWorker(Socket socketIn){
        socket = socketIn ;  

        try {
            inputStreamReader = new InputStreamReader(socket.getInputStream()) ;
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream()) ;

            bufferedReader = new BufferedReader(inputStreamReader) ;
            bufferedWriter = new BufferedWriter(outputStreamWriter) ;
        } catch (Exception e) {
            Debug.writeError(e, "Exception- ", debugLevel);
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            while(true){
                if(socket != null){
                    String ServerMsg = bufferedReader.readLine() ;
                    if(ServerMsg == null || ServerMsg.equals("Server closed")){
                        Debug.writeMessage("----------Server Closed----------",debugLevel);
                        quit();
                    }
                    printServerMessage(ServerMsg) ;
                }
            }
        }
        catch (Exception e) {
            Debug.writeMessage("Server Closed.",debugLevel);
            e.printStackTrace();
            System.exit(0);
            return;
        }
    }

    public void printServerMessage(String ServerMsgIn){
        Debug.writeMessage("A Message from Server:\n"+ServerMsgIn, debugLevel);
    }
 
    public void setClientName(){
        try {
            name = scanner.nextLine() ;
            if(name.equals("")){
                Debug.writeMessage("Please enter a Client Name.",debugLevel);
                return ;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void setClientNumber(){
        try {
            String tempNumber = scanner.nextLine() ;
            if(tempNumber.equals("")){
                Debug.writeMessage("Please enter a number.",debugLevel);
                return ;
            }
            if(Integer.parseInt(tempNumber) > 3){
                number = tempNumber ;
            }
            else{
                Debug.writeError(null, "Invalid Input.",debugLevel);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void getServerResponse(){
        try {
            if(name == null || number == null){
                Debug.writeMessage("Please enter a value.",debugLevel);
                return ;
            }
            String inputLine = "<primeQuery><clientName>"+name+"</clientName><isPrime>"+number+"</isPrime></primeQuery>" ;        
            bufferedWriter.write(inputLine);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {
            quit();
            Debug.writeError(e,null,debugLevel);
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void quit(){
        try {
            Debug.writeMessage("---------- Client closed ----------",debugLevel);
            socket.close();
            System.exit(0);
        }
        catch (Exception e) {
            Debug.writeError(e,null,debugLevel);
            e.printStackTrace();
            System.exit(0);
        }
    }
 
}
 
