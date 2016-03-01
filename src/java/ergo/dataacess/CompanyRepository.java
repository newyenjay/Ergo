/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Company;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Kimberly Oshiro
 */
public class CompanyRepository {
    
    
    /**
     * 
     * @param company
     * @return 
     */
    public int update(Company company) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(company);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param companyId
     * @return 
     */
    public Company getCompany(Integer companyId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Company company = em.find(Company.class,companyId);
            return company;
        } finally {
            em.close();
        }
    }
    
    
    /**
     * 
     * @return 
     */
    public List<Company> getAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Company> companies = em.createNamedQuery("Company.findAll", Company.class).getResultList();
            return companies;
        } finally {
            em.close();    
        }
    }
    
}
