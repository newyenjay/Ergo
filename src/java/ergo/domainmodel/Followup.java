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
 * @version 1.0 - inserting javadoc. Will not be inserting javadoc over overriden code. 14/04/2016
 */
@Entity
@Table(name = "followup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followup.findAll", query = "SELECT f FROM Followup f"),
    @NamedQuery(name = "Followup.findByFollowUpId", query = "SELECT f FROM Followup f WHERE f.followUpId = :followUpId"),
    @NamedQuery(name = "Followup.findByNote", query = "SELECT f FROM Followup f WHERE f.note = :note"),
    @NamedQuery(name = "Followup.findByComments", query = "SELECT f FROM Followup f WHERE f.comments = :comments"),
    @NamedQuery(name = "Followup.findByRecommendations", query = "SELECT f FROM Followup f WHERE f.recommendations = :recommendations")})
public class Followup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "followUpId")
    private Integer followUpId;
    @Size(max = 300)
    @Column(name = "note")
    private String note;
    @Size(max = 300)
    @Column(name = "comments")
    private String comments;
    @Size(max = 300)
    @Column(name = "recommendations")
    private String recommendations;

    /**
     * The default Company constructor, sets up the object with all default nulls. 
     * Pre - none
     */
    public Followup() {
    }

    /**
     * Instantiates the Company Object with one Parameter, that being the followUpId. 
     * @param followUpId - the parameter that the constructor will take in and will set the followUpId to.
     */
    public Followup(Integer followUpId) {
        this.followUpId = followUpId;
    }

    /**
     * Returns the followUpId value of the object. 
     * pre - the Object must have a followUpId. 
     * 
     * @return - An Integer value that represents the Object's followUpId. 
     */
    public Integer getFollowUpId() {
        return followUpId;
    }

    /**
     * Takes in a parameter and sets the followUpId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the followUpId value has been updated.
     * 
     * @param followUpId - An Integer value that represents the Object's followUpId that will replace the current value. 
     */
    public void setFollowUpId(Integer followUpId) {
        this.followUpId = followUpId;
    }

    /**
     * Returns the note value of the object. 
     * pre - the Object must have a note. 
     * 
     * @return - A String value that represents the Object's note. 
     */
    public String getNote() {
        return note;
    }

    /**
     * Takes in a parameter and sets the note object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the note value has been updated.
     * 
     * @param note - A String value that represents the Object's note that will replace the current value. 
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Returns the comments value of the object. 
     * pre - the Object must have a comments. 
     * 
     * @return - A String value that represents the Object's comments. 
     */
    public String getComments() {
        return comments;
    }

    /**
     * Takes in a parameter and sets the comments object variable to that parameters. 
     * Pre - the Parameter must be a comments.
     * post - the note value has been updated.
     * 
     * @param comments - A String value that represents the Object's comments that will replace the current value. 
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Returns the recommendations value of the object. 
     * pre - the Object must have a recommendations. 
     * 
     * @return - A String value that represents the Object's recommendations. 
     */
    public String getRecommendations() {
        return recommendations;
    }

    /**
     * Takes in a parameter and sets the recommendations object variable to that parameters. 
     * Pre - the Parameter must be a recommendation.
     * post - the note value has been updated.
     * 
     * @param recommendations - A String value that represents the Object's recommendations that will replace the current value. 
     */
    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (followUpId != null ? followUpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Followup)) {
            return false;
        }
        Followup other = (Followup) object;
        if ((this.followUpId == null && other.followUpId != null) || (this.followUpId != null && !this.followUpId.equals(other.followUpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Followup[ followUpId=" + followUpId + " ]";
    }
    
}
