package jaxb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author syst3m
 */

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "transcript")
public class Transcript {
    
    private List<University> universityList;
    
    
    
    @XmlElement(name = "university")
    public List <University> getUniversitys() {
        return universityList;
    }
    
    public void setUniversitys(List<University> universityList) {
        this.universityList = universityList;
    }

}
