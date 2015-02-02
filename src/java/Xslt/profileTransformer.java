
package Xslt;

import java.io.FileOutputStream;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class profileTransformer {
    
    public static void main(String[] args) {
		try {
			TransformerFactory  tFactory =  TransformerFactory.newInstance();
			Source xslSource = new StreamSource( "src/java/Xslt/profile.xsl" );
			Transformer transformer = tFactory.newTransformer( xslSource );
                        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform( new StreamSource( "src/java/Xml/pr.xml" ),new StreamResult( new FileOutputStream( "src/java/Xslt/finalProfile.xml" )));

		}catch(Exception ex) {
			 ex.printStackTrace();
		}

	}
    
}
