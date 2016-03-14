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
 * @author Kimberly Oshiro
 */
@Entity
@Table(name = "followup")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Followup.findAll", query = "SELECT f FROM Followup f"),
    @NamedQuery(name = "Followup.findByFollowUpId", query = "SELECT f FROM Followup f WHERE f.followUpId = :followUpId"),
    @NamedQuery(name = "Followup.findByComments", query = "SELECT f FROM Followup f WHERE f.comments = :comments"),
    @NamedQuery(name = "Followup.findByNote", query = "SELECT f FROM Followup f WHERE f.note = :note"),
    @NamedQuery(name = "Followup.findByRecommendations", query = "SELECT f FROM Followup f WHERE f.recommendations = :recommendations")})
public class Followup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "followUpId")
    private Integer followUpId;
    @Size(max = 255)
    @Column(name = "comments")
    private String comments;
    @Size(max = 255)
    @Column(name = "note")
    private String note;
    @Size(max = 255)
    @Column(name = "recommendations")
    private String recommendations;

    public Followup() {
    }

    public Followup(Integer followUpId) {
        this.followUpId = followUpId;
    }

    public Integer getFollowUpId() {
        return followUpId;
    }

    public void setFollowUpId(Integer followUpId) {
        this.followUpId = followUpId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getRecommendations() {
        return recommendations;
    }

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
