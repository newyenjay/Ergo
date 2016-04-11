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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author tetsu
 */
@Entity
@Table(name = "pwae")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pwae.findAll", query = "SELECT p FROM Pwae p"),
    @NamedQuery(name = "Pwae.findByPwaeId", query = "SELECT p FROM Pwae p WHERE p.pwaeId = :pwaeId"),
    @NamedQuery(name = "Pwae.findByElbowCurr", query = "SELECT p FROM Pwae p WHERE p.elbowCurr = :elbowCurr"),
    @NamedQuery(name = "Pwae.findByElbowRec", query = "SELECT p FROM Pwae p WHERE p.elbowRec = :elbowRec"),
    @NamedQuery(name = "Pwae.findByElbowSit", query = "SELECT p FROM Pwae p WHERE p.elbowSit = :elbowSit"),
    @NamedQuery(name = "Pwae.findByEyeCurr", query = "SELECT p FROM Pwae p WHERE p.eyeCurr = :eyeCurr"),
    @NamedQuery(name = "Pwae.findByEyeRec", query = "SELECT p FROM Pwae p WHERE p.eyeRec = :eyeRec"),
    @NamedQuery(name = "Pwae.findByEyeSit", query = "SELECT p FROM Pwae p WHERE p.eyeSit = :eyeSit"),
    @NamedQuery(name = "Pwae.findByDeskCurr", query = "SELECT p FROM Pwae p WHERE p.deskCurr = :deskCurr"),
    @NamedQuery(name = "Pwae.findByDeskRec", query = "SELECT p FROM Pwae p WHERE p.deskRec = :deskRec"),
    @NamedQuery(name = "Pwae.findByDeskSit", query = "SELECT p FROM Pwae p WHERE p.deskSit = :deskSit"),
    @NamedQuery(name = "Pwae.findByChairNote", query = "SELECT p FROM Pwae p WHERE p.chairNote = :chairNote"),
    @NamedQuery(name = "Pwae.findByMonitorNote", query = "SELECT p FROM Pwae p WHERE p.monitorNote = :monitorNote"),
    @NamedQuery(name = "Pwae.findByInputNote", query = "SELECT p FROM Pwae p WHERE p.inputNote = :inputNote"),
    @NamedQuery(name = "Pwae.findByDeskNote", query = "SELECT p FROM Pwae p WHERE p.deskNote = :deskNote"),
    @NamedQuery(name = "Pwae.findByAccessoriesNote", query = "SELECT p FROM Pwae p WHERE p.accessoriesNote = :accessoriesNote"),
    @NamedQuery(name = "Pwae.findByKeyboardCurr", query = "SELECT p FROM Pwae p WHERE p.keyboardCurr = :keyboardCurr"),
    @NamedQuery(name = "Pwae.findByKeyboardRec", query = "SELECT p FROM Pwae p WHERE p.keyboardRec = :keyboardRec"),
    @NamedQuery(name = "Pwae.findByKeyboardSit", query = "SELECT p FROM Pwae p WHERE p.keyboardSit = :keyboardSit")})
