/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 671402
 */
@Entity
@Table(name = "clientemployee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientEmployee.findAll", query = "SELECT c FROM ClientEmployee c"),
    @NamedQuery(name = "ClientEmployee.findByClientId", query = "SELECT c FROM ClientEmployee c WHERE c.clientEmployeePK.clientId = :clientId"),
    @NamedQuery(name = "ClientEmployee.findByEmployeeId", query = "SELECT c FROM ClientEmployee c WHERE c.clientEmployeePK.employeeId = :employeeId")})
public class ClientEmployee implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientEmployeePK clientEmployeePK;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clientEmployee")
    private Client client;
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Employee employee;

    public ClientEmployee() {
    }

    public ClientEmployee(ClientEmployeePK clientEmployeePK) {
        this.clientEmployeePK = clientEmployeePK;
    }

    public ClientEmployee(int clientId, int employeeId) {
        this.clientEmployeePK = new ClientEmployeePK(clientId, employeeId);
    }

    public ClientEmployeePK getClientEmployeePK() {
        return clientEmployeePK;
    }

    public void setClientEmployeePK(ClientEmployeePK clientEmployeePK) {
        this.clientEmployeePK = clientEmployeePK;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientEmployeePK != null ? clientEmployeePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientEmployee)) {
            return false;
        }
        ClientEmployee other = (ClientEmployee) object;
        if ((this.clientEmployeePK == null && other.clientEmployeePK != null) || (this.clientEmployeePK != null && !this.clientEmployeePK.equals(other.clientEmployeePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.ClientEmployee[ clientEmployeePK=" + clientEmployeePK + " ]";
    }
    
}
