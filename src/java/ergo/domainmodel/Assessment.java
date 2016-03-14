/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kimberly Oshiro
 */
@Entity
@Table(name = "assessment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assessment.findAll", query = "SELECT a FROM Assessment a"),
    @NamedQuery(name = "Assessment.findByAssessmentId", query = "SELECT a FROM Assessment a WHERE a.assessmentId = :assessmentId"),
    @NamedQuery(name = "Assessment.findByAssessor", query = "SELECT a FROM Assessment a WHERE a.assessor = :assessor"),
    @NamedQuery(name = "Assessment.findByDate", query = "SELECT a FROM Assessment a WHERE a.date = :date"),
    @NamedQuery(name = "Assessment.findByWorkerComments", query = "SELECT a FROM Assessment a WHERE a.workerComments = :workerComments"),
    @NamedQuery(name = "Assessment.findByRisks", query = "SELECT a FROM Assessment a WHERE a.risks = :risks"),
    @NamedQuery(name = "Assessment.findByRecommendations", query = "SELECT a FROM Assessment a WHERE a.recommendations = :recommendations"),
    @NamedQuery(name = "Assessment.findByBoolFollowUp", query = "SELECT a FROM Assessment a WHERE a.boolFollowUp = :boolFollowUp"),
    @NamedQuery(name = "Assessment.findByBoolStretchBreak", query = "SELECT a FROM Assessment a WHERE a.boolStretchBreak = :boolStretchBreak"),
    @NamedQuery(name = "Assessment.findByBoolMicro", query = "SELECT a FROM Assessment a WHERE a.boolMicro = :boolMicro"),
    @NamedQuery(name = "Assessment.findByBoolSitStand", query = "SELECT a FROM Assessment a WHERE a.boolSitStand = :boolSitStand"),
    @NamedQuery(name = "Assessment.findByPrepNotes", query = "SELECT a FROM Assessment a WHERE a.prepNotes = :prepNotes"),
    @NamedQuery(name = "Assessment.findByBoolStableBase", query = "SELECT a FROM Assessment a WHERE a.boolStableBase = :boolStableBase"),
    @NamedQuery(name = "Assessment.findByStableBaseNotes", query = "SELECT a FROM Assessment a WHERE a.stableBaseNotes = :stableBaseNotes"),
    @NamedQuery(name = "Assessment.findByBoolShoulderPos", query = "SELECT a FROM Assessment a WHERE a.boolShoulderPos = :boolShoulderPos"),
    @NamedQuery(name = "Assessment.findByShoulderPosNotes", query = "SELECT a FROM Assessment a WHERE a.shoulderPosNotes = :shoulderPosNotes"),
    @NamedQuery(name = "Assessment.findByBoolArmPos", query = "SELECT a FROM Assessment a WHERE a.boolArmPos = :boolArmPos"),
    @NamedQuery(name = "Assessment.findByArmPosNotes", query = "SELECT a FROM Assessment a WHERE a.armPosNotes = :armPosNotes"),
    @NamedQuery(name = "Assessment.findByGeneralNotes", query = "SELECT a FROM Assessment a WHERE a.generalNotes = :generalNotes"),
    @NamedQuery(name = "Assessment.findByBoolChair", query = "SELECT a FROM Assessment a WHERE a.boolChair = :boolChair"),
    @NamedQuery(name = "Assessment.findByChairNotes", query = "SELECT a FROM Assessment a WHERE a.chairNotes = :chairNotes"),
    @NamedQuery(name = "Assessment.findByBoolMonitor", query = "SELECT a FROM Assessment a WHERE a.boolMonitor = :boolMonitor"),
    @NamedQuery(name = "Assessment.findByMonitorNotes", query = "SELECT a FROM Assessment a WHERE a.monitorNotes = :monitorNotes"),
    @NamedQuery(name = "Assessment.findByBoolDevices", query = "SELECT a FROM Assessment a WHERE a.boolDevices = :boolDevices"),
    @NamedQuery(name = "Assessment.findByDevicesNotes", query = "SELECT a FROM Assessment a WHERE a.devicesNotes = :devicesNotes"),
    @NamedQuery(name = "Assessment.findByBoolDesk", query = "SELECT a FROM Assessment a WHERE a.boolDesk = :boolDesk"),
    @NamedQuery(name = "Assessment.findByDeskNotes", query = "SELECT a FROM Assessment a WHERE a.deskNotes = :deskNotes"),
    @NamedQuery(name = "Assessment.findByBoolAccessories", query = "SELECT a FROM Assessment a WHERE a.boolAccessories = :boolAccessories"),
    @NamedQuery(name = "Assessment.findByAccessoriesNotes", query = "SELECT a FROM Assessment a WHERE a.accessoriesNotes = :accessoriesNotes"),
    @NamedQuery(name = "Assessment.findByConfidentialNotes", query = "SELECT a FROM Assessment a WHERE a.confidentialNotes = :confidentialNotes")})
