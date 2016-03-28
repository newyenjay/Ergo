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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 680420
 */
@Entity
@Table(name = "assessment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assessment.findAll", query = "SELECT a FROM Assessment a"),
    @NamedQuery(name = "Assessment.findByAssessmentId", query = "SELECT a FROM Assessment a WHERE a.assessmentId = :assessmentId"),
    @NamedQuery(name = "Assessment.findByAdminId", query = "SELECT a FROM Assessment a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "Assessment.findByPmbId", query = "SELECT a FROM Assessment a WHERE a.pmbId = :pmbId"),
    @NamedQuery(name = "Assessment.findBySpmId", query = "SELECT a FROM Assessment a WHERE a.spmId = :spmId"),
    @NamedQuery(name = "Assessment.findByPwaId", query = "SELECT a FROM Assessment a WHERE a.pwaId = :pwaId"),
    @NamedQuery(name = "Assessment.findByDiscomfortId", query = "SELECT a FROM Assessment a WHERE a.discomfortId = :discomfortId"),
    @NamedQuery(name = "Assessment.findByFollowupId", query = "SELECT a FROM Assessment a WHERE a.followupId = :followupId")})
public class Assessment implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessmentassessmentId")
    private List<Admin> adminList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "assessmentId")
    private Integer assessmentId;
    @Column(name = "adminId")
    private Integer adminId;
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
    @JoinColumn(name = "client_clientId", referencedColumnName = "clientId")
    @ManyToOne(optional = false)
    private Client clientclientId;

    public Assessment() {
    }

    public Assessment(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Integer getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getPmbId() {
        return pmbId;
    }

    public void setPmbId(Integer pmbId) {
        this.pmbId = pmbId;
    }

    public Integer getSpmId() {
        return spmId;
    }

    public void setSpmId(Integer spmId) {
        this.spmId = spmId;
    }

    public Integer getPwaId() {
        return pwaId;
    }

    public void setPwaId(Integer pwaId) {
        this.pwaId = pwaId;
    }

    public Integer getDiscomfortId() {
        return discomfortId;
    }

    public void setDiscomfortId(Integer discomfortId) {
        this.discomfortId = discomfortId;
    }

    public Integer getFollowupId() {
        return followupId;
    }

    public void setFollowupId(Integer followupId) {
        this.followupId = followupId;
    }

    public Client getClientclientId() {
        return clientclientId;
    }

    public void setClientclientId(Client clientclientId) {
        this.clientclientId = clientclientId;
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

    @XmlTransient
    public List<Admin> getAdminList() {
        return adminList;
    }

    public void setAdminList(List<Admin> adminList) {
        this.adminList = adminList;
    }
    
}
