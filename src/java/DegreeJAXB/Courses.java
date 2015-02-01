/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DegreeJAXB;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author syst3m
 */
@XmlRootElement(name = "courses")
public class Courses {
    
        
    private List<Cours> coursList;
    
    @XmlElement(name = "course")
    public List <Cours> getCoursList() {
        return coursList;
    }
    
    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }
}