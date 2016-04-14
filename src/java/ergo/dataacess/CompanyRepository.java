/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Company;
import java.util.List;
import javax.persistence.EntityManager;


public class CompanyRepository {
    
    
    /**
     * Method to update the company table using a DBUtility
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
     * Method to insert a company into the database using hte DBUtility
     * 
     * @param company
     * @return 
     */
    public int insert(Company company)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(company);
            em.getTransaction().commit();
            return company.getCompanyId();
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to delete a company using the DBUtility
     * @param company
     * @return 
     */
    public int delete(Company company)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(company));
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
   }
    
    /**
     * Method to get a company by giving it a unique company. Uses DBUtility
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
     * Method to return a company. Uses the DBUtility to get a company
     * @param compName
     * @return 
     */
    public Company getCompany(String compName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Company company = em.find(Company.class,compName);
            return company;
        } finally {
            em.close();
        }
    }
    /**
     * Method to return a list of companies 
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
