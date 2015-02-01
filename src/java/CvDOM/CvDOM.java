/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CvDOM;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

/**
 *
 * @author Alex
 */
public class CvDOM {

    private static Document doc = null;

    public static String getSSN(File file) {
        String ssn = null;
        
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            doc = builder.parse(file);
            
            NodeList nl = doc.getElementsByTagName("ssn");
            Node result = nl.item(0);
            ssn = result.getTextContent();
            

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        
        
        return ssn;
    }


}
