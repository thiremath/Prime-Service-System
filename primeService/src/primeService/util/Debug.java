package primeService.util;

import primeService.util.Debug.DebugLevel;

public class Debug {

    public static enum DebugLevel { CLIENTWORKER, SERVERWORKER, NONE };

    private static DebugLevel debugLevel;

    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 1: debugLevel = DebugLevel.CLIENTWORKER; break;
            case 2: debugLevel = DebugLevel.SERVERWORKER; break;
            default: debugLevel = DebugLevel.NONE; break;
        }
    }

    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage (String message, DebugLevel levelIn){
        if (levelIn == debugLevel) System.out.println(message);
    }

    public static void writeError (Exception e, String exception, DebugLevel levelIn){
        if (levelIn == debugLevel) {
            if(exception != null){
                System.err.println(exception);
            }
            if(e != null){
                System.err.println(e);
            }
        }
    }

    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }

}