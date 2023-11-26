package primeService.server;

// AllPrimeQueries.java

import java.util.ArrayList;

public class AllPrimeQueries {
    private ArrayList<String> clientNames;
    private ArrayList<ArrayList<Integer>> clientQueries;

    public AllPrimeQueries() {
        this.clientNames = new ArrayList<>();
        this.clientQueries = new ArrayList<>();
    }

    public void addQuery(String clientName, ArrayList<Integer> queries) {
        this.clientNames.add(clientName);
        this.clientQueries.add(new ArrayList<>(queries));
    }

    public ArrayList<String> getClientNames() {
        return new ArrayList<>(this.clientNames);
    }

    public ArrayList<ArrayList<Integer>> getClientQueries() {
        return new ArrayList<>(this.clientQueries);
    }
}
