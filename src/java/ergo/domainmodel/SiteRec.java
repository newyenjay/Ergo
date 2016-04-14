/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author waynelin
 */
@Entity
@Table(name = "siteRec")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteRec.findAll", query = "SELECT s FROM SiteRec s"),
    @NamedQuery(name = "SiteRec.findBySiteRecId", query = "SELECT s FROM SiteRec s WHERE s.siteRecId = :siteRecId"),
    @NamedQuery(name = "SiteRec.findByRecommand", query = "SELECT s FROM SiteRec s WHERE s.recommand = :recommand"),
    @NamedQuery(name = "SiteRec.findByAccessoryType", query = "SELECT s FROM SiteRec s WHERE s.accessoryType = :accessoryType"),
    @NamedQuery(name = "SiteRec.findByCompleteDate", query = "SELECT s FROM SiteRec s WHERE s.completeDate = :completeDate"),
    @NamedQuery(name = "SiteRec.findByPwaeId", query = "SELECT s FROM SiteRec s WHERE s.siteRecId = :siteRecId")})

public class SiteRec implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "siteRecId")
    private Integer siteRecId;
    @Size(max = 45)
    @Column(name = "recommand")
    private String recommand;
    @Size(max = 45)
    @Column(name = "accessoryType")
    private String accessoryType;
    @Column(name = "completeDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completeDate;
    @JoinColumn(name = "pwaeId_site", referencedColumnName = "pwaeId")
    @ManyToOne(optional = false)
    private Pwae pwaeIdsite;

    /**
     * The default constructor with no parameters. Will create a SiteRec object with no variables. 
     */
    public SiteRec() {
    }

    /**
     * SiteRec Object constructor. takes in the siteRecId as a parameter during object construction and sets it as an object variable. 
     * @param siteRecId 
     */
    public SiteRec(Integer siteRecId) {
        this.siteRecId = siteRecId;
    }

    /**
     * Returns the siteRecId value of the object. 
     * pre - the Object must have a locationId. 
     * 
     * @return - An Integer value that represents the Object's siteRecId. 
     */
    public Integer getSiteRecId() {
        return siteRecId;
    }

    /**
     * Takes in a parameter and sets the siteRecId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the siteRecId value has been updated.
     * 
     * @param siteRecId - An Integer value that represents the Object's siteRecId that will replace the current value. 
     */
    public void setSiteRecId(Integer siteRecId) {
        this.siteRecId = siteRecId;
    }

    /**
     * Returns the siteRecId value of the object. 
     * pre - the Object must have a recommand. 
     * 
     * @return - An Integer value that represents the Object's recommand. 
     */
    public String getRecommand() {
        return recommand;
    }

    /**
     * Takes in a parameter and sets the recommand object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the recommand value has been updated.
     * 
     * @param recommand - A String value that represents the Object's recommand that will replace the current value. 
     */
    public void setRecommand(String recommand) {
        this.recommand = recommand;
    }

    /**
     * Returns the siteRecId value of the object. 
     * pre - the Object must have a accessoryType. 
     * 
     * @return - A String value that represents the Object's accessoryType. 
     */
    public String getAccessoryType() {
        return accessoryType;
    }

    /**
     * Takes in a parameter and sets the accessoryType object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the accessoryType value has been updated.
     * 
     * @param accessoryType - A String value that represents the Object's accessoryType that will replace the current value. 
     */
    public void setAccessoryType(String accessoryType) {
        this.accessoryType = accessoryType;
    }

    /**
     * Returns the completeDate value of the object. 
     * pre - the Object must have a completeDate. 
     * 
     * @return - A Date value that represents the Object's completeDate. 
     */
    public Date getCompleteDate() {
        return completeDate;
    }

    /**
     * Takes in a parameter and sets the completeDate object variable to that parameters. 
     * Pre - the Parameter must be a Date.
     * post - the completeDate value has been updated.
     * 
     * @param completeDate - A Date value that represents the Object's completeDate that will replace the current value. 
     */
    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    /**
     * Returns the pwaeIdsite value of the object. 
     * pre - the Object must have a pwaeIdsite. 
     * 
     * @return - A Pwae Object value that represents the Object's pwaeIdsite. 
     */
    public Pwae getPwaeIdsite() {
        return pwaeIdsite;
    }

    /**
     * Takes in a parameter and sets the pwaeIdsite object variable to that parameters. 
     * Pre - the Parameter must be a Pwae Object.
     * post - the pwaeIdsite value has been updated.
     * 
     * @param pwaeIdsite - A Pwae Object value that represents the Object's pwaeIdsite that will replace the current value. 
     */
    public void setPwaeIdsite(Pwae pwaeIdsite) {
        this.pwaeIdsite = pwaeIdsite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (siteRecId != null ? siteRecId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteRec)) {
            return false;
        }
        SiteRec other = (SiteRec) object;
        if ((this.siteRecId == null && other.siteRecId != null) || (this.siteRecId != null && !this.siteRecId.equals(other.siteRecId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.SiteRec[ siteRecId=" + siteRecId + " ]";
    }

}