public class Pwae implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pwaeId")
    private Integer pwaeId;
    @Size(max = 45)
    @Column(name = "elbowCurr")
    private String elbowCurr;
    @Size(max = 45)
    @Column(name = "elbowRec")
    private String elbowRec;
    @Size(max = 45)
    @Column(name = "elbowSit")
    private String elbowSit;
    @Size(max = 45)
    @Column(name = "eyeCurr")
    private String eyeCurr;
    @Size(max = 45)
    @Column(name = "eyeRec")
    private String eyeRec;
    @Size(max = 45)
    @Column(name = "eyeSit")
    private String eyeSit;
    @Size(max = 45)
    @Column(name = "deskCurr")
    private String deskCurr;
    @Size(max = 45)
    @Column(name = "deskRec")
    private String deskRec;
    @Size(max = 45)
    @Column(name = "deskSit")
    private String deskSit;
    @Size(max = 45)
    @Column(name = "chairNote")
    private String chairNote;
    @Size(max = 45)
    @Column(name = "monitorNote")
    private String monitorNote;
    @Size(max = 45)
    @Column(name = "inputNote")
    private String inputNote;
    @Size(max = 45)
    @Column(name = "deskNote")
    private String deskNote;
    @Size(max = 45)
    @Column(name = "accessoriesNote")
    private String accessoriesNote;
    @Size(max = 45)
    @Column(name = "keyboardCurr")
    private String keyboardCurr;
    @Size(max = 45)
    @Column(name = "keyboardRec")
    private String keyboardRec;
    @Size(max = 45)
    @Column(name = "keyboardSit")
    private String keyboardSit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaeIdsite")
    private List<Siterec> siterecList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaeId")
    private List<Monitor> monitorList;
    @OneToMany(mappedBy = "pwaId")
    private List<Assessment> assessmentList;

    public Pwae() {
    }

    public Pwae(Integer pwaeId) {
        this.pwaeId = pwaeId;
    }

    public Integer getPwaeId() {
        return pwaeId;
    }

    public void setPwaeId(Integer pwaeId) {
        this.pwaeId = pwaeId;
    }

    public String getElbowCurr() {
        return elbowCurr;
    }

    public void setElbowCurr(String elbowCurr) {
        this.elbowCurr = elbowCurr;
    }

    public String getElbowRec() {
        return elbowRec;
    }

    public void setElbowRec(String elbowRec) {
        this.elbowRec = elbowRec;
    }

    public String getElbowSit() {
        return elbowSit;
    }

    public void setElbowSit(String elbowSit) {
        this.elbowSit = elbowSit;
    }

    public String getEyeCurr() {
        return eyeCurr;
    }

    public void setEyeCurr(String eyeCurr) {
        this.eyeCurr = eyeCurr;
    }

    public String getEyeRec() {
        return eyeRec;
    }

    public void setEyeRec(String eyeRec) {
        this.eyeRec = eyeRec;
    }

    public String getEyeSit() {
        return eyeSit;
    }

    public void setEyeSit(String eyeSit) {
        this.eyeSit = eyeSit;
    }

    public String getDeskCurr() {
        return deskCurr;
    }

    public void setDeskCurr(String deskCurr) {
        this.deskCurr = deskCurr;
    }

    public String getDeskRec() {
        return deskRec;
    }

    public void setDeskRec(String deskRec) {
        this.deskRec = deskRec;
    }

    public String getDeskSit() {
        return deskSit;
    }

    public void setDeskSit(String deskSit) {
        this.deskSit = deskSit;
    }

    public String getChairNote() {
        return chairNote;
    }

    public void setChairNote(String chairNote) {
        this.chairNote = chairNote;
    }

    public String getMonitorNote() {
        return monitorNote;
    }

    public void setMonitorNote(String monitorNote) {
        this.monitorNote = monitorNote;
    }

    public String getInputNote() {
        return inputNote;
    }

    public void setInputNote(String inputNote) {
        this.inputNote = inputNote;
    }

    public String getDeskNote() {
        return deskNote;
    }

    public void setDeskNote(String deskNote) {
        this.deskNote = deskNote;
    }

    public String getAccessoriesNote() {
        return accessoriesNote;
    }

    public void setAccessoriesNote(String accessoriesNote) {
        this.accessoriesNote = accessoriesNote;
    }

    public String getKeyboardCurr() {
        return keyboardCurr;
    }

    public void setKeyboardCurr(String keyboardCurr) {
        this.keyboardCurr = keyboardCurr;
    }

    public String getKeyboardRec() {
        return keyboardRec;
    }

    public void setKeyboardRec(String keyboardRec) {
        this.keyboardRec = keyboardRec;
    }

    public String getKeyboardSit() {
        return keyboardSit;
    }

    public void setKeyboardSit(String keyboardSit) {
        this.keyboardSit = keyboardSit;
    }

    @XmlTransient
    public List<Siterec> getSiterecList() {
        return siterecList;
    }

    public void setSiterecList(List<Siterec> siterecList) {
        this.siterecList = siterecList;
    }

    @XmlTransient
    public List<Monitor> getMonitorList() {
        return monitorList;
    }

    public void setMonitorList(List<Monitor> monitorList) {
        this.monitorList = monitorList;
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
        hash += (pwaeId != null ? pwaeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pwae)) {
            return false;
        }
        Pwae other = (Pwae) object;
        if ((this.pwaeId == null && other.pwaeId != null) || (this.pwaeId != null && !this.pwaeId.equals(other.pwaeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Pwae[ pwaeId=" + pwaeId + " ]";
    }
    
}
