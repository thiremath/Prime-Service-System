package primeService.util;

public class CheckPrime {
    int i = 2;
    
    public String isPrime(int n)
    {
        if (n == 0 || n == 1) return "No";
 
        if (n == i) return "Yes";
 
        if (n % i == 0) return "No";
        i++;
        return isPrime(n);
    }
}
