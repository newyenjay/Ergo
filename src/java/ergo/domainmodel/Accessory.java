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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 671402
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
    @ManyToMany(mappedBy = "accessoryList")
    private List<Assessment> assessmentList;

    public Accessory() {
    }

    public Accessory(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    public Integer getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(Integer accessoryId) {
        this.accessoryId = accessoryId;
    }

    @XmlTransient
    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
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
