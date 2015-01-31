/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author syst3m
 */
@XmlRootElement
public class Result {
    
    private String universityName;
    private String personName;
    private String degree;
    private int gpa;
    private String ssn;

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
    
    
    public String getPersonName() {
        return personName;
    }

    @XmlElement
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    
   
    public String getDegree() {
        return degree;
    }

     @XmlElement
    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    
    public int getGpa() {
        return gpa;
    }

    @XmlElement
    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
}
