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
 * @author waynelin
 */
@Entity
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByAdminId", query = "SELECT a FROM Admin a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "Admin.findByProactive", query = "SELECT a FROM Admin a WHERE a.proactive = :proactive"),
    @NamedQuery(name = "Admin.findByReactive", query = "SELECT a FROM Admin a WHERE a.reactive = :reactive"),
    @NamedQuery(name = "Admin.findByAssessor", query = "SELECT a FROM Admin a WHERE a.assessor = :assessor"),
    @NamedQuery(name = "Admin.findByManager", query = "SELECT a FROM Admin a WHERE a.manager = :manager"),
    @NamedQuery(name = "Admin.findByBusinessUnit", query = "SELECT a FROM Admin a WHERE a.businessUnit = :businessUnit"),
    @NamedQuery(name = "Admin.findByWorkspace", query = "SELECT a FROM Admin a WHERE a.workspace = :workspace"),
    @NamedQuery(name = "Admin.findByJobTitle", query = "SELECT a FROM Admin a WHERE a.jobTitle = :jobTitle"),
    @NamedQuery(name = "Admin.findByGender", query = "SELECT a FROM Admin a WHERE a.gender = :gender"),
    @NamedQuery(name = "Admin.findByHeightInFeet", query = "SELECT a FROM Admin a WHERE a.heightInFeet = :heightInFeet"),
    @NamedQuery(name = "Admin.findByHeightInInches", query = "SELECT a FROM Admin a WHERE a.heightInInches = :heightInInches"),
    @NamedQuery(name = "Admin.findByHandedness", query = "SELECT a FROM Admin a WHERE a.handedness = :handedness"),
    @NamedQuery(name = "Admin.findByDaysPerWeek", query = "SELECT a FROM Admin a WHERE a.daysPerWeek = :daysPerWeek"),
    @NamedQuery(name = "Admin.findByHoursPerDay", query = "SELECT a FROM Admin a WHERE a.hoursPerDay = :hoursPerDay"),
    @NamedQuery(name = "Admin.findByHoursVDT", query = "SELECT a FROM Admin a WHERE a.hoursVDT = :hoursVDT"),
    @NamedQuery(name = "Admin.findByHoursOnPhone", query = "SELECT a FROM Admin a WHERE a.hoursOnPhone = :hoursOnPhone"),
    @NamedQuery(name = "Admin.findByDiscomfortPresent", query = "SELECT a FROM Admin a WHERE a.discomfortPresent = :discomfortPresent"),
    @NamedQuery(name = "Admin.findByDiscomfortReported", query = "SELECT a FROM Admin a WHERE a.discomfortReported = :discomfortReported"),
    @NamedQuery(name = "Admin.findByTreatmentSought", query = "SELECT a FROM Admin a WHERE a.treatmentSought = :treatmentSought"),
    @NamedQuery(name = "Admin.findByMaxDiscomfort", query = "SELECT a FROM Admin a WHERE a.maxDiscomfort = :maxDiscomfort"),
    @NamedQuery(name = "Admin.findByWorkFit", query = "SELECT a FROM Admin a WHERE a.workFit = :workFit"),
    @NamedQuery(name = "Admin.findByRisks", query = "SELECT a FROM Admin a WHERE a.risks = :risks"),
    @NamedQuery(name = "Admin.findByEquipmentRecommendations", query = "SELECT a FROM Admin a WHERE a.equipmentRecommendations = :equipmentRecommendations"),
    @NamedQuery(name = "Admin.findByGeneralNotes", query = "SELECT a FROM Admin a WHERE a.generalNotes = :generalNotes"),
    @NamedQuery(name = "Admin.findByScore", query = "SELECT a FROM Admin a WHERE a.score = :score"),
    @NamedQuery(name = "Admin.findByFollowUpNeeded", query = "SELECT a FROM Admin a WHERE a.followUpNeeded = :followUpNeeded")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "adminId")
    private Integer adminId;
    @Size(max = 20)
    @Column(name = "proactive")
    private String proactive;
    @Size(max = 20)
    @Column(name = "reactive")
    private String reactive;
    @Size(max = 20)
    @Column(name = "assessor")
    private String assessor;
    @Size(max = 20)
    @Column(name = "manager")
    private String manager;
    @Size(max = 20)
    @Column(name = "businessUnit")
    private String businessUnit;
    @Size(max = 20)
    @Column(name = "workspace")
    private String workspace;
    @Size(max = 20)
    @Column(name = "jobTitle")
    private String jobTitle;
    @Size(max = 6)
    @Column(name = "gender")
    private String gender;
    @Column(name = "heightInFeet")
    private Integer heightInFeet;
    @Column(name = "heightInInches")
    private Integer heightInInches;
    @Size(max = 5)
    @Column(name = "handedness")
    private String handedness;
    @Column(name = "daysPerWeek")
    private Integer daysPerWeek;
    @Column(name = "hoursPerDay")
    private Integer hoursPerDay;
    @Column(name = "hoursVDT")
    private Integer hoursVDT;
    @Column(name = "hoursOnPhone")
    private Integer hoursOnPhone;
    @Size(max = 20)
    @Column(name = "discomfortPresent")
    private String discomfortPresent;
    @Size(max = 20)
    @Column(name = "discomfortReported")
    private String discomfortReported;
    @Size(max = 20)
    @Column(name = "treatmentSought")
    private String treatmentSought;
    @Column(name = "maxDiscomfort")
    private Integer maxDiscomfort;
    @Column(name = "workFit")
    private Integer workFit;
    @Size(max = 200)
    @Column(name = "risks")
    private String risks;
    @Size(max = 200)
    @Column(name = "equipmentRecommendations")
    private String equipmentRecommendations;
    @Size(max = 300)
    @Column(name = "generalNotes")
    private String generalNotes;
    @Column(name = "score")
    private Integer score;
    @Size(max = 50)
    @Column(name = "followUpNeeded")
    private String followUpNeeded;
    @OneToMany(mappedBy = "adminId")
    private List<Assessment> assessmentList;

    public Admin() {
    }

    public Admin(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getProactive() {
        return proactive;
    }

    public void setProactive(String proactive) {
        this.proactive = proactive;
    }

    public String getReactive() {
        return reactive;
    }

    public void setReactive(String reactive) {
        this.reactive = reactive;
    }

    public String getAssessor() {
        return assessor;
    }

    public void setAssessor(String assessor) {
        this.assessor = assessor;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getHeightInFeet() {
        return heightInFeet;
    }

    public void setHeightInFeet(Integer heightInFeet) {
        this.heightInFeet = heightInFeet;
    }

    public Integer getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(Integer heightInInches) {
        this.heightInInches = heightInInches;
    }

    public String getHandedness() {
        return handedness;
    }

    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    public Integer getDaysPerWeek() {
        return daysPerWeek;
    }

    public void setDaysPerWeek(Integer daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }

    public Integer getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(Integer hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    public Integer getHoursVDT() {
        return hoursVDT;
    }

    public void setHoursVDT(Integer hoursVDT) {
        this.hoursVDT = hoursVDT;
    }

    public Integer getHoursOnPhone() {
        return hoursOnPhone;
    }

    public void setHoursOnPhone(Integer hoursOnPhone) {
        this.hoursOnPhone = hoursOnPhone;
    }

    public String getDiscomfortPresent() {
        return discomfortPresent;
    }

    public void setDiscomfortPresent(String discomfortPresent) {
        this.discomfortPresent = discomfortPresent;
    }

    public String getDiscomfortReported() {
        return discomfortReported;
    }

    public void setDiscomfortReported(String discomfortReported) {
        this.discomfortReported = discomfortReported;
    }

    public String getTreatmentSought() {
        return treatmentSought;
    }

    public void setTreatmentSought(String treatmentSought) {
        this.treatmentSought = treatmentSought;
    }

    public Integer getMaxDiscomfort() {
        return maxDiscomfort;
    }

    public void setMaxDiscomfort(Integer maxDiscomfort) {
        this.maxDiscomfort = maxDiscomfort;
    }

    public Integer getWorkFit() {
        return workFit;
    }

    public void setWorkFit(Integer workFit) {
        this.workFit = workFit;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

    public String getEquipmentRecommendations() {
        return equipmentRecommendations;
    }

    public void setEquipmentRecommendations(String equipmentRecommendations) {
        this.equipmentRecommendations = equipmentRecommendations;
    }

    public String getGeneralNotes() {
        return generalNotes;
    }

    public void setGeneralNotes(String generalNotes) {
        this.generalNotes = generalNotes;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getFollowUpNeeded() {
        return followUpNeeded;
    }

    public void setFollowUpNeeded(String followUpNeeded) {
        this.followUpNeeded = followUpNeeded;
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
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Admin[ adminId=" + adminId + " ]";
    }
    
}
