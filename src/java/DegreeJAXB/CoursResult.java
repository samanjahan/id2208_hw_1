/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DegreeJAXB;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author syst3m
 */
@XmlRootElement(name = "course")
class CoursResult {
    private String courseName;
    private int point;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    
}
