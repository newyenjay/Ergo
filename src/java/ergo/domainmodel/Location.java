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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * 
 */
@Entity
@Table(name = "location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
    @NamedQuery(name = "Location.findByLocationId", query = "SELECT l FROM Location l WHERE l.locationId = :locationId"),
    @NamedQuery(name = "Location.findByAddress", query = "SELECT l FROM Location l WHERE l.address = :address")})
public class Location implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "locationId")
    private Integer locationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    @ManyToOne(optional = false)
    private Company companyId;

    /**
     * The default Location constructor, sets up the object with all default nulls. 
     */
    public Location() {
    }

    /**
     * Instantiates the Location Object with one Parameter, that being the locationId. 
     * @param locationId - the parameter that the constructor will take in and will set the locationId to.
     */
    public Location(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * Instantiates the Location Object with two Parameters, that being the locationId and address. 
     * @param locationId - the parameter that the constructor will take in and will set the locationId to.
     * @param address - the parameter that the constructor will take in and will set the address to.
     */
    public Location(Integer locationId, String address) {
        this.locationId = locationId;
        this.address = address;
    }

    /**
     * Returns the locationId value of the object. 
     * pre - the Object must have a locationId. 
     * 
     * @return - An Integer value that represents the Object's locationId. 
     */
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * Takes in a parameter and sets the locationId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the locationId value has been updated.
     * 
     * @param locationId - An Integer value that represents the Object's locationId that will replace the current value. 
     */
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * Returns the address value of the object. 
     * pre - the Object must have a address. 
     * 
     * @return - An Integer value that represents the Object's address. 
     */
    public String getAddress() {
        return address;
    }

    /**
     * Takes in a parameter and sets the address object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the address value has been updated.
     * 
     * @param address - An Integer value that represents the Object's address that will replace the current value. 
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the companyId value of the object. 
     * pre - the Object must have a companyId. 
     * 
     * @return - An Integer value that represents the Object's companyId. 
     */
    public Company getCompanyId() {
        return companyId;
    }

    /**
     * Takes in a parameter and sets the companyId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the companyId value has been updated.
     * 
     * @param companyId - An Integer value that represents the Object's companyId that will replace the current value. 
     */
    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Location[ locationId=" + locationId + " ]";
    }
    
}
