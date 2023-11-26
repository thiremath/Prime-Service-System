package primeService.client;
 
import java.util.Scanner;
 
public class ClientMenu {
 
    public ClientDriver clientDriver ;
    // public String choice ;
 
    public ClientMenu(ClientDriver clientDriverIn){
        clientDriver = clientDriverIn ;
        // choice = null ;
    }
 
    public void processClientMenu(String choice){
        Scanner scanner = new Scanner(System.in);
            displayClientMenu();
            switch(choice){
                case "1":
                    clientDriver.setClientName() ;
                    break ;
                case "2":
                    clientDriver.setClientNumber() ;
                    break ;
                case "3":
                    clientDriver.getServerResponse() ;
                    break ;
                case "4":
                    clientDriver.quit() ;
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
 