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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tetsu
 */
@Entity
@Table(name = "spm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spm.findAll", query = "SELECT s FROM Spm s"),
    @NamedQuery(name = "Spm.findBySpmId", query = "SELECT s FROM Spm s WHERE s.spmId = :spmId"),
    @NamedQuery(name = "Spm.findByBaseBeBool", query = "SELECT s FROM Spm s WHERE s.baseBeBool = :baseBeBool"),
    @NamedQuery(name = "Spm.findByBaseAfBool", query = "SELECT s FROM Spm s WHERE s.baseAfBool = :baseAfBool"),
    @NamedQuery(name = "Spm.findByShoulderBeBool", query = "SELECT s FROM Spm s WHERE s.shoulderBeBool = :shoulderBeBool"),
    @NamedQuery(name = "Spm.findByShoulderAfBool", query = "SELECT s FROM Spm s WHERE s.shoulderAfBool = :shoulderAfBool"),
    @NamedQuery(name = "Spm.findByArmBeBool", query = "SELECT s FROM Spm s WHERE s.armBeBool = :armBeBool"),
    @NamedQuery(name = "Spm.findByArmAfBool", query = "SELECT s FROM Spm s WHERE s.armAfBool = :armAfBool"),
    @NamedQuery(name = "Spm.findByBaseBeNotes", query = "SELECT s FROM Spm s WHERE s.baseBeNotes = :baseBeNotes"),
    @NamedQuery(name = "Spm.findByBaseAfNotes", query = "SELECT s FROM Spm s WHERE s.baseAfNotes = :baseAfNotes"),
    @NamedQuery(name = "Spm.findByShoulderBeNotes", query = "SELECT s FROM Spm s WHERE s.shoulderBeNotes = :shoulderBeNotes"),
    @NamedQuery(name = "Spm.findByShoulderAfNotes", query = "SELECT s FROM Spm s WHERE s.shoulderAfNotes = :shoulderAfNotes"),
    @NamedQuery(name = "Spm.findByArmBeNotes", query = "SELECT s FROM Spm s WHERE s.armBeNotes = :armBeNotes"),
    @NamedQuery(name = "Spm.findByArmAfNotes", query = "SELECT s FROM Spm s WHERE s.armAfNotes = :armAfNotes")})
public class Spm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "spmId")
    private Integer spmId;
    @Column(name = "baseBeBool")
    private Boolean baseBeBool;
    @Column(name = "baseAfBool")
    private Boolean baseAfBool;
    @Column(name = "shoulderBeBool")
    private Boolean shoulderBeBool;
    @Column(name = "shoulderAfBool")
    private Boolean shoulderAfBool;
    @Column(name = "armBeBool")
    private Boolean armBeBool;
    @Column(name = "armAfBool")
    private Boolean armAfBool;
    @Size(max = 250)
    @Column(name = "baseBeNotes")
    private String baseBeNotes;
    @Size(max = 250)
    @Column(name = "baseAfNotes")
    private String baseAfNotes;
    @Size(max = 250)
    @Column(name = "shoulderBeNotes")
    private String shoulderBeNotes;
    @Size(max = 250)
    @Column(name = "shoulderAfNotes")
    private String shoulderAfNotes;
    @Size(max = 250)
    @Column(name = "armBeNotes")
    private String armBeNotes;
    @Size(max = 250)
    @Column(name = "armAfNotes")
    private String armAfNotes;
    @OneToMany(mappedBy = "spmId")
    private List<Assessment> assessmentList;

    public Spm() {
    }

    public Spm(Integer spmId) {
        this.spmId = spmId;
    }

    public Integer getSpmId() {
        return spmId;
    }

    public void setSpmId(Integer spmId) {
        this.spmId = spmId;
    }

    public Boolean getBaseBeBool() {
        return baseBeBool;
    }

    public void setBaseBeBool(Boolean baseBeBool) {
        this.baseBeBool = baseBeBool;
    }

    public Boolean getBaseAfBool() {
        return baseAfBool;
    }

    public void setBaseAfBool(Boolean baseAfBool) {
        this.baseAfBool = baseAfBool;
    }

    public Boolean getShoulderBeBool() {
        return shoulderBeBool;
    }

    public void setShoulderBeBool(Boolean shoulderBeBool) {
        this.shoulderBeBool = shoulderBeBool;
    }

    public Boolean getShoulderAfBool() {
        return shoulderAfBool;
    }

    public void setShoulderAfBool(Boolean shoulderAfBool) {
        this.shoulderAfBool = shoulderAfBool;
    }

    public Boolean getArmBeBool() {
        return armBeBool;
    }

    public void setArmBeBool(Boolean armBeBool) {
        this.armBeBool = armBeBool;
    }

    public Boolean getArmAfBool() {
        return armAfBool;
    }

    public void setArmAfBool(Boolean armAfBool) {
        this.armAfBool = armAfBool;
    }

    public String getBaseBeNotes() {
        return baseBeNotes;
    }

    public void setBaseBeNotes(String baseBeNotes) {
        this.baseBeNotes = baseBeNotes;
    }

    public String getBaseAfNotes() {
        return baseAfNotes;
    }

    public void setBaseAfNotes(String baseAfNotes) {
        this.baseAfNotes = baseAfNotes;
    }

    public String getShoulderBeNotes() {
        return shoulderBeNotes;
    }

    public void setShoulderBeNotes(String shoulderBeNotes) {
        this.shoulderBeNotes = shoulderBeNotes;
    }

    public String getShoulderAfNotes() {
        return shoulderAfNotes;
    }

    public void setShoulderAfNotes(String shoulderAfNotes) {
        this.shoulderAfNotes = shoulderAfNotes;
    }

    public String getArmBeNotes() {
        return armBeNotes;
    }

    public void setArmBeNotes(String armBeNotes) {
        this.armBeNotes = armBeNotes;
    }

    public String getArmAfNotes() {
        return armAfNotes;
    }

    public void setArmAfNotes(String armAfNotes) {
        this.armAfNotes = armAfNotes;
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
        hash += (spmId != null ? spmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spm)) {
            return false;
        }
        Spm other = (Spm) object;
        if ((this.spmId == null && other.spmId != null) || (this.spmId != null && !this.spmId.equals(other.spmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Spm[ spmId=" + spmId + " ]";
    }
    
}
