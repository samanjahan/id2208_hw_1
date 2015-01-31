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

@XmlRootElement(name = "person")
public class Person {
    
   
   private List<Courses> coursesList;

   @XmlElement(name = "courses") 
   public List<Courses> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<Courses> coursesList) {
        this.coursesList = coursesList;
    }
   private String personName;
   private String ssn;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
   private String degree;
   private int year;
        
    
    public void setDegree(String degree){
        this.degree = degree;
    }
    
     
    public String getDegree(){
        return  degree;
    }
        
   
    public void setPersonName(String personName){
        this.personName = personName;
    }
    
    public String getPersonName(){
        return  personName;
    }
    
    public void setYear(int year){
        this.year = year;
    }
    
    public int setYear(){
        return year;
    }
    
}
