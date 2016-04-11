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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author waynelin
 */
@Entity
@Table(name = "assessment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assessment.findAll", query = "SELECT a FROM Assessment a"),
    @NamedQuery(name = "Assessment.findByAssessmentId", query = "SELECT a FROM Assessment a WHERE a.assessmentId = :assessmentId"),
    @NamedQuery(name = "Assessment.findByType", query = "SELECT a FROM Assessment a WHERE a.type = :type")})
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

    public Assessment() {
    }

    public Assessment(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public Assessment(Integer assessmentId, String type) {
        this.assessmentId = assessmentId;
        this.type = type;
    }

    public Integer getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(Integer assessmentId) {
        this.assessmentId = assessmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Admin getAdminId() {
        return adminId;
    }

    public void setAdminId(Admin adminId) {
        this.adminId = adminId;
    }

    public Discomfort getDiscomfortId() {
        return discomfortId;
    }

    public void setDiscomfortId(Discomfort discomfortId) {
        this.discomfortId = discomfortId;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Followup getFollowupId() {
        return followupId;
    }

    public void setFollowupId(Followup followupId) {
        this.followupId = followupId;
    }

    public Pmb getPmbId() {
        return pmbId;
    }

    public void setPmbId(Pmb pmbId) {
        this.pmbId = pmbId;
    }

    public Pwae getPwaId() {
        return pwaId;
    }

    public void setPwaId(Pwae pwaId) {
        this.pwaId = pwaId;
    }

    public Spm getSpmId() {
        return spmId;
    }

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
