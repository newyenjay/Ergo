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
 * The admin java Bean that is based on the Administrative table in the database. 
 * @version 1.0 - inserting Javadoc. I will not be documenting the methods that have an override notation, as there's already javadoc in the API for them. 
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

    /**
     * The object constructor that takes no parameters, will simply create an object with no instance variables.
     * Pre - the object did not exist.
     * Post - the object now exists. 
     */
    public Admin() {
    }

    /**
     * Object constructor that will take in an adminId and set its adminId to the parameter. 
     * Pre - the object didn't exist.
     * Post - the object now estists with the parameter adminId as the adminId. 
     * 
     * @param adminId - the parameter that the constructor will take in and will set the adminId to. 
     */
    public Admin(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * Returns the adminId of the object.
     * Pre - the object must have an adminId.
     * 
     * @return - the Object's adminid.
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * takes in a parameter and sets the adminId to that parameter. 
     * pre - the parameter that the adminId is being set to must be a valid Integer. 
     * post - the adminId has been changed. 
     * 
     * @param adminId - an integer that is going to replace the current adminId. 
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * Returns the proactive value of the object. 
     * Pre - the object must have a proactive value. 
     * 
     * @return - a String value that represents the object's Proactive value. 
     */
    public String getProactive() {
        return proactive;
    }

    /**
     * Takes in a parameter and sets the proactive local variable to that parameter.
     * pre - the parameter must be a string.
     * post - the proactive value has been updated. 
     * 
     * @param proactive - A string value that is going to replace the current proactive value. 
     */
    public void setProactive(String proactive) {
        this.proactive = proactive;
    }

    /**
     * Returns the Reactive value of the object.
     * Pre - the object must have a reactive value. 
     * 
     * @return - a string value that represents the object's reactive value. 
     */
    public String getReactive() {
        return reactive;
    }

    /**
     * Takes in a parameter and sets the reactive local variable to that parameter.
     * pre - the parameter must be a String.
     * post - the proactive value has been updated.
     * 
     * @param reactive - A string value that is going to replace the current reactive value. 
     */
    public void setReactive(String reactive) {
        this.reactive = reactive;
    }

    /**
     * Returns the assessor value of the object.
     * Pre - the object must have an assessor value. 
     * 
     * @return - a string value that represents the Object's assessor value. 
     */
    public String getAssessor() {
        return assessor;
    }

    /**
     * Takes in a parameter and sets the assessor local variable to that parameter.
     * pre - the parameter must be a string.
     * post - the assessor value has been updated.
     * 
     * @param assessor - A string value that is going to replace the current assessor value. 
     */
    public void setAssessor(String assessor) {
        this.assessor = assessor;
    }

    /**
     * Returns the manager value of the object.
     * Pre - the object must have an assessor value. 
     * 
     * @return - A string value that represents the Object's Manager value. 
     */
    public String getManager() {
        return manager;
    }

    /**
     * Takes in a parameter and sets the manager local variable to that parameter. 
     * pre - the parameter must be a string.
     * post - the manager value has been updated. 
     * 
     * @param manager - A string value that is going to replace the current manager value. 
     */
    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Returns the business value of the object.
     * Pre - the object must have a businessUnit value. 
     * 
     * @return -A string value that represents the Object's business unit. 
     */
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * Takes in a parameter and sets the businessUnit local variable to that parameter. 
     * Pre - the parameter must be a String variable. 
     * Post - the businessUnit variable has been updated. 
     * 
     * @param businessUnit - A string value that is going to replace the current businessUnit value. 
     */
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    /**
     * Returns the workspace value of the object.
     * Pre - the object must have a workspace value. 
     * 
     * @return - A String value that represents the Object's workspace value. 
     */
    public String getWorkspace() {
        return workspace;
    }

    /**
     * Takes in a parameter and sets the workspace local variable to that parameter. 
     * Pre - the parameter must be a String. 
     * Post- the workspace variable has been updated. 
     * 
     * @param workspace - A string value that is going to replace the current workspace value. 
     */
    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    /**
     * Returns the jobTitle value of the object. 
     * Pre - the object must have a jobTitle value. 
     * 
     * @return - A string value that represents the Object's jobTitle value. 
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Takes in a parameter and sets the JobTitle object variable to that parameter. 
     * Pre - the parameter must be a string
     * post - the jobTitle variable has been updated. 
     * 
     * @param jobTitle - A string value that represents the Object's jobTitle. 
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Returns the gender value of the object. 
     * Pre - the object must have a gender value. 
     * 
     * @return - A string value that represents the Object's gender value. 
     */
    public String getGender() {
        return gender;
    }

    /**
     * Takes in a parameter and sets the gender object variable to that parameter. 
     * Pre - the parameter must be a string. 
     * post - the gender variable has been updated. 
     * 
     * @param gender - a string value that represents the Object's gender. 
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Returns the heightInFeet value of the object. 
     * Pre - The object must have a heightInFeet Value
     * 
     * @return - A Integer value that represents the Object's heightInFeet value. 
     */
    public Integer getHeightInFeet() {
        return heightInFeet;
    }

    /**
     * Takes in a parameter and sets the heightInFeet object variable to that parameters.
     * Pre - the parameter must be an integer.
     * post - the heightInFeet value has been updated. 
     * 
     * @param heightInFeet - An Integer value that represents the Object's heightInFeet that will replace the current value. 
     */
    public void setHeightInFeet(Integer heightInFeet) {
        this.heightInFeet = heightInFeet;
    }

    /**
     * Returns the heightInInches value of the object.
     * Pre - The object must have a heightInInches value. 
     * 
     * @return - An Integer value that represents the Object's heightInInches. 
     */
    public Integer getHeightInInches() {
        return heightInInches;
    }

    /**
     * Takes in a parameter and sets the heightInInches object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the heightInInches value has been updated.
     * 
     * @param heightInInches - An Integer value that represents the Object's heightInInches that will replace the current value. 
     */
    public void setHeightInInches(Integer heightInInches) {
        this.heightInInches = heightInInches;
    }

    /**
     * Returns the handedness value of the object. 
     * Pre - the object must have a handedness value. 
     * 
     * @return - A String value that represents the Object's handedness. 
     */
    public String getHandedness() {
        return handedness;
    }

    /**
     * Takes in a parameter and sets the handedness object variable to that parameter's 
     * pre - the Parameter must be a String
     * post - the handedness value has been updated. 
     * 
     * @param handedness - A string value that represents the Object's handedness that will replace the current value. 
     */
    public void setHandedness(String handedness) {
        this.handedness = handedness;
    }

    /**
     * Returns the daysPerWeek value of the object. 
     * Pre - the object must have a daysPerWeek value. 
     * 
     * @return - An Integer value that represents the Object's daysPerWeek. 
     */
    public Integer getDaysPerWeek() {
        return daysPerWeek;
    }

    /**
     * Takes in a parameter and sets the daysPerWeek object variable to the parameter's
     * pre - the Parameter must be an Integer.
     * Post - the handedness value has been updated. 
     * 
     * @param daysPerWeek - An integer value that represents the Object's daysPerWeek that will replace the current value. 
     */
    public void setDaysPerWeek(Integer daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }

    /**
     * Returns the hoursPerDay value of the object.
     * Pre - the object must have a hoursPerWeek value.
     * 
     * @return - An integer value that represents the Object's hoursPerDay value.  
     */
    public Integer getHoursPerDay() {
        return hoursPerDay;
    }

    /**
     * Takes in a parameter and sets the hoursPerDay object variable to the parameter's 
     * pre - the Parameter must be an Integer.
     * Post - the hoursPerDay value has been updated. 
     * 
     * @param hoursPerDay - An integer value that represents the Object's hoursPerDay that will replace the current value. 
     */
    public void setHoursPerDay(Integer hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }

    /**
     * Returns the hoursVDT value of the object.
     * Pre - the object must have an hoursVDT value.
     * 
     * @return - An integer value that represents the Object's hoursVDT value. 
     */
    public Integer getHoursVDT() {
        return hoursVDT;
    }

    /**
     * Takes in a parameter and sets the hoursVDT object variable to the parameter's
     * Pre - the parameter must be an integer. 
     * Post - the hoursVDT value has been updated. 
     * 
     * @param hoursVDT - An integer value that represents the Object's hoursVDT that will replace the current value. 
     */
    public void setHoursVDT(Integer hoursVDT) {
        this.hoursVDT = hoursVDT;
    }

    /**
     * Returns the hoursOnPhone value of the object. 
     * pre - the object must have a hoursOnPhone value. 
     * 
     * @return - An integer value that represents the Object's hoursOnPhone value. 
     */
    public Integer getHoursOnPhone() {
        return hoursOnPhone;
    }

    /**
     * Takes in a parameter and sets the hoursOnPhone object variable to the parameter's
     * Pre - the parameter must be a String. 
     * Post - the hoursOnPhone value has been updated. 
     * 
     * @param hoursOnPhone - An integer value that represents the Object's hoursOnPhone that will replace the current value. 
     */
    public void setHoursOnPhone(Integer hoursOnPhone) {
        this.hoursOnPhone = hoursOnPhone;
    }

    /**
     * Returns the discomfortPresent value of the object. 
     * pre - the object must have a discomfortPresent value. 
     * 
     * @return - A String value that represents the Object's discomfortPresent value. 
     */
    public String getDiscomfortPresent() {
        return discomfortPresent;
    }

    /**
     * Takes in a parameter and sets the discomfortPresent object variable to the parameter's
     * Pre - the parameter must be a String. 
     * Post - the discomfortPresent value has been updated. 
     * 
     * @param discomfortPresent - A String value that represents the Object's discomfortPresent that will replace the current value. 
     */
    public void setDiscomfortPresent(String discomfortPresent) {
        this.discomfortPresent = discomfortPresent;
    }

    /**
     * Returns the discomfortReported value of the object. 
     * pre - the object must have a discomfortReported value. 
     * 
     * @return - A String value that represents the Object's discomfortReported value. 
     */
    public String getDiscomfortReported() {
        return discomfortReported;
    }

    /**
     * Takes in a parameter and sets the discomfortReported object variable to the parameter's
     * Pre - the parameter must be a String. 
     * Post - the discomfortPresent value has been updated. 
     * 
     * @param discomfortReported - A String value that represents the Object's discomfortReported that will replace the current value. 
     */
    public void setDiscomfortReported(String discomfortReported) {
        this.discomfortReported = discomfortReported;
    }

    /**
     * Returns the treatmentSought value of the object. 
     * pre - the object must have a treatmentSought value. 
     * 
     * @return - A String value that represents the Object's treatmentSought value. 
     */
    public String getTreatmentSought() {
        return treatmentSought;
    }
    
    /**
     * Takes in a parameter and sets the treatmentSought object variable to the parameter's
     * Pre - the parameter must be a String. 
     * Post - the discomfortPresent value has been updated. 
     * 
     * @param treatmentSought - A String value that represents the Object's treatmentSought that will replace the current value. 
     */
    public void setTreatmentSought(String treatmentSought) {
        this.treatmentSought = treatmentSought;
    }

    /**
     * Returns the maxDiscomfort value of the object. 
     * pre - the object must have a maxDiscomfort value. 
     * 
     * @return - An Integer value that represents the Object's maxDiscomfort value. 
     */
    public Integer getMaxDiscomfort() {
        return maxDiscomfort;
    }

    /**
     * Takes in a parameter and sets the maxDiscomfort object variable to the parameter's
     * Pre - the parameter must be an Integer. 
     * Post - the discomfortPresent value has been updated. 
     * 
     * @param maxDiscomfort - An Integer value that represents the Object's maxDiscomfort that will replace the current value. 
     */
    public void setMaxDiscomfort(Integer maxDiscomfort) {
        this.maxDiscomfort = maxDiscomfort;
    }

    /**
     * Returns the workFit value of the object. 
     * pre - the object must have a workFit value. 
     * 
     * @return - An Integer value that represents the Object's workFit value. 
     */
    public Integer getWorkFit() {
        return workFit;
    }

    /**
     * Takes in a parameter and sets the workFit object variable to the parameter's
     * Pre - the parameter must be an Integer. 
     * Post - the workFit value has been updated. 
     * 
     * @param workFit - An Integer value that represents the Object's workFit that will replace the current value. 
     */
    public void setWorkFit(Integer workFit) {
        this.workFit = workFit;
    }

    /**
     * Returns the risks value of the object. 
     * pre - the object must have a risks value. 
     * 
     * @return - A String value that represents the Object's risks value. 
     */
    public String getRisks() {
        return risks;
    }

    /**
     * Takes in a parameter and sets the risks object variable to the parameter's
     * Pre - the parameter must be a Strign. 
     * Post - the risks value has been updated. 
     * 
     * @param risks - A String value that represents the Object's risks that will replace the current value. 
     */
    public void setRisks(String risks) {
        this.risks = risks;
    }

    /**
     * Returns the equipmentRecommendations value of the object. 
     * pre - the object must have a equipmentRecommendations value. 
     * 
     * @return - A String value that represents the Object's equipmentRecommendations value. 
     */
    public String getEquipmentRecommendations() {
        return equipmentRecommendations;
    }

    /**
     * Takes in a parameter and sets the equipmentRecommendations object variable to the parameter's
     * Pre - the parameter must be a String. 
     * Post - the equipmentRecommendations value has been updated. 
     * 
     * @param equipmentRecommendations - A String value that represents the Object's equipmentRecommendations that will replace the current value. 
     */
    public void setEquipmentRecommendations(String equipmentRecommendations) {
        this.equipmentRecommendations = equipmentRecommendations;
    }

    /**
     * Returns the generalNotes value of the object. 
     * pre - the object must have a generalNotes value. 
     * 
     * @return - A String value that represents the Object's generalNotes value. 
     */
    public String getGeneralNotes() {
        return generalNotes;
    }

    /**
     * Takes in a parameter and sets the generalNotes object variable to the parameter's
     * Pre - the parameter must be a String. 
     * Post - the generalNotes value has been updated. 
     * 
     * @param generalNotes - A String value that represents the Object's generalNotes that will replace the current value. 
     */
    public void setGeneralNotes(String generalNotes) {
        this.generalNotes = generalNotes;
    }

    /**
     * Returns the score value of the object. 
     * pre - the object must have a score value. 
     * 
     * @return - An Integer value that represents the Object's score value. 
     */
    public Integer getScore() {
        return score;
    }

     /**
     * Takes in a parameter and sets the score object variable to the parameter's
     * Pre - the parameter must be an Integer. 
     * Post - the score value has been updated. 
     * 
     * @param score - An Integer value that represents the Object's score that will replace the current value. 
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Returns the followUpNeeded value of the object. 
     * pre - the object must have a followUpNeeded value. 
     * 
     * @return - A String value that represents the Object's followUpNeeded value. 
     */
    public String getFollowUpNeeded() {
        return followUpNeeded;
    }

    /**
     * Takes in a parameter and sets the followUpNeeded object variable to the parameter's
     * Pre - the parameter must be a String. 
     * Post - the followUpNeeded value has been updated. 
     * 
     * @param followUpNeeded - A String value that represents the Object's followUpNeeded that will replace the current value. 
     */
    public void setFollowUpNeeded(String followUpNeeded) {
        this.followUpNeeded = followUpNeeded;
    }

    /**
     * Returns the assessmentList list of the object. 
     * pre - the object must have a assessmentList list. 
     * 
     * @return - A Java.util.list value that represents the Object's assessmentList list. 
     */
    @XmlTransient
    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    /**
     * Takes in a parameter and sets the assessmentList object variable to the parameter's
     * Pre - the parameter must be a Java.util.List
     * Post - the assessmentList has been updated. 
     * 
     * @param assessmentList - A Java.util.List that represents the Object's assessmentList that will replace the current list. 
     */
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
