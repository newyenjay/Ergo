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
@Table(name = "clientcompany")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientCompany.findAll", query = "SELECT c FROM ClientCompany c"),
    @NamedQuery(name = "ClientCompany.findByCompanyId", query = "SELECT c FROM ClientCompany c WHERE c.clientCompanyPK.companyId = :companyId"),
    @NamedQuery(name = "ClientCompany.findByClientId", query = "SELECT c FROM ClientCompany c WHERE c.clientCompanyPK.clientId = :clientId")})
public class ClientCompany implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientCompanyPK clientCompanyPK;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "clientCompany")
    private Client client;
    @JoinColumn(name = "companyId", referencedColumnName = "companyId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Company company;

    public ClientCompany() {
    }

    public ClientCompany(ClientCompanyPK clientCompanyPK) {
        this.clientCompanyPK = clientCompanyPK;
    }

    public ClientCompany(int companyId, int clientId) {
        this.clientCompanyPK = new ClientCompanyPK(companyId, clientId);
    }

    public ClientCompanyPK getClientCompanyPK() {
        return clientCompanyPK;
    }

    public void setClientCompanyPK(ClientCompanyPK clientCompanyPK) {
        this.clientCompanyPK = clientCompanyPK;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientCompanyPK != null ? clientCompanyPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientCompany)) {
            return false;
        }
        ClientCompany other = (ClientCompany) object;
        if ((this.clientCompanyPK == null && other.clientCompanyPK != null) || (this.clientCompanyPK != null && !this.clientCompanyPK.equals(other.clientCompanyPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.ClientCompany[ clientCompanyPK=" + clientCompanyPK + " ]";
    }
    
}
