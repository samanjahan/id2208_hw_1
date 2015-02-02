
import CompanyDOM.CompanyDOM;
import CvDOM.CvDOM;
import DegreeJAXB.TranscriptJaxb;
import EmploymentSAX.*;
import ProfileDom.Dom;
import java.io.File;
import java.util.ArrayList;

/**
 * Used as a main and starting point for the application. Reads from a cv.xml
 * and gets the ssn of the jobSeeker. Then uses that ssn to search through other
 * databases.
 */
public class StartProfileBuilder {
    
    public static void main(String[] args) {
        
        //Get SSN from CV file
        File cvFile = new File("src/java/Xml/cv.xml");
        String ssn = CvDOM.getSSN(cvFile);
        
        //Create a employmentResult.xml file
        EmploymentSAXParser saxParser = new EmploymentSAXParser(ssn);
        
        //Create the transcriptResult.xml
        TranscriptJaxb.parseXML(ssn);

        //Get the list of employments from the SAX parser and create a list of
        //OrgNumbers to use for getting all Companies
        Employments empl = saxParser.getEmployments();
        ArrayList<String> orgNumbers = new ArrayList<>();
        ArrayList<Employment> employments = (ArrayList)empl.getEmployments();
        for(Employment e:employments){
            orgNumbers.add(e.getOrgNumber());
        }
        
        //Send the list of orgNumbers to a company parser.
        //Company parser takes a list as inparameter and creates a
        //companysResult.xml
        CompanyDOM.createCompanyFile(orgNumbers);
        
        
        //Final step is to connect all the files and create a single Profile.xml
        //file
        Dom.createProfile();
    }
    
}
