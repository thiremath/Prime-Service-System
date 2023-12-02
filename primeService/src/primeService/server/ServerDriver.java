package primeService.server;

import java.util.Scanner;
import primeService.socket.PrimeServerSocket;

public class ServerDriver{

    public String choice = "0" ;
    public ServerMenu serverMenu ;
    public PrimeServerSocket serverSocket ;
    Scanner scanner ;


    public ServerDriver(int port)
    {   
        scanner = new Scanner(System.in) ;
        serverSocket = new PrimeServerSocket(port) ;
        serverMenu = new ServerMenu(serverSocket) ;
        startServer(port) ;
    }

    public void startServer(int port){
        serverSocket.start() ; // Thread method.
        while(true){
            serverMenu.displayServerMenu();
            choice = scanner.nextLine() ;
            if(choice.equals("3")){
                scanner.close();
                System.exit(port);
            }
            serverMenu.processServerMenu(choice);
        }
    }
    
}