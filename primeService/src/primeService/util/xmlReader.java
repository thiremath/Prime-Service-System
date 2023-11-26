package primeService.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class xmlReader {
    public static void read(String s){
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(s));
            Document doc = builder.parse(src);
            pair.clientName = doc.getElementsByTagName("clientName").item(0).getTextContent();
            pair.isPrime = doc.getElementsByTagName("isPrime").item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace() ;
        }
    }
}
