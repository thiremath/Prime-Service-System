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
		try {
			if(args[0].equals("${arg0}") || args[0].equals("")){
				System.err.println("Please enter argument/s!");
				System.exit(0);
			}
			else if(args[1].equals("${arg1}") || args[1].equals("")){
				ServerDriver server = new ServerDriver(Integer.parseInt(args[0]));
			}
			else{
				ClientDriver client = new ClientDriver(args[0], Integer.parseInt(args[1]));
			}
		} catch (Exception e) {
			System.err.println("Exception- "+e);
			e.printStackTrace();
			System.exit(0);
		}
    }
}
