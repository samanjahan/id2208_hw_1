package EmploymentSAX;


import javax.xml.bind.annotation.XmlElement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */

public class Employment {
   
    
    private String orgN = null;    
    private String startD = null;
    private String endD = null;    
    
    
    // GETTERS AND SETTERS

    @XmlElement(name = "orgNumber")
    public String getOrgNumber() {
        return orgN;
    }

    public void setOrgNumber(String orgNumber) {
        this.orgN = orgNumber;
    }

    @XmlElement(name = "startDate")
    public String getStartDate() {
        return startD;
    }

    public void setStartDate(String startDate) {
        this.startD = startDate;
    }

    @XmlElement(name = "endDate")
    public String getEndDate() {
        return endD;
    }

    public void setEndDate(String endDate) {
        this.endD = endDate;
    }

        public String toString() {
        String text = "<employment>\n<orgNumber>" + orgN + "</orgNumber>\n<startDate>"+ startD + "</startDate>\n<endDate>"+ endD + "</endDate>\n </employment>";
        return text; //To change body of generated methods, choose Tools | Templates.
    }
    
}
