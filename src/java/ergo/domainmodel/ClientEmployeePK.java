/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 671402
 */
@Embeddable
public class ClientEmployeePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientId")
    private int clientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "employeeId")
    private int employeeId;

    public ClientEmployeePK() {
    }

    public ClientEmployeePK(int clientId, int employeeId) {
        this.clientId = clientId;
        this.employeeId = employeeId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) clientId;
        hash += (int) employeeId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientEmployeePK)) {
            return false;
        }
        ClientEmployeePK other = (ClientEmployeePK) object;
        if (this.clientId != other.clientId) {
            return false;
        }
        if (this.employeeId != other.employeeId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.ClientEmployeePK[ clientId=" + clientId + ", employeeId=" + employeeId + " ]";
    }
    
}
