package primeService.driver;

import primeService.client.ClientDriver;
import primeService.server.ServerDriver;

/**
 * @author placeholder
 *
 */
public class PrimeDriver {
    public static void main(String args[])
    {
		if(args[0].equals("1")){
        	ClientDriver client = new ClientDriver("127.0.0.1", 4000);
		}
		else{
			ServerDriver server = new ServerDriver(4000);
		}
    }
}
