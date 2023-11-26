package primeService.driver;

import primeService.client.ClientDriver;

/**
 * @author placeholder
 *
 */
public class PrimeDriver {
    public static void main(String args[])
    {
        ClientDriver client = new ClientDriver("127.0.0.1", 5000);
    }
}
