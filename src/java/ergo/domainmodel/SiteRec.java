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
    @NamedQuery(name = "SiteRec.findByCompleteDate", query = "SELECT s FROM SiteRec s WHERE s.completeDate = :completeDate")})
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

    public SiteRec() {
    }

    public SiteRec(Integer siteRecId) {
        this.siteRecId = siteRecId;
    }

    public Integer getSiteRecId() {
        return siteRecId;
    }

    public void setSiteRecId(Integer siteRecId) {
        this.siteRecId = siteRecId;
    }

    public String getRecommand() {
        return recommand;
    }

    public void setRecommand(String recommand) {
        this.recommand = recommand;
    }

    public String getAccessoryType() {
        return accessoryType;
    }

    public void setAccessoryType(String accessoryType) {
        this.accessoryType = accessoryType;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public Pwae getPwaeIdsite() {
        return pwaeIdsite;
    }

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
