package primeService.client;

import primeService.socket.PrimeClientSocket;

public class ClientMenu {
 
    public PrimeClientSocket clientSocket ;
 
    public ClientMenu(PrimeClientSocket clientSocketIn){
        clientSocket = clientSocketIn ;
    }
 
    public void processClientMenu(String choice){
            switch(choice){
                case "1":
                    clientSocket.setClientName() ;
                    break ;
                case "2":
                    clientSocket.setClientNumber() ;
                    break ;
                case "3":
                    clientSocket.getServerResponse() ;
                    break ;
                case "4":
                    clientSocket.quit() ;
                    break ;
                default:
                    System.err.println("Invalid choice.");
                    System.exit(0) ;
            }
    }
 
    public void displayClientMenu(){
        System.out.println("[1] Set client name");
        System.out.println("[2] Enter number to query for prime");
        System.out.println("[3] What is the server response?");
        System.out.println("[4] Quit");
    }

}
 