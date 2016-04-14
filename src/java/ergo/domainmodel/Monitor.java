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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 671402
 */
@Entity
@Table(name = "monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m"),
    @NamedQuery(name = "Monitor.findByMonitorId", query = "SELECT m FROM Monitor m WHERE m.monitorId = :monitorId"),
    @NamedQuery(name = "Monitor.findByAssessmentId", query = "SELECT m FROM Monitor m WHERE m.assessmentId = :assessmentId"),
    @NamedQuery(name = "Monitor.findBySize", query = "SELECT m FROM Monitor m WHERE m.size = :size"),
    @NamedQuery(name = "Monitor.findByPre", query = "SELECT m FROM Monitor m WHERE m.pre = :pre"),
    @NamedQuery(name = "Monitor.findByPost", query = "SELECT m FROM Monitor m WHERE m.post = :post"),
    @NamedQuery(name = "Monitor.findByRecommendation", query = "SELECT m FROM Monitor m WHERE m.recommendation = :recommendation"),
    @NamedQuery(name = "Monitor.findByNotes", query = "SELECT m FROM Monitor m WHERE m.notes = :notes"),
    @NamedQuery(name = "Monitor.findByType", query = "SELECT m FROM Monitor m WHERE m.type = :type")})
public class Monitor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "monitorId")
    private Integer monitorId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "assessmentId")
    private int assessmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "size")
    private int size;
    @Column(name = "pre")
    private Integer pre;
    @Column(name = "post")
    private Integer post;
    @Size(max = 300)
    @Column(name = "recommendation")
    private String recommendation;
    @Size(max = 300)
    @Column(name = "notes")
    private String notes;
    @Size(max = 50)
    @Column(name = "type")
    private String type;

    /**
     * The default Location constructor, sets up the object with all default nulls. 
     */
    public Monitor() {
    }

    /**
     * Instantiates the Location Object with one Parameter, that being the monitorId. 
     * @param monitorId 
     */
    public Monitor(Integer monitorId) {
        this.monitorId = monitorId;
    }

    /**
     * Instantiates the Location Object with three Parameters, that being the monitor, assessmentId, and size. 
     * @param monitorId
     * @param assessmentId
     * @param size 
     */
    public Monitor(Integer monitorId, int assessmentId, int size) {
        this.monitorId = monitorId;
        this.assessmentId = assessmentId;
        this.size = size;
    }

    /**
     * Returns the monitorId value of the object. 
     * pre - the Object must have a monitorId. 
     * 
     * @return - An Integer value that represents the Object's monitorId. 
     */
    public Integer getMonitorId() {
        return monitorId;
    }

    /**
     * Takes in a parameter and sets the monitorId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the monitorId value has been updated.
     * 
     * @param monitorId - An Integer value that represents the Object's monitorId that will replace the current value. 
     */
    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

  /**
     * Returns the monitorId value of the object. 
     * pre - the Object must have a assessmentId. 
     * 
     * @return - An Integer value that represents the Object's assessmentId. 
     */
    public int getAssessmentId() {
        return assessmentId;
    }

    /**
     * Takes in a parameter and sets the assessmentId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the assessmentId value has been updated.
     * 
     * @param assessmentId - An Integer value that represents the Object's assessmentId that will replace the current value. 
     */
    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    /**
     * Returns the size value of the object. 
     * pre - the Object must have a size. 
     * 
     * @return - An Integer value that represents the Object's size. 
     */
    public int getSize() {
        return size;
    }

    /**
     * Takes in a parameter and sets the size object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the size value has been updated.
     * 
     * @param size - An Integer value that represents the Object's size that will replace the current value. 
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Returns the pre value of the object. 
     * pre - the Object must have a pre. 
     * 
     * @return - An Integer value that represents the Object's pre. 
     */
    public Integer getPre() {
        return pre;
    }

    /**
     * Takes in a parameter and sets the pre object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the pre value has been updated.
     * 
     * @param pre - An Integer value that represents the Object's pre that will replace the current value. 
     */
    public void setPre(Integer pre) {
        this.pre = pre;
    }

    /**
     * Returns the post value of the object. 
     * pre - the Object must have a post. 
     * 
     * @return - An Integer value that represents the Object's post. 
     */
    public Integer getPost() {
        return post;
    }

    /**
     * Takes in a parameter and sets the post object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the post value has been updated.
     * 
     * @param post - An Integer value that represents the Object's post that will replace the current value. 
     */
    public void setPost(Integer post) {
        this.post = post;
    }

     /**
     * Returns the recommendation value of the object. 
     * pre - the Object must have a recommendation. 
     * 
     * @return - A String value that represents the Object's recommendation. 
     */
    public String getRecommendation() {
        return recommendation;
    }

     /**
     * Takes in a parameter and sets the recommendation object variable to that parameters. 
     * Pre - the Parameter must be a String
     * post - the recommendation value has been updated.
     * 
     * @param recommendation - A String value that represents the Object's recommendation that will replace the current value. 
     */
    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    /**
     * Returns the recommendation value of the object. 
     * pre - the Object must have a recommendation. 
     * 
     * @return - An Integer value that represents the Object's recommendation. 
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Takes in a parameter and sets the notes object variable to that parameters. 
     * Pre - the Parameter must be a String
     * post - the notes value has been updated.
     * 
     * @param notes - A String value that represents the Object's notes that will replace the current value. 
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * Returns the type value of the object. 
     * pre - the Object must have a type. 
     * 
     * @return - An Integer value that represents the Object's type. 
     */
    public String getType() {
        return type;
    }

    /**
     * Takes in a parameter and sets the type object variable to that parameters. 
     * Pre - the Parameter must be a String
     * post - the notes value has been updated.
     * 
     * @param type - A String value that represents the Object's type that will replace the current value. 
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (monitorId != null ? monitorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Monitor)) {
            return false;
        }
        Monitor other = (Monitor) object;
        if ((this.monitorId == null && other.monitorId != null) || (this.monitorId != null && !this.monitorId.equals(other.monitorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Monitor[ monitorId=" + monitorId + " ]";
    }
    
}
