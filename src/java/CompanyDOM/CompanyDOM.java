package CompanyDOM;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

public class CompanyDOM {

/*
    public static void main(String[] args) {
        ArrayList companies = new ArrayList();
        companies.add("1223234590");
        companies.add("1223235551");
        createCompanyFile(companies);
    }
*/
    public static void createCompanyFile(ArrayList<String> companies) {

        try {

            File file = new File("src/java/Xml/company.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document inPutDoc = builder.parse(file);
            NodeList nodes = inPutDoc.getElementsByTagName("orgNumber");

            //Create Document
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dFactory.newDocumentBuilder();
            Document outputDocument = dBuilder.newDocument();
            Element rootElement = outputDocument.createElement("companies");
            outputDocument.appendChild(rootElement);

            //Create Elements in outPut
            for (String orgNumber : companies) {
                for (int i = 0; i < nodes.getLength(); i++) {
                    if (nodes.item(i).getTextContent().equals(orgNumber)) {
                        Node node = nodes.item(i).getNextSibling().getNextSibling();
                        Node copy = outputDocument.importNode(node, true);
                        rootElement.appendChild(copy);
                //System.out.println(nodes.item(i).getNextSibling().getNextSibling());
                        //Element companyElement = (Element) nodes.item(i).getNextSibling().getNextSibling();
                        //Element nameElement = (Element) companyElement.getElementsByTagName("companyName").item(0);

                        //doc.getFirstChild().appendChild(nodes.item(i).getNextSibling().getNextSibling().cloneNode(true));
                    }
                }
            }

            //Create outPut File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(outputDocument);
            StreamResult result = new StreamResult(new File("src\\java\\Xml\\companiesResult.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }
}
