package DegreeJAXB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syst3m
 */

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

public class TranscriptJaxb {
    private static Result result = new Result();
    
    public static void parseXML(String ssn){       
        
        try {
        File file = new File("src\\java\\Xml\\transcript.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Transcript.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Transcript tr = (Transcript) jaxbUnmarshaller.unmarshal(file);
        List<University> listUniversitys = tr.getUniversitys();
        Person person = null;
        for(int i = 0; i < listUniversitys.size(); ++i){
            if(listUniversitys.get(i).getPersonList().get(0).getSsn().equals(ssn)){
                person = listUniversitys.get(i).getPersonList().get(0);
                result.setUniversityName(listUniversitys.get(i).getUniversityName());
                makeXml(person);
                break;
            }
        }
        } catch(Exception e) {
            e.printStackTrace(System.err);
        }
    }
    
    private static void makeXml(Person person) throws JAXBException{
        
        result.setPersonName(person.getPersonName());
        result.setSsn(person.getSsn());
        result.setDegree(person.getDegree());
        
        int total = 0 ;
        int size = person.getCoursesList().get(0).getCoursList().size();
       
        for(int i = 0 ; i < size; ++i){
            total = total + person.getCoursesList().get(0).getCoursList().get(i).getPoint();
        }
        result.setGpa(total / size);
        
        JAXBContext jaxbContextResult = JAXBContext.newInstance(Result.class);
        Marshaller jaxbMarshaller = jaxbContextResult.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(result, new File("src\\java\\Xml\\transcriptResult.xml"));
        jaxbMarshaller.marshal(result, System.out);
        
    }
}
