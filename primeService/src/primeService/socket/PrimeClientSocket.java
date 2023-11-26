package primeService.socket;

import java.net.Socket;

public class PrimeClientSocket {
    private Socket socket = null;
    public PrimeClientWorker clientWorker ;

    public PrimeClientSocket(String ipAddress, int port){
        try {
            socket = new Socket(ipAddress, port);
            System.out.println("Connected");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        clientWorker = new PrimeClientWorker(socket) ;
    }

    public void setClientName(){
        clientWorker.setClientName() ;
    }

    public void setClientNumber(){
        clientWorker.setClientNumber() ;
    }

    public void getServerResponse(){
        clientWorker.getServerResponse() ;
    }

    public void quit(){
        clientWorker.quit() ;
    }

    public void run(){
        clientWorker.run() ;
    }
}
