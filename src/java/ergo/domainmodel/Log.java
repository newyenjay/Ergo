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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 671402
 */
@Entity
@Table(name = "log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
    @NamedQuery(name = "Log.findByClientId", query = "SELECT l FROM Log l WHERE l.clientId = :clientId"),
    @NamedQuery(name = "Log.findByEmployeeId", query = "SELECT l FROM Log l WHERE l.employeeId = :employeeId"),
    @NamedQuery(name = "Log.findByAction", query = "SELECT l FROM Log l WHERE l.action = :action")})
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientId")
    private Integer clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employeeId")
    private int employeeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "action")
    private String action;

    /**
     * The default Location constructor, sets up the object with all default nulls. 
     */
    public Log() {
    }

    /**
     * Instantiates the Location Object with one Parameter, that being the locationId. 
     * @param clientId - the parameter that the constructor will take in and will set the clientId to.
     */
    public Log(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * Instantiates the Location Object with three Parameters, that being the locationId, employeeId, and action. 
     * @param clientId
     * @param employeeId
     * @param action 
     */
    public Log(Integer clientId, int employeeId, String action) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.action = action;
    }

    /**
     * Returns the clientId value of the object. 
     * pre - the Object must have a clientId. 
     * 
     * @return - An Integer value that represents the Object's clientId. 
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * Takes in a parameter and sets the clientId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the clientId value has been updated.
     * 
     * @param clientId - An Integer value that represents the Object's clientId that will replace the current value. 
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * Returns the employeeId value of the object. 
     * pre - the Object must have a employeeId. 
     * 
     * @return - An Integer value that represents the Object's employeeId. 
     */
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * Takes in a parameter and sets the employeeId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the employeeId value has been updated.
     * 
     * @param employeeId - An Integer value that represents the Object's employeeId that will replace the current value. 
     */
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Returns the action value of the object. 
     * pre - the Object must have a action. 
     * 
     * @return - An Integer value that represents the Object's action. 
     */
    public String getAction() {
        return action;
    }

     /**
     * Takes in a parameter and sets the action object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the action value has been updated.
     * 
     * @param action - An Integer value that represents the Object's action that will replace the current value. 
     */
    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Log[ clientId=" + clientId + " ]";
    }
    
}
