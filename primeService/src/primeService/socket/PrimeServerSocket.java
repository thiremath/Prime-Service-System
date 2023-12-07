package primeService.socket;

import java.net.ServerSocket;
import java.net.Socket;

public class PrimeServerSocket extends Thread {
    public Socket socket = null;
    public ServerSocket server = null;
    private PrimeServerWorker serverWorker ;

    public PrimeServerSocket(int port){
        try {
            server = new ServerSocket(port) ;
        } catch (Exception e) {
            // e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Server started");
        System.out.println("Waiting for a client ...");
    }

    public void quit(){
        if(serverWorker == null){
            System.exit(0);
        }
        serverWorker.quit();
    }

    public void printClientQuery(){
        serverWorker.printClientQuery();
    }

    public void run(){
        while (true) {
            try {
                socket = server.accept();
                System.out.println("Client accepted");
                serverWorker = new PrimeServerWorker(socket) ;
                serverWorker.start();
            } catch (Exception e) {
                // e.printStackTrace();
                System.exit(0);
            }
        }    
    }

}
