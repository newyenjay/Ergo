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
 * @author tetsu
 */
@Entity
@Table(name = "monitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Monitor.findAll", query = "SELECT m FROM Monitor m"),
    @NamedQuery(name = "Monitor.findByMonitorId", query = "SELECT m FROM Monitor m WHERE m.monitorId = :monitorId"),
    @NamedQuery(name = "Monitor.findByType", query = "SELECT m FROM Monitor m WHERE m.type = :type"),
    @NamedQuery(name = "Monitor.findByCurrent", query = "SELECT m FROM Monitor m WHERE m.current = :current"),
    @NamedQuery(name = "Monitor.findByRecommand", query = "SELECT m FROM Monitor m WHERE m.recommand = :recommand"),
    @NamedQuery(name = "Monitor.findBySitStand", query = "SELECT m FROM Monitor m WHERE m.sitStand = :sitStand")})
public class Monitor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "monitorId")
    private Integer monitorId;
    @Size(max = 45)
    @Column(name = "type")
    private String type;
    @Size(max = 45)
    @Column(name = "current")
    private String current;
    @Size(max = 45)
    @Column(name = "recommand")
    private String recommand;
    @Size(max = 45)
    @Column(name = "sitStand")
    private String sitStand;
    @JoinColumn(name = "pwaeId", referencedColumnName = "pwaeId")
    @ManyToOne(optional = false)
    private Pwae pwaeId;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public String getRecommand() {
        return recommand;
    }

    public void setRecommand(String recommand) {
        this.recommand = recommand;
    }

    public String getSitStand() {
        return sitStand;
    }

    public void setSitStand(String sitStand) {
        this.sitStand = sitStand;
    }

    public Pwae getPwaeId() {
        return pwaeId;
    }

    public void setPwaeId(Pwae pwaeId) {
        this.pwaeId = pwaeId;
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
