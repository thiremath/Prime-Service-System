package primeService.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllPrimeQueries {
    public static List<String> allQueries = Collections.synchronizedList(new ArrayList<String>()) ;

    public static void addClientQuery(String queryIn){
        allQueries.add(queryIn) ;
    }
    public static void printAllQueries(){
        if(allQueries != null){
            for(int i=0;i<allQueries.size();i++){
                System.out.println(allQueries.get(i));
            }
        }
    }
}
