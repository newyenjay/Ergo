/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @version 1.0 - Instantiated Javadoc 14/04/2016
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByCompanyId", query = "SELECT c FROM Company c WHERE c.companyId = :companyId"),
    @NamedQuery(name = "Company.findByName", query = "SELECT c FROM Company c WHERE c.name = :name")})
public class Company implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyId")
    private Integer companyId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private List<Client> clientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "companyId")
    private List<Location> locationList;

    /**
     * The default Company constructor, sets up the object with all default nulls. 
     * Pre - none
     */
    public Company() {
    }

    /**
     * Instantiates the Company Object with one Parameter, that being the companyId. 
     * @param companyId - the parameter that the constructor will take in and will set the companyId to.
     */
    public Company(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * Instantiates the Company Object with twoParameters. Those being companyId, and name. 
     * Pre - parameters must be their designated parameters. 
     * @param companyId - the parameter that the constructor will take in and will set the companyId to.
     * @param name - the parameter that the constructor will take in and will set the name to.
     */
    public Company(Integer companyId, String name) {
        this.companyId = companyId;
        this.name = name;
    }

    /**
     * Returns the companyId value of the object. 
     * pre - the Object must have a companyId. 
     * 
     * @return - An Integer value that represents the Object's companyId. 
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * Takes in a parameter and sets the companyId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the companyId value has been updated.
     * 
     * @param companyId - An Integer value that represents the Object's companyId that will replace the current value. 
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * Returns the Name of the Company. 
     * pre - the Object must have a name. 
     * 
     * @return - A String value that represents the Object's name. 
     */
    public String getName() {
        return name;
    }

    /**
     * Takes in a parameter and sets the name object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the name value has been updated.
     * 
     * @param name - A String value that represents the Object's name that will replace the current value. 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the clientList list of the object. 
     * pre - the object must have a clientList list. 
     * 
     * @return - A Java.util.list value that represents the Object's clientList list. 
     */
    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * Takes in a parameter and sets the clientList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the clientList has been updated.
     * 
     * @param clientList - A java.util.list object that is going to replace the current list. 
     */
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    /**
     * Returns the locationList list of the object. 
     * pre - the object must have a locationList list. 
     * 
     * @return - A Java.util.list value that represents the Object's locationList list. 
     */
    @XmlTransient
    public List<Location> getLocationList() {
        return locationList;
    }

    /**
     * Takes in a parameter and sets the locationList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the locationList has been updated.
     * 
     * @param locationList - A java.util.list object that is going to replace the current list. 
     */
    public void setLocationList(List<Location> locationList) {
        this.locationList = locationList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyId != null ? companyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyId == null && other.companyId != null) || (this.companyId != null && !this.companyId.equals(other.companyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Company[ companyId=" + companyId + " ]";
    }
    
}
