/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Followup;
import java.util.List;
import javax.persistence.EntityManager;

public class FollowupRepository {
 /**
     * Returns a Followup Object based on the FollowupId from the database. If the Object isn't there, the database will throw an error, and then close the database
     * connection, and finally print the stack trace to the console. 
     * 
     * @param followUpId - The integer in which the database will search for the Followup row for in the database. Must be a valid Integer, and must be a positive integer. 
     * @return - A Followup Object that is not within the Java API. Otherwise, it is an exception that the database throws and the exception that Oracle returns is something 
     * unique to the situation. It really depends on how Oracle reacts to the user. 
     */
    public Followup getFollowup(int followUpId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Followup followup = em.find(Followup.class, followUpId); 
            return followup;
        } finally {
            em.close();    
        }
    }
    
    /**
     * Returns all the available valid Followup objects contained withing a java.util.List. If something goes wrong during the execution of this sql query, the 
     * method will throw an exception and the consol and browser will display the corresponding message. 
     * 
     * @return A java.util.List containing all the Followup objects within the database. Otherwise there will be an exception thrown. 
     */
    public List<Followup> getAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Followup> followups = em.createNamedQuery("Followup.findAll", Followup.class).getResultList();
            return followups;
        } finally {
            em.close();    
        }
    }
    
    /**
     * 
     * @param followup
     * @return 
     */
    public int insert(Followup followup)throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(followup);
            em.getTransaction().commit();
            return followup.getFollowUpId();
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param followup
     * @return 
     */
    public int delete(Followup followup)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(followup));
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
   }
    
    /**
     * 
     * @param followup
     * @return 
     */
    public int update(Followup followup) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(followup);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    } 
}
