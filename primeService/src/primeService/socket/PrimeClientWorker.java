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

    private Debug debugObject = Debug.getInstance() ;

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
            Debug.writeError(e, "Exception- ", DebugLevel.CLIENTWORKER);
            e.printStackTrace();
        }
    }

    public void run(){
        try {
            while(true){
                if(socket != null){
                    String ServerMsg = bufferedReader.readLine() ;
                    if(ServerMsg == null || ServerMsg.equals("Server closed")){
                        System.out.println("----------Server Closed----------");
                        quit();
                    }
                    printServerMessage(ServerMsg) ;
                }
            }
        }
        catch (Exception e) {
            System.out.println("Server Closed.");
            e.printStackTrace();
            System.exit(0);
            return;
        }
    }

    public void printServerMessage(String ServerMsgIn){
        System.out.println("A Message from Server:\n"+ServerMsgIn);
    }
 
    public void setClientName(){
        try {
            name = scanner.nextLine() ;
            if(name.equals("")){
                System.out.println("Please enter a Client Name.");
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
                System.out.println("Please enter a number.");
                return ;
            }
            if(Integer.parseInt(tempNumber) > 3){
                number = tempNumber ;
            }
            else{
                Debug.writeError(null, "Invalid Input.",DebugLevel.CLIENTWORKER);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void getServerResponse(){
        try {
            if(name == null || number == null){
                System.out.println("Please enter a value.");
                return ;
            }
            String inputLine = "<primeQuery><clientName>"+name+"</clientName><isPrime>"+number+"</isPrime></primeQuery>" ;        
            Debug.writeMessage(name,DebugLevel.CLIENTWORKER);
            Debug.writeMessage(number,DebugLevel.CLIENTWORKER);
            bufferedWriter.write(inputLine);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (Exception e) {
            quit();
            Debug.writeError(e,null,DebugLevel.CLIENTWORKER);
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void quit(){
        try {
            System.out.println("---------- Client closed ----------");
            socket.close();
            System.exit(0);
        }
        catch (Exception e) {
            Debug.writeError(e,null,DebugLevel.CLIENTWORKER);
            e.printStackTrace();
            System.exit(0);
        }
    }
 
}
 
