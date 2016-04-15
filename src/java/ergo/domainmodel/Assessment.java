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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @version 1.0 14/04/2016
 */
@Entity
@Table(name = "assessment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assessment.findAll", query = "SELECT a FROM Assessment a"),
    @NamedQuery(name = "Assessment.findByAssessmentId", query = "SELECT a FROM Assessment a WHERE a.assessmentId = :assessmentId"),
    @NamedQuery(name = "Assessment.findByType", query = "SELECT a FROM Assessment a WHERE a.type = :type"),
    @NamedQuery(name = "Assessment.findByCreateDate", query = "SELECT a FROM Assessment a WHERE a.createDate = :createDate"),
    @NamedQuery(name = "Assessment.findByEditDate", query = "SELECT a FROM Assessment a WHERE a.editDate = :editDate")})
public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "assessmentId")
    private Integer assessmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "createDate")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Column(name = "editDate")
    @Temporal(TemporalType.DATE)
    private Date editDate;
    @JoinColumn(name = "adminId", referencedColumnName = "adminId")
    @ManyToOne
    private Admin adminId;
    @JoinColumn(name = "discomfortId", referencedColumnName = "discomfortId")
    @ManyToOne
    private Discomfort discomfortId;
    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
    @ManyToOne(optional = false)
    private Client clientId;
    @JoinColumn(name = "followupId", referencedColumnName = "followUpId")
    @ManyToOne
    private Followup followupId;
    @JoinColumn(name = "pmbId", referencedColumnName = "pmbId")
    @ManyToOne
    private Pmb pmbId;
    @JoinColumn(name = "pwaId", referencedColumnName = "pwaeId")
    @ManyToOne
    private Pwae pwaId;
    @JoinColumn(name = "spmId", referencedColumnName = "spmId")
    @ManyToOne
    private Spm spmId;

    /**
     * The basic Assessment Object constructor, instantiates all the variables to null. 
     */
    public Assessment() {
    }

    /**
     * Assessment Object constructor. takes in the assessmentId as a parameter during object construction and sets it as an object variable. 
     * Pre - Parameter must be an integer. 
     * Post - the assessmentId is set as the object variable. 
     * 
     * @param assessmentId - using this parameter, the Assessment will update the object variable. 
     */
    public Assessment(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    /**
     * Assessment Object constructor. takes in the assessmentId as a parameter during object construction and sets it as an object variable. 
     * Pre - Parameter must be designated types. 
     * Post - the assessmentId is set as the object variable. 
     * 
     * @param assessmentId - using this parameter, the Assessment will update the object variable. 
     * @param type - using this parameter, the Assessment will update the object variable. 
     * @param createDate - using this parameter, the Assessment will update the object variable. 
     */
    public Assessment(Integer assessmentId, String type, Date createDate) {
        this.assessmentId = assessmentId;
        this.type = type;
        this.createDate = createDate;
    }

    /**
     * Returns the Object's assessmentId variable. 
     * Pre - the Object must have an assessmentId Variable. 
     * 
     * @return - An Integer that represents the Assessments assesmentId value. 
     */
    public Integer getAssessmentId() {
        return assessmentId;
    }

    /**
     * Takes in a parameter and sets the value of the assessmentId to the parameter. 
     * Pre - the parameter must be an Integer. 
     * Post - the Assessment assessmentId value has been updated. 
     * 
     * @param assessmentId - An Integer value, the Assessment will update the object variable. 
     */
    public void setAssessmentId(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    /**
     * Returns the Object's type variable. 
     * Pre - the Object must have a type.
     * 
     * @return - An Integer that represents the Assessments type value. 
     */
    public String getType() {
        return type;
    }

    /**
     * Takes in a parameter and sets the value of the adminId to that of the parameter. 
     * pre - The parameter must be an type object type. 
     * Post - the type has been updated. 
     * 
     * @param type - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the Object's createDate variable. 
     * Pre - the Object must have a createDate variable. 
     * 
     * @return - An Integer that represents the Assessments createDate. 
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Takes in a parameter and sets the value of the createDate to that of the parameter. 
     * pre - The parameter must be an Admin object type. 
     * Post - the createDate has been updated. 
     * 
     * @param createDate - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Returns the Object's editDate variable. 
     * Pre - the Object must have a editDate variable. 
     * 
     * @return - An Integer that represents the Assessments editDate. 
     */
    public Date getEditDate() {
        return editDate;
    }

    /**
     * Takes in a parameter and sets the value of the editDate to that of the parameter. 
     * pre - The parameter must be an Admin object type. 
     * Post - the editDate has been updated. 
     * 
     * @param editDate - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    /**
     * Returns the Object's adminId variable. 
     * Pre - the Object must have a adminId variable. 
     * 
     * @return - An Integer that represents the Assessments adminId. 
     */
    public Admin getAdminId() {
        return adminId;
    }

    /**
     * Takes in a parameter and sets the value of the adminId to that of the parameter. 
     * pre - The parameter must be an Admin object type. 
     * Post - the adminId has been updated. 
     * 
     * @param adminId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    /**
     * Returns the Object's discomfortId variable. 
     * Pre - the Object must have a discomfortId variable. 
     * 
     * @return - A Discomfort Object that represents the Assessments discomfortId. 
     */
    public Discomfort getDiscomfortId() {
        return discomfortId;
    }

    /**
     * Takes in a parameter and sets the value of the discomfortId to that of the parameter. 
     * pre - The parameter must be a Discomfort Object. 
     * Post - the discomfortId has been updated. 
     * 
     * @param discomfortId - a Discomfort Object, the Assessment will use the parameter to update the object variable. 
     */
    public void setDiscomfortId(Discomfort discomfortId) {
        this.discomfortId = discomfortId;
    }

    /**
     * Returns the Object's clientId variable. 
     * Pre - the Object must have a clientId variable. 
     * 
     * @return - A Client Object that represents the Assessments clientId. 
     */
    public Client getClientId() {
        return clientId;
    }

    /**
     * Takes in a parameter and sets the value of the clientId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the clientId has been updated. 
     * 
     * @param clientId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    /**
     * Returns the Object's followupId variable. 
     * Pre - the Object must have a followupId variable. 
     * 
     * @return - An Integer that represents the Assessments followupId. 
     */
    public Followup getFollowupId() {
        return followupId;
    }

    /**
     * Takes in a parameter and sets the value of the followupId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the followupId has been updated. 
     * 
     * @param followupId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setFollowupId(Followup followupId) {
        this.followupId = followupId;
    }

    /**
     * Returns the Object's pmbId variable. 
     * Pre - the Object must have a Pmb Object. 
     * 
     * @return - A Pmb Object that represents the Assessments pmbId. 
     */
    public Pmb getPmbId() {
        return pmbId;
    }

    /**
     * Takes in a parameter and sets the value of the pmbId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the pmbId has been updated. 
     * 
     * @param pmbId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setPmbId(Pmb pmbId) {
        this.pmbId = pmbId;
    }

    /**
     * Returns the Object's pwaId variable. 
     * Pre - the Object must have a Pwae Object. 
     * 
     * @return - A Pwae Object that represents the Assessments pwaId. 
     */
    public Pwae getPwaId() {
        return pwaId;
    }

    /**
     * Takes in a parameter and sets the value of the pwaId to that of the parameter. 
     * pre - The parameter must be a Pwae Object. 
     * Post - the pwaId has been updated. 
     * 
     * @param pwaId - a Pwae Object value, the Assessment will use the parameter to update the object variable. 
     */
    public void setPwaId(Pwae pwaId) {
        this.pwaId = pwaId;
    }

    /**
     * Returns the Object's spmId variable. 
     * Pre - the Object must have a Spm Object. 
     * 
     * @return - A Spm Object that represents the Assessments spmId. 
     */
    public Spm getSpmId() {
        return spmId;
    }

    /**
     * Takes in a parameter and sets the value of the spmId to that of the parameter. 
     * pre - The parameter must be a Spm Object. 
     * Post - the spmId has been updated. 
     * 
     * @param spmId - a Spm Object, the Assessment will use the parameter to update the object variable. 
     */
    public void setSpmId(Spm spmId) {
        this.spmId = spmId;
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
