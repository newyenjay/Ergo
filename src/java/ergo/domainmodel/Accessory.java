/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * The accessory class that represents one of the database tables. 
 * @version 1.0 Implemented Javadoc. 
 */
@Entity
@Table(name = "accessory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessory.findAll", query = "SELECT a FROM Accessory a"),
    @NamedQuery(name = "Accessory.findByAccessoryId", query = "SELECT a FROM Accessory a WHERE a.accessoryId = :accessoryId")})
public class Accessory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accessoryId")
    private Integer accessoryId;

    /**
     * The default constructor with no parameters. Will create a base object with no variables. 
     */
    public Accessory() {
    }

    /**
     * One of the many constructors, will take in a AccessoryID, and from there create a Accessory Object with one of the instance variables being the AccessoryID.
     * @param accessoryId - The representation of the AccessoryId, is used to identify the Accessory in the database. 
     */
    public Accessory(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    /**
     * Returns the Accessory ID from the Object as an integer.
     * Pre - The Accessory ID must have an instantiated accessoryID. 
     * Post - Returns the AccessoryId as an Integer value. 
     * 
     * @return Returns the AccessoryId as an Integer value. 
     */
    public Integer getAccessoryId() {
        return accessoryId;
    }

    /**
     * Takes in a parameter and sets the AccessoryId to the new parameter. 
     * Pre - the Accessory has an old Accessory Id. 
     * Post - the Accessory now has the new AccessoryId set. 
     * 
     * @param accessoryId - An integer value that replaces the current AccessoryId of the Accessory Object. 
     */
    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessoryId != null ? accessoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessory)) {
            return false;
        }
        Accessory other = (Accessory) object;
        if ((this.accessoryId == null && other.accessoryId != null) || (this.accessoryId != null && !this.accessoryId.equals(other.accessoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Accessory[ accessoryId=" + accessoryId + " ]";
    }
    
}
