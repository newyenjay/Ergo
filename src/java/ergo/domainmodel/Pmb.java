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
@Table(name = "pmb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pmb.findAll", query = "SELECT p FROM Pmb p"),
    @NamedQuery(name = "Pmb.findByPmbId", query = "SELECT p FROM Pmb p WHERE p.pmbId = :pmbId"),
    @NamedQuery(name = "Pmb.findByGoalMetBool", query = "SELECT p FROM Pmb p WHERE p.goalMetBool = :goalMetBool"),
    @NamedQuery(name = "Pmb.findByGoalMetNotes", query = "SELECT p FROM Pmb p WHERE p.goalMetNotes = :goalMetNotes"),
    @NamedQuery(name = "Pmb.findByEducBool", query = "SELECT p FROM Pmb p WHERE p.educBool = :educBool"),
    @NamedQuery(name = "Pmb.findByEducNotes", query = "SELECT p FROM Pmb p WHERE p.educNotes = :educNotes"),
    @NamedQuery(name = "Pmb.findByMicroBeBool", query = "SELECT p FROM Pmb p WHERE p.microBeBool = :microBeBool"),
    @NamedQuery(name = "Pmb.findByMicroBeNotes", query = "SELECT p FROM Pmb p WHERE p.microBeNotes = :microBeNotes"),
    @NamedQuery(name = "Pmb.findByMicroAfBool", query = "SELECT p FROM Pmb p WHERE p.microAfBool = :microAfBool"),
    @NamedQuery(name = "Pmb.findByMicroAfNotes", query = "SELECT p FROM Pmb p WHERE p.microAfNotes = :microAfNotes")})
public class Pmb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pmbId")
    private Integer pmbId;
    @Column(name = "goalMetBool")
    private Boolean goalMetBool;
    @Size(max = 250)
    @Column(name = "goalMetNotes")
    private String goalMetNotes;
    @Column(name = "educBool")
    private Boolean educBool;
    @Size(max = 250)
    @Column(name = "educNotes")
    private String educNotes;
    @Column(name = "microBeBool")
    private Boolean microBeBool;
    @Size(max = 250)
    @Column(name = "microBeNotes")
    private String microBeNotes;
    @Column(name = "microAfBool")
    private Boolean microAfBool;
    @Size(max = 250)
    @Column(name = "microAfNotes")
    private String microAfNotes;

    public Pmb() {
    }

    public Pmb(Integer pmbId) {
        this.pmbId = pmbId;
    }

    public Integer getPmbId() {
        return pmbId;
    }

    public void setPmbId(Integer pmbId) {
        this.pmbId = pmbId;
    }

    public Boolean getGoalMetBool() {
        return goalMetBool;
    }

    public void setGoalMetBool(Boolean goalMetBool) {
        this.goalMetBool = goalMetBool;
    }

    public String getGoalMetNotes() {
        return goalMetNotes;
    }

    public void setGoalMetNotes(String goalMetNotes) {
        this.goalMetNotes = goalMetNotes;
    }

    public Boolean getEducBool() {
        return educBool;
    }

    public void setEducBool(Boolean educBool) {
        this.educBool = educBool;
    }

    public String getEducNotes() {
        return educNotes;
    }

    public void setEducNotes(String educNotes) {
        this.educNotes = educNotes;
    }

    public Boolean getMicroBeBool() {
        return microBeBool;
    }

    public void setMicroBeBool(Boolean microBeBool) {
        this.microBeBool = microBeBool;
    }

    public String getMicroBeNotes() {
        return microBeNotes;
    }

    public void setMicroBeNotes(String microBeNotes) {
        this.microBeNotes = microBeNotes;
    }

    public Boolean getMicroAfBool() {
        return microAfBool;
    }

    public void setMicroAfBool(Boolean microAfBool) {
        this.microAfBool = microAfBool;
    }

    public String getMicroAfNotes() {
        return microAfNotes;
    }

    public void setMicroAfNotes(String microAfNotes) {
        this.microAfNotes = microAfNotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pmbId != null ? pmbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pmb)) {
            return false;
        }
        Pmb other = (Pmb) object;
        if ((this.pmbId == null && other.pmbId != null) || (this.pmbId != null && !this.pmbId.equals(other.pmbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Pmb[ pmbId=" + pmbId + " ]";
    }
    
}
