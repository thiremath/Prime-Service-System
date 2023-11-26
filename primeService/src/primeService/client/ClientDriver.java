package primeService.client;
 
import java.util.Scanner;
import primeService.socket.PrimeClientSocket;
 
 
public class ClientDriver {
    public String choice = "0" ;
    public String name ;
    public String number ;
    Scanner scanner ;
    Scanner inputScanner ;
    ClientMenu clientMenu ;
    PrimeClientSocket clientSocket ;

    public ClientDriver(String ipAddress, int port){
        scanner = new Scanner(System.in) ;
        clientSocket = new PrimeClientSocket(ipAddress,port) ;
        clientMenu = new ClientMenu(clientSocket) ;
        startClient(ipAddress,port);
    }

    public void startClient(String ipAddress, int port){
        clientSocket.run();
        while(true){
            clientMenu.displayClientMenu();
            choice = scanner.nextLine() ;
            if(choice.equals("4")){
                scanner.close();
                System.exit(port);
            }
            clientMenu.processClientMenu(choice);
        }
    }
}
 