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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * The Assessment Java Bean that handles the Assessment table. Crucial for CRUD functionality in the ErgoRisk System. 
 * @version 1.0 - Inserting Javadoc. Will not be putting javadoc on the methods that have override notations. 
 */
@Entity
@Table(name = "assessment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assessment.findAll", query = "SELECT a FROM Assessment a"),
    @NamedQuery(name = "Assessment.findByAssessmentId", query = "SELECT a FROM Assessment a WHERE a.assessmentId = :assessmentId"),
    @NamedQuery(name = "Assessment.findByPmbId", query = "SELECT a FROM Assessment a WHERE a.pmbId = :pmbId"),
    @NamedQuery(name = "Assessment.findBySpmId", query = "SELECT a FROM Assessment a WHERE a.spmId = :spmId"),
    @NamedQuery(name = "Assessment.findByPwaId", query = "SELECT a FROM Assessment a WHERE a.pwaId = :pwaId"),
    @NamedQuery(name = "Assessment.findByDiscomfortId", query = "SELECT a FROM Assessment a WHERE a.discomfortId = :discomfortId"),
    @NamedQuery(name = "Assessment.findByFollowupId", query = "SELECT a FROM Assessment a WHERE a.followupId = :followupId")})
public class Assessment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "assessmentId")
    private Integer assessmentId;
    @Column(name = "pmbId")
    private Integer pmbId;
    @Column(name = "spmId")
    private Integer spmId;
    @Column(name = "pwaId")
    private Integer pwaId;
    @Column(name = "discomfortId")
    private Integer discomfortId;
    @Column(name = "followupId")
    private Integer followupId;
    @JoinColumn(name = "adminId", referencedColumnName = "adminId")
    @ManyToOne
    private Admin adminId;
    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
    @ManyToOne(optional = false)
    private Client clientId;

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
     * Returns the Object's pmbId variable. 
     * Pre - the Object must have a pmbId.
     * 
     * @return - An INteger that represents the Assessments pmbId value. 
     */
    public Integer getPmbId() {
        return pmbId;
    }

    /**
     * Takes in a parameter and sets the value of the pmbId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the pmbId has been updated. 
     * 
     * @param pmbId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setPmbId(Integer pmbId) {
        this.pmbId = pmbId;
    }

    /**
     * Returns the Object's spmId variable. 
     * Pre - the Object must have spmId. 
     * 
     * @return - An Integer that represents the Assessments spmId. 
     */
    public Integer getSpmId() {
        return spmId;
    }

    /**
     * Takes in a parameter and sets the value of the spmId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the spmId has been updated. 
     * 
     * @param spmId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setSpmId(Integer spmId) {
        this.spmId = spmId;
    }

    /**
     * Returns the Object's pwaId variable. 
     * Pre - the Object must have a pwaId variable. 
     * 
     * @return - An Integer that represents the Assessments spmId. 
     */
    public Integer getPwaId() {
        return pwaId;
    }

    /**
     * Takes in a parameter and sets the value of the pwaId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the pwaId has been updated. 
     * 
     * @param pwaId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setPwaId(Integer pwaId) {
        this.pwaId = pwaId;
    }

    /**
     * Returns the Object's discomfortId variable. 
     * Pre - the Object must have a discomfortId variable. 
     * 
     * @return - An Integer that represents the Assessments discomfortId. 
     */
    public Integer getDiscomfortId() {
        return discomfortId;
    }

    /**
     * Takes in a parameter and sets the value of the discomfortId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the discomfortId has been updated. 
     * 
     * @param discomfortId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setDiscomfortId(Integer discomfortId) {
        this.discomfortId = discomfortId;
    }

    /**
     * Returns the Object's followupId variable. 
     * Pre - the Object must have a followupId variable. 
     * 
     * @return - An Integer that represents the Assessments followupId. 
     */
    public Integer getFollowupId() {
        return followupId;
    }

    /**
     * Takes in a parameter and sets the value of the followupId to that of the parameter. 
     * pre - The parameter must be an Integer. 
     * Post - the followupId has been updated. 
     * 
     * @param followupId - an Integer value, the Assessment will use the parameter to update the object variable. 
     */
    public void setFollowupId(Integer followupId) {
        this.followupId = followupId;
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
     * Returns the Object's clientId variable. 
     * Pre - the Object must have a clientId variable. 
     * 
     * @return - An Integer that represents the Assessments clientId. 
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
