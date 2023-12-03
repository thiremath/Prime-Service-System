package primeService.server;

import primeService.socket.PrimeServerSocket;
import primeService.socket.PrimeServerWorker;

public class ServerMenu {
 
    public PrimeServerWorker serverWorker ;
    private PrimeServerSocket serverSocket ;
 
    public ServerMenu(PrimeServerSocket serverSocketIn){
        serverSocket = serverSocketIn ;
    }
 
    public void processServerMenu(String choice){
            switch(choice){
                case "1":
                    displayClientQuery() ;
                    break ;
                case "2":
                    displayAllClientQueries() ;
                    break ;
                case "3":
                    serverSocket.quit();
                    break ;
                default:
                    System.err.println("Invalid choice.");
                    System.exit(0) ;
            }
    }

    public void displayClientQuery(){
        serverSocket.printClientQuery();
    }

    public void displayAllClientQueries(){
        AllPrimeQueries.printAllQueries();
    }
 
    public void displayServerMenu(){
        System.out.println("[1] Client Name [print the name and query integer]");
        System.out.println("[2] All Client Queries [print all names and queries so far]");
        System.out.println("[3] Quit [quit the server]");
    }
}
 