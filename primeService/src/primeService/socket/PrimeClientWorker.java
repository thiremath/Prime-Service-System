package primeService.socket;
 
import java.io.*;
import java.net.*;
import java.util.Scanner;
 
 
public class PrimeClientWorker {
    private Socket socket = null;
    // private DataOutputStream out = null;
    // private DataInputStream in = null;
    private InputStreamReader inputStreamReader ;
    private OutputStreamWriter outputStreamWriter ;

    private BufferedReader bufferedReader ;
    private BufferedWriter bufferedWriter ;

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

            inputStreamReader = new InputStreamReader(socket.getInputStream()) ;
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream()) ;

            bufferedReader = new BufferedReader(inputStreamReader) ;
            bufferedWriter = new BufferedWriter(outputStreamWriter) ;
            // in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            // out = new DataOutputStream(socket.getOutputStream());

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
            bufferedWriter.write(inputLine);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            String line= bufferedReader.readLine();
            System.out.println("A Message from Server:\n"+line);
        } catch (Exception e) {
            quit();
            System.err.println(e);
            e.printStackTrace();
            System.exit(0);
        }
    }
 
    public void quit(){
        try {
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
 
