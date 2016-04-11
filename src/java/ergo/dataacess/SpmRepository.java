/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Spm;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 671402
 */
public class SpmRepository {
    /**
     * Searches through the client table in the database for a client based on their clientId, and will return a Client object from the database that is created from
     * the JPA query. 
     * 
     * @param clientId - the value that's given to the method that will search through the database that will search for the client based n the ID. 
     * @return a Client Object that is created from the database query that is searching for a client based on the clientID. 
     */
    public Spm getSpm(int spmId)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Spm spm = em.find(Spm.class, spmId); //this will need to be fixed because the variable type might not be exactly the same. 3
            return spm;
        } finally {
            em.close();    
        }
    }
    
    /**
     * Takes a Client object that is sent through from the ClientService, and updates the Client database row that correlates with it. 
     * 
     * @param client - the version of the Client Object that has information that is out of sync with the row in the database - the row in the database has to be
     * updated and the information must be persisted to the row. 
     * @return 1 if the update to the database is successful, if an error is thrown by the database, then there will be an error returned by the database,
     * and the methods further up will be notified, and 1 will not be returned. 
     */
    public int update(Spm spm) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(spm);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    /**
     * Returns an ArrayList of all the clients in the database. 
     * @return - the ArrayList of the Client objects in the database. 
     */
    public List<Spm> getAll()  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Spm> spms = em.createNamedQuery("Spm.findAll", Spm.class).
                    getResultList();
            return spms;
        } finally {
            em.close();    
        }
    }
    
     /**
     * Returns an ArrayList of all the clients in the database. 
     * @return - the ArrayList of the Client objects in the database. 
     */
    public List<Spm> getAllByCompanyList()  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Spm> spms = em.createNamedQuery("Spm.findAll", Spm.class).
                    getResultList();
            return spms;
        } finally {
            em.close();    
        }
    }
    
    /**
     * Deletes a Client object from the database by referencing a client object. 
     * @param client - the object itself that should be deleted. 
     * @return - a 1 if the deletion from the database is successful, if an error is thrown from the database, the method leaves the try 
     * and goes into the finally, and does not return a 1. 
     */
    public int delete(Spm spm)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(spm));
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
   }
    
    /**
     * Inserts a new Client object to the database by taking the parameter Client object and using the instance variables and inserting them into the rows.
     * @param client - the object that will be referenced when inserting into the row. 
     * @return - a 1 if successful, if unsuccessful, nothing because the database will exit the try and will go into the finally clause and will return nothing. 
     */
    public int insert(Spm spm) throws Exception  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(spm);
            em.getTransaction().commit();
            return spm.getSpmId();
        } finally {
            em.close();
        }
    }
}