public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assessmentId")
    private Integer assessmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "assessor")
    private String assessor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 300)
    @Column(name = "workerComments")
    private String workerComments;
    @Size(max = 300)
    @Column(name = "risks")
    private String risks;
    @Size(max = 300)
    @Column(name = "recommendations")
    private String recommendations;
    @Column(name = "boolFollowUp")
    private Integer boolFollowUp;
    @Column(name = "boolStretchBreak")
    private Integer boolStretchBreak;
    @Column(name = "boolMicro")
    private Integer boolMicro;
    @Column(name = "boolSitStand")
    private Integer boolSitStand;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "prepNotes")
    private String prepNotes;
    @Column(name = "boolStableBase")
    private Integer boolStableBase;
    @Size(max = 300)
    @Column(name = "stableBaseNotes")
    private String stableBaseNotes;
    @Column(name = "boolShoulderPos")
    private Integer boolShoulderPos;
    @Size(max = 300)
    @Column(name = "shoulderPosNotes")
    private String shoulderPosNotes;
    @Column(name = "boolArmPos")
    private Integer boolArmPos;
    @Size(max = 300)
    @Column(name = "armPosNotes")
    private String armPosNotes;
    @Size(max = 300)
    @Column(name = "generalNotes")
    private String generalNotes;
    @Column(name = "boolChair")
    private Integer boolChair;
    @Size(max = 300)
    @Column(name = "chairNotes")
    private String chairNotes;
    @Column(name = "boolMonitor")
    private Integer boolMonitor;
    @Size(max = 300)
    @Column(name = "monitorNotes")
    private String monitorNotes;
    @Column(name = "boolDevices")
    private Integer boolDevices;
    @Size(max = 300)
    @Column(name = "devicesNotes")
    private String devicesNotes;
    @Column(name = "boolDesk")
    private Integer boolDesk;
    @Size(max = 300)
    @Column(name = "deskNotes")
    private String deskNotes;
    @Column(name = "boolAccessories")
    private Integer boolAccessories;
    @Size(max = 300)
    @Column(name = "accessoriesNotes")
    private String accessoriesNotes;
    @Size(max = 300)
    @Column(name = "confidentialNotes")
    private String confidentialNotes;
    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
    @ManyToOne
    private Client clientId;
    @OneToMany(mappedBy = "assessmentId")
    private List<Monitor> monitorList;

    public Assessment() {
    }

    public Assessment(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Assessment(Integer assessmentId, String assessor, Date date, String prepNotes) {
        this.assessmentId = assessmentId;
        this.assessor = assessor;
        this.date = date;
        this.prepNotes = prepNotes;
    }

    public Integer getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getAssessor() {
        return assessor;
    }

    public void setAssessor(String assessor) {
        this.assessor = assessor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWorkerComments() {
        return workerComments;
    }

    public void setWorkerComments(String workerComments) {
        this.workerComments = workerComments;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public Integer getBoolFollowUp() {
        return boolFollowUp;
    }

    public void setBoolFollowUp(Integer boolFollowUp) {
        this.boolFollowUp = boolFollowUp;
    }

    public Integer getBoolStretchBreak() {
        return boolStretchBreak;
    }

    public void setBoolStretchBreak(Integer boolStretchBreak) {
        this.boolStretchBreak = boolStretchBreak;
    }

    public Integer getBoolMicro() {
        return boolMicro;
    }

    public void setBoolMicro(Integer boolMicro) {
        this.boolMicro = boolMicro;
    }

    public Integer getBoolSitStand() {
        return boolSitStand;
    }

    public void setBoolSitStand(Integer boolSitStand) {
        this.boolSitStand = boolSitStand;
    }

    public String getPrepNotes() {
        return prepNotes;
    }

    public void setPrepNotes(String prepNotes) {
        this.prepNotes = prepNotes;
    }

    public Integer getBoolStableBase() {
        return boolStableBase;
    }

    public void setBoolStableBase(Integer boolStableBase) {
        this.boolStableBase = boolStableBase;
    }

    public String getStableBaseNotes() {
        return stableBaseNotes;
    }

    public void setStableBaseNotes(String stableBaseNotes) {
        this.stableBaseNotes = stableBaseNotes;
    }

    public Integer getBoolShoulderPos() {
        return boolShoulderPos;
    }

    public void setBoolShoulderPos(Integer boolShoulderPos) {
        this.boolShoulderPos = boolShoulderPos;
    }

    public String getShoulderPosNotes() {
        return shoulderPosNotes;
    }

    public void setShoulderPosNotes(String shoulderPosNotes) {
        this.shoulderPosNotes = shoulderPosNotes;
    }

    public Integer getBoolArmPos() {
        return boolArmPos;
    }

    public void setBoolArmPos(Integer boolArmPos) {
        this.boolArmPos = boolArmPos;
    }

    public String getArmPosNotes() {
        return armPosNotes;
    }

    public void setArmPosNotes(String armPosNotes) {
        this.armPosNotes = armPosNotes;
    }

    public String getGeneralNotes() {
        return generalNotes;
    }

    public void setGeneralNotes(String generalNotes) {
        this.generalNotes = generalNotes;
    }

    public Integer getBoolChair() {
        return boolChair;
    }

    public void setBoolChair(Integer boolChair) {
        this.boolChair = boolChair;
    }

    public String getChairNotes() {
        return chairNotes;
    }

    public void setChairNotes(String chairNotes) {
        this.chairNotes = chairNotes;
    }

    public Integer getBoolMonitor() {
        return boolMonitor;
    }

    public void setBoolMonitor(Integer boolMonitor) {
        this.boolMonitor = boolMonitor;
    }

    public String getMonitorNotes() {
        return monitorNotes;
    }

    public void setMonitorNotes(String monitorNotes) {
        this.monitorNotes = monitorNotes;
    }

    public Integer getBoolDevices() {
        return boolDevices;
    }

    public void setBoolDevices(Integer boolDevices) {
        this.boolDevices = boolDevices;
    }

    public String getDevicesNotes() {
        return devicesNotes;
    }

    public void setDevicesNotes(String devicesNotes) {
        this.devicesNotes = devicesNotes;
    }

    public Integer getBoolDesk() {
        return boolDesk;
    }

    public void setBoolDesk(Integer boolDesk) {
        this.boolDesk = boolDesk;
    }

    public String getDeskNotes() {
        return deskNotes;
    }

    public void setDeskNotes(String deskNotes) {
        this.deskNotes = deskNotes;
    }

    public Integer getBoolAccessories() {
        return boolAccessories;
    }

    public void setBoolAccessories(Integer boolAccessories) {
        this.boolAccessories = boolAccessories;
    }

    public String getAccessoriesNotes() {
        return accessoriesNotes;
    }

    public void setAccessoriesNotes(String accessoriesNotes) {
        this.accessoriesNotes = accessoriesNotes;
    }

    public String getConfidentialNotes() {
        return confidentialNotes;
    }

    public void setConfidentialNotes(String confidentialNotes) {
        this.confidentialNotes = confidentialNotes;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    @XmlTransient
    public List<Monitor> getMonitorList() {
        return monitorList;
    }

    public void setMonitorList(List<Monitor> monitorList) {
        this.monitorList = monitorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (assessmentId != null ? assessmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assessment)) {
            return false;
        }
        Assessment other = (Assessment) object;
        if ((this.assessmentId == null && other.assessmentId != null) || (this.assessmentId != null && !this.assessmentId.equals(other.assessmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Assessment[ assessmentId=" + assessmentId + " ]";
    }
    
}
