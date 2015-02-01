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
@XmlRootElement
public class Result {
    
    private String universityName;
    private String degree;
    private String ssn;
    private List<CoursResult> coursList;

    @XmlElement(name = "course")
    public List<CoursResult> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<CoursResult> coursList) {
        this.coursList = coursList;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    public String getUniversityName() {
        return universityName;
    }

    @XmlElement
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
    
    
   
    public String getDegree() {
        return degree;
    }

    @XmlElement
    public void setDegree(String degree) {
        this.degree = degree;
    }
}