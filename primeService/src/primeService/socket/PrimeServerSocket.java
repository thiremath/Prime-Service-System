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
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Server started");
        System.out.println("Waiting for a client ...");

        try {
            socket = server.accept();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Client accepted");

        serverWorker = new PrimeServerWorker(socket) ;

    }

    public void quit(){
        serverWorker.quit();
    }

    public void run(){
        try {
            serverWorker.start();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

}
