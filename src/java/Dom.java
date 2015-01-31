/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syst3m
 */

import org.w3c.dom.Document;import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
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
  static final String W3C_XML_SCHEMA = "cv.xsd";
    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException {
        
        File cvFile = new File("web/WEB-INF/cv.xml");
        File companyFile = new File("web/WEB-INF/company.xml");
        File recordsFile = new File("web/WEB-INF/employmentrecords.xml");
        File transcriptFile = new File("web/WEB-INF/transcript.xml");
        
        
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
        
   
        NodeList nListCv = docCv.getElementsByTagName("person");
        NodeList nListTranscript = docTranscript.getElementsByTagName("university");
        NodeList nListCompany = docCompany.getElementsByTagName("name");
        NodeList nListRecord = docCv.getElementsByTagName("name");
        
        for(int i = 0 ; i < nListCv.getLength(); ++i ){
            Node nNode = nListCv.item(i);
            Element eElement = (Element) nNode;
            
            Element personElement = docProfile.createElement("person");
            Element nameElement = docProfile.createElement("name");
            Element surNameElement = docProfile.createElement("surName");
            
            String personName = eElement.getElementsByTagName("name").item(0).getTextContent();
            rootElement.appendChild(personElement);
            
            nameElement.appendChild(docProfile.createTextNode(personName));
            personElement.appendChild(nameElement);
            
            surNameElement.appendChild(docProfile.createTextNode(eElement.getElementsByTagName("surName").item(0).getTextContent()));
            personElement.appendChild(surNameElement);
            
            Element universityElement = docProfile.createElement("university");
            personElement.appendChild(universityElement);
            
            for(int j = 0 ; j < nListTranscript.getLength(); ++j){
                
                
                Element universityName = docProfile.createElement("universityName");
                Element degreeElement = docProfile.createElement("degree");               


                System.out.println("j" + j);
                Node nNodeTrans = nListTranscript.item(j);
                
                Element eElementtrans = (Element) nNodeTrans;
                String personNamefromtranscript = eElementtrans.getElementsByTagName("name").item(0).getTextContent() ;
               
                if(personNamefromtranscript.equals(personName)){
                    universityName.appendChild(docProfile.createTextNode(eElementtrans.getElementsByTagName("universityName").item(0).getTextContent()));
                    degreeElement.appendChild(docProfile.createTextNode(eElementtrans.getElementsByTagName("degree").item(0).getTextContent()));
                    universityElement.appendChild(universityName);
                    universityElement.appendChild(degreeElement);
                }
                
                
                
                
                Element degree = docProfile.createElement("degree");
                
                
            }
        }
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(docProfile);
        StreamResult result =  new StreamResult(new File("web/WEB-INF/pr.xml"));
        transformer.transform(source, result);
    }
}
