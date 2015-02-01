package DegreeJAXB;


import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syst3m
 */
@XmlRootElement(name = "university")
public class University {
        
   private String universityName;
    
    
    private List<Person> personList;
    
    public void setUniversityName(String universityName){
        this.universityName = universityName;
    }
    
    public String getUniversityName(){
        return  universityName;
    }
    
    @XmlElement(name = "person")
    public List <Person> getPersonList() {
        return personList;
    }
    
    public void setPersonList(List<Person> personList){
        this.personList = personList;
    }
}
