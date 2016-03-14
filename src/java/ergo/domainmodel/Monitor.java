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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m"),
    @NamedQuery(name = "Monitor.findByMonitorId", query = "SELECT m FROM Monitor m WHERE m.monitorId = :monitorId"),
    @NamedQuery(name = "Monitor.findByNotes", query = "SELECT m FROM Monitor m WHERE m.notes = :notes"),
    @NamedQuery(name = "Monitor.findByPost", query = "SELECT m FROM Monitor m WHERE m.post = :post"),
    @NamedQuery(name = "Monitor.findByPre", query = "SELECT m FROM Monitor m WHERE m.pre = :pre"),
    @NamedQuery(name = "Monitor.findByRecommendation", query = "SELECT m FROM Monitor m WHERE m.recommendation = :recommendation"),
    @NamedQuery(name = "Monitor.findBySize", query = "SELECT m FROM Monitor m WHERE m.size = :size"),
    @NamedQuery(name = "Monitor.findByType", query = "SELECT m FROM Monitor m WHERE m.type = :type")})
public class Monitor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "monitorId")
    private Integer monitorId;
    @Size(max = 255)
    @Column(name = "notes")
    private String notes;
    @Column(name = "post")
    private Integer post;
    @Column(name = "pre")
    private Integer pre;
    @Size(max = 255)
    @Column(name = "recommendation")
    private String recommendation;
    @Column(name = "size")
    private Integer size;
    @Size(max = 255)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "assessmentId", referencedColumnName = "assessmentId")
    @ManyToOne
    private Assessment assessmentId;

    public Monitor() {
    }

    public Monitor(Integer monitorId) {
        this.monitorId = monitorId;
    }

    public Integer getMonitorId() {
        return monitorId;
    }

    public void setMonitorId(Integer monitorId) {
        this.monitorId = monitorId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public Integer getPre() {
        return pre;
    }

    public void setPre(Integer pre) {
        this.pre = pre;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Assessment getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Assessment assessmentId) {
        this.assessmentId = assessmentId;
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
