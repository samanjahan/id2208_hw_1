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
@XmlRootElement(name = "cours")
class Cours {
   
   private String name;
   private int point;
   private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }    
}
