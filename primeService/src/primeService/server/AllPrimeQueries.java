package primeService.server;

import java.util.ArrayList;

public class AllPrimeQueries {
    public static ArrayList<String> allQueries = new ArrayList<String>() ;

    public static void addClientQuery(String queryIn){
        allQueries.add(queryIn) ;
    }
    public static void printAllQueries(){
        if(allQueries != null){
            for(String q: allQueries){
                System.out.println(q);
            }
        }
    }
}
