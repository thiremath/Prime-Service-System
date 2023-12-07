package primeService.driver;

import primeService.client.ClientDriver;
import primeService.server.ServerDriver;
import primeService.util.Debug;

/**
 * @author placeholder
 *
 */
public class PrimeDriver {
	public static String errorLogFileName ;
    public static void main(String args[])
    {
		try {
			if(args[0].equals("${arg0}") || args[0].equals("")){
				System.err.println("Please enter argument/s!");
				System.exit(0);
			}
			else if(args[3].equals("${arg3}") || args[3].equals("")){
				errorLogFileName = args[1] ;
				Debug.setDebugValue(Integer.parseInt(args[2])) ;
				ServerDriver server = new ServerDriver(Integer.parseInt(args[0]));
			}
			else{
				errorLogFileName = args[2] ;
				Debug.setDebugValue(Integer.parseInt(args[3])) ;
				ClientDriver client = new ClientDriver(args[0], Integer.parseInt(args[1]));
			}
		} catch (Exception e) {
			System.err.println("Exception- "+e);
			// e.printStackTrace();
			System.exit(0);
		}
    }
}
