package ProfileDom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author syst3m
 */
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import org.xml.sax.SAXException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import javax.xml.transform.TransformerFactory;
import org.w3c.dom.Element;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Dom {

    static final String W3C_XML_SCHEMA = "src/java/Xml/cv.xsd";

    public static void createProfile() {

        try {

            //System.out.println("hahahahahahahahah");
            File cvFile = new File("src/java/Xml/cv.xml");
            File companyFile = new File("src/java/Xml/company.xml");
            File recordsFile = new File("src/java/Xml/employmentsresult.xml");
            File transcriptFile = new File("src/java/Xml/transcriptResult.xml");

            DocumentBuilderFactory factoryProfile = DocumentBuilderFactory.newInstance();

            DocumentBuilderFactory factoryCv = DocumentBuilderFactory.newInstance();
            DocumentBuilderFactory factoryCompany = DocumentBuilderFactory.newInstance();
            DocumentBuilderFactory factoryRecord = DocumentBuilderFactory.newInstance();
            DocumentBuilderFactory factoryTranscript = DocumentBuilderFactory.newInstance();

            DocumentBuilder dBuilderCv = factoryCv.newDocumentBuilder();
            DocumentBuilder dBuilderCompany = factoryCompany.newDocumentBuilder();
            DocumentBuilder dBuilderRecord = factoryRecord.newDocumentBuilder();
            DocumentBuilder dBuilderTranscript = factoryTranscript.newDocumentBuilder();
            DocumentBuilder docBuilderProfile = factoryProfile.newDocumentBuilder();

            Document docCv = null;
            Document docCompany = null;
            Document docRecord = null;
            Document docTranscript = null;
            Document docProfile = docBuilderProfile.newDocument();

            Element rootElement = docProfile.createElement("profile");
            docProfile.appendChild(rootElement);

            try {
                docCv = dBuilderCv.parse(cvFile);
                docCompany = dBuilderCv.parse(companyFile);
                docTranscript = dBuilderTranscript.parse(transcriptFile);
            } catch (SAXException ex) {
                Logger.getLogger(Dom.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Dom.class.getName()).log(Level.SEVERE, null, ex);
            }

            NodeList nListCv = docCv.getElementsByTagName("cv");
            NodeList nListTranscript = docTranscript.getElementsByTagName("result");
            NodeList nListCompany = docCompany.getElementsByTagName("name");
            NodeList nListRecord = docCv.getElementsByTagName("name");
            System.out.println("size " + nListCv.getLength());
            for (int i = 0; i < nListCv.getLength(); ++i) {
                Node nNodeCv = nListCv.item(i);
                Element eElementCv = (Element) nNodeCv;

                Element personElement = docProfile.createElement("person");
                Element coursesElement = docProfile.createElement("courses");
                Element nameElement = docProfile.createElement("name");
                Element surNameElement = docProfile.createElement("surName");
                Element ssnElement = docProfile.createElement("ssn");
                Element genderElement = docProfile.createElement("gender");
                Element emailElement = docProfile.createElement("email");
                Element letterElement = docProfile.createElement("letter");

                String personName = eElementCv.getElementsByTagName("firstName").item(0).getTextContent();
                System.out.println("name " + personName);
                rootElement.appendChild(personElement);

                nameElement.appendChild(docProfile.createTextNode(personName));
                personElement.appendChild(nameElement);

                surNameElement.appendChild(docProfile.createTextNode(eElementCv.getElementsByTagName("surName").item(0).getTextContent()));
                personElement.appendChild(surNameElement);

                ssnElement.appendChild(docProfile.createTextNode(eElementCv.getElementsByTagName("ssn").item(0).getTextContent()));
                personElement.appendChild(ssnElement);

                genderElement.appendChild(docProfile.createTextNode(eElementCv.getElementsByTagName("gender").item(0).getTextContent()));
                personElement.appendChild(genderElement);

                emailElement.appendChild(docProfile.createTextNode(eElementCv.getElementsByTagName("email").item(0).getTextContent()));
                personElement.appendChild(emailElement);
                
                letterElement.appendChild(docProfile.createTextNode(eElementCv.getElementsByTagName("letter").item(0).getTextContent()));
                personElement.appendChild(letterElement);

                Element universityElement = docProfile.createElement("university");
                personElement.appendChild(universityElement);

                for (int j = 0; j < nListTranscript.getLength(); ++j) {

                    Element universityNameElement = docProfile.createElement("universityName");
                    Element degreeElement = docProfile.createElement("degree");

                    Node nNodeTrans = nListTranscript.item(j);

                    Element eElementtrans = (Element) nNodeTrans;
                    universityNameElement.appendChild(docProfile.createTextNode(eElementtrans.getElementsByTagName("universityName").item(0).getTextContent()));
                    degreeElement.appendChild(docProfile.createTextNode(eElementtrans.getElementsByTagName("degree").item(0).getTextContent()));
                    for (int k = 0; k < eElementtrans.getElementsByTagName("course").getLength(); ++k) {

                        Element courseNameElement = docProfile.createElement("courseName");
                        Element pointElement = docProfile.createElement("point");

                        Node nNodeCours = eElementtrans.getElementsByTagName("course").item(k);
                        Element eElementCourse = (Element) nNodeCours;

                        courseNameElement.appendChild(docProfile.createTextNode(eElementCourse.getElementsByTagName("courseName").item(0).getTextContent()));
                        pointElement.appendChild(docProfile.createTextNode(eElementCourse.getElementsByTagName("point").item(0).getTextContent()));

                        coursesElement.appendChild(courseNameElement);
                        coursesElement.appendChild(pointElement);
                    }

                    universityElement.appendChild(coursesElement);
                    universityElement.appendChild(universityNameElement);
                    universityElement.appendChild(degreeElement);

                    Element degree = docProfile.createElement("degree");

                }
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(docProfile);
            StreamResult result = new StreamResult(new File("src/java/Xml/pr.xml"));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

    }
}
