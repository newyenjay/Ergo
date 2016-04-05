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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 671402
 */
@Entity
@Table(name = "discomfort")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discomfort.findAll", query = "SELECT d FROM Discomfort d"),
    @NamedQuery(name = "Discomfort.findByDiscomfortId", query = "SELECT d FROM Discomfort d WHERE d.discomfortId = :discomfortId"),
    @NamedQuery(name = "Discomfort.findByNotes", query = "SELECT d FROM Discomfort d WHERE d.notes = :notes")})
public class Discomfort implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discomfortId")
    private Integer discomfortId;
    @Size(max = 300)
    @Column(name = "notes")
    private String notes;

    public Discomfort() {
    }

    public Discomfort(Integer discomfortId) {
        this.discomfortId = discomfortId;
    }

    public Integer getDiscomfortId() {
        return discomfortId;
    }

    public void setDiscomfortId(Integer discomfortId) {
        this.discomfortId = discomfortId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discomfortId != null ? discomfortId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discomfort)) {
            return false;
        }
        Discomfort other = (Discomfort) object;
        if ((this.discomfortId == null && other.discomfortId != null) || (this.discomfortId != null && !this.discomfortId.equals(other.discomfortId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Discomfort[ discomfortId=" + discomfortId + " ]";
    }
    
}
