package primeService.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class xmlReader {
    pair p = null ;
    public pair read(String s){
        try {
            p = new pair() ;
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(s));
            Document doc = builder.parse(src);
            p.clientName = doc.getElementsByTagName("clientName").item(0).getTextContent();
            p.isPrime = doc.getElementsByTagName("isPrime").item(0).getTextContent();
        } catch (Exception e) {
            e.printStackTrace() ;
        }
        return p ;
    }
}
