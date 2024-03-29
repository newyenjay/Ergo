/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * 
 */
@Entity
@Table(name = "privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p"),
    @NamedQuery(name = "Privilege.findByPrivilegeId", query = "SELECT p FROM Privilege p WHERE p.privilegeId = :privilegeId"),
    @NamedQuery(name = "Privilege.findByDescription", query = "SELECT p FROM Privilege p WHERE p.description = :description")})
public class Privilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "privilegeId")
    private Integer privilegeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "description")
    private String description;
    @JoinTable(name = "employeeprivilege", joinColumns = {
        @JoinColumn(name = "privilegeId", referencedColumnName = "privilegeId")}, inverseJoinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")})
    @ManyToMany
    private List<Employee> employeeList;

    /**
     * The default Privilege constructor, sets up the object with all default nulls. 
     */
    public Privilege() {
    }

    /**
     * Instantiates the Location Object with one Parameter, that being the privilegeId. 
     * @param privilegeId 
     */
    public Privilege(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    /**
     * Instantiates the Location Object with two Parameters, that being the privilegeId and description. 
     * @param privilegeId
     * @param description 
     */
    public Privilege(Integer privilegeId, String description) {
        this.privilegeId = privilegeId;
        this.description = description;
    }

    /**
     * Returns the privilegeId value of the object. 
     * pre - the Object must have a privilegeId. 
     * 
     * @return - An Integer value that represents the Object's privilegeId. 
     */
    public Integer getPrivilegeId() {
        return privilegeId;
    }

    /**
     * Takes in a parameter and sets the privilegeId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the privilegeId value has been updated.
     * 
     * @param privilegeId - An Integer value that represents the Object's privilegeId that will replace the current value. 
     */
    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Takes in a parameter and sets the description object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the description value has been updated.
     * 
     * @param description - A String value that represents the Object's description that will replace the current value. 
     */
    public void setDescription(String description) {
        this.description = description;
    }

     /**
     * Returns the employeeList list of the object. 
     * pre - the object must have a employeeList list. 
     * 
     * @return - A Java.util.list value that represents the Object's employeeList list. 
     */
    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Takes in a parameter and sets the employeeList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the employeeList has been updated.
     * 
     * @param employeeList - A java.util.list object that is going to replace the current list. 
     */
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegeId != null ? privilegeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.privilegeId == null && other.privilegeId != null) || (this.privilegeId != null && !this.privilegeId.equals(other.privilegeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Privilege[ privilegeId=" + privilegeId + " ]";
    }
    
}
