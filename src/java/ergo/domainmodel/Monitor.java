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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author waynelin
 */
@Entity
@Table(name = "monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m"),
    @NamedQuery(name = "Monitor.findByMonitorId", query = "SELECT m FROM Monitor m WHERE m.monitorId = :monitorId"),
    @NamedQuery(name = "Monitor.findByType", query = "SELECT m FROM Monitor m WHERE m.type = :type"),
    @NamedQuery(name = "Monitor.findByCurrent", query = "SELECT m FROM Monitor m WHERE m.current = :current"),
    @NamedQuery(name = "Monitor.findByRecommand", query = "SELECT m FROM Monitor m WHERE m.recommand = :recommand"),
    @NamedQuery(name = "Monitor.findBySitStand", query = "SELECT m FROM Monitor m WHERE m.sitStand = :sitStand"),
    @NamedQuery(name = "Monitor.findByPwaeId", query = "SELECT m FROM Monitor m WHERE m.pwaeId = :pwaeId")})
public class Monitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "monitorId")
    private Integer monitorId;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "current")
    private String current;
    @Size(max = 45)
    @Column(name = "recommand")
    private String recommand;
    @Size(max = 45)
    @Column(name = "sitStand")
    private String sitStand;
    @JoinColumn(name = "pwaeId", referencedColumnName = "pwaeId")
    @ManyToOne(optional = false)
    private Pwae pwaeId;

    /**
     * The default Location constructor, sets up the object with all default nulls. 
     */
    public Monitor() {
    }

    /**
     * Instantiates the Location Object with one Parameter, that being the monitorId. 
     * @param monitorId 
     */
    public Monitor(Integer monitorId) {
        this.monitorId = monitorId;
    }

    /**
     * Returns the monitorId value of the object. 
     * pre - the Object must have a monitorId. 
     * 
     * @return - An Integer value that represents the Object's monitorId. 
     */
    public Integer getMonitorId() {
        return monitorId;
    }

    /**
     * Takes in a parameter and sets the monitorId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the monitorId value has been updated.
     * 
     * @param monitorId - An Integer value that represents the Object's monitorId that will replace the current value. 
     */
    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    /**
     * Returns the type value of the object. 
     * pre - the Object must have a type. 
     * 
     * @return - An Integer value that represents the Object's type. 
     */
    public String getType() {
        return type;
    }

    /**
     * Takes in a parameter and sets the type object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the type value has been updated.
     * 
     * @param type - An Integer value that represents the Object's type that will replace the current value. 
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the current value of the object. 
     * pre - the Object must have a current. 
     * 
     * @return - An Integer value that represents the Object's current. 
     */
    public String getCurrent() {
        return current;
    }

    /**
     * Takes in a parameter and sets the current object variable to that parameters. 
     * Pre - the Parameter must be a String
     * post - the current value has been updated.
     * 
     * @param current - A String value that represents the Object's current that will replace the current value. 
     */
    public void setCurrent(String current) {
        this.current = current;
    }

    /**
     * Returns the recommendation value of the object. 
     * pre - the Object must have a recommendation. 
     * 
     * @return - A String value that represents the Object's recommendation. 
     */
    public String getRecommand() {
        return recommand;
    }

    /**
     * Takes in a parameter and sets the recommand object variable to that parameters. 
     * Pre - the Parameter must be a String
     * post - the recommand value has been updated.
     * 
     * @param recommand - A String value that represents the Object's recommand that will replace the current value. 
     */
    public void setRecommand(String recommand) {
        this.recommand = recommand;
    }

    /**
     * Returns the sitStand value of the object. 
     * pre - the Object must have a sitStand. 
     * 
     * @return - A String value that represents the Object's sitStand. 
     */
    public String getSitStand() {
        return sitStand;
    }

    /**
     * Takes in a parameter and sets the sitStand object variable to that parameters. 
     * Pre - the Parameter must be a String
     * post - the recommendation value has been updated.
     * 
     * @param sitStand - A String value that represents the Object's sitStand that will replace the current value. 
     */
    public void setSitStand(String sitStand) {
        this.sitStand = sitStand;
    }

    /**
     * Returns the pwaeId value of the object. 
     * pre - the Object must have a pwaeId. 
     * 
     * @return - An Pwae value that represents the Object's pwaeId. 
     */
    public Pwae getPwaeId() {
        return pwaeId;
    }

    /**
     * Takes in a parameter and sets the pwaeId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the pwaeId value has been updated.
     * 
     * @param pwaeId - An Integer value that represents the Object's size that will replace the current value. 
     */
    public void setPwaeId(Pwae pwaeId) {
        this.pwaeId = pwaeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monitorId != null ? monitorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitor)) {
            return false;
        }
        Monitor other = (Monitor) object;
        if ((this.monitorId == null && other.monitorId != null) || (this.monitorId != null && !this.monitorId.equals(other.monitorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Monitor[ monitorId=" + monitorId + " ]";
    }

}
