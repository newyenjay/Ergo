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
public class ClientCompanyPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "companyId")
    private int companyId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientId")
    private int clientId;

    public ClientCompanyPK() {
    }

    public ClientCompanyPK(int companyId, int clientId) {
        this.companyId = companyId;
        this.clientId = clientId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) companyId;
        hash += (int) clientId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientCompanyPK)) {
            return false;
        }
        ClientCompanyPK other = (ClientCompanyPK) object;
        if (this.companyId != other.companyId) {
            return false;
        }
        if (this.clientId != other.clientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.ClientCompanyPK[ companyId=" + companyId + ", clientId=" + clientId + " ]";
    }
    
}
