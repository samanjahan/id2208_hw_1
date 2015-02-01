package EmploymentSAX;


import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@XmlRootElement(name = "employments")
public class Employments {
    
    private List<Employment> mEmployments;

    @XmlElement(name = "employment")
    public List<Employment> getEmployments() {
        return mEmployments;
    }

    public void setEmployments(List<Employment> employments) {
        this.mEmployments = employments;
    }
    
    public String toString(){
        StringBuilder text = new StringBuilder();
        text.append("<employments>\n");
        
        for(Employment e : mEmployments) {
            text.append(e.toString());
        }
        text.append("\n</elements>");
        return text.toString();
    }
    
    
}
