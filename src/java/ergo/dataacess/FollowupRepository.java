/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Followup;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *Handles the Followup table database interaction, a table out of many that makes the program run. 
 * 
 * @author Kimberly Oshiro
 */
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
     * Returns all the available valid Followup objects contained within a java.util.List. If something goes wrong during the execution of this sql query, the 
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
     * Takes a Followup object bean as parameters, and inserts it into the database. Will return a 1 if the insertion is a success, otherwise will throw an exception,
     * or will return a null. 
     * 
     * Pre - At least one instance variable cannot be null in the inserted object, as the newly inserted object cannot have all null columns. 
     * Post - The newly created variable will have a row in the database, and will exist in the database until the database is dropped or the row is deleted. 
     * 
     * @param followup - the Followup object that will be inserted into the Followup table, it contains all the values that will populate the row columns. 
     * @return - either a 1, or an exception depending on if the insertion into the database is a success. 
     */
    public int insert(Followup followup)throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(followup);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    /**
     * Deletes a referenced Followup object from the database. The followup object has to exist in the database before trying to delete it, otherwise the deletion will not
     * work. 
     * 
     * Pre - The object to be deleted must exist in the database prior to running this method, otherwise the method will not run successfully. 
     * Post - the Row will be deleted from the database, and there will be no remaining reference of this row. 
     * 
     * @param followup - the Object that the database will use to reference to delete the row from the database. Contains identifying factors from the rest of the database. 
     * @return - A 1 if the deletion from the database is a success. Otherwise, will return a null if there is any errors thrown from the database along the way. 
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
     * Takes a parameter Followup object, and notes any changes between the database Object, and updates the two. Essentially allows the Object to modify the database without having
     * to delete and recreate the object entirely. 
     * Pre - the Object has to exist in the database beforehand.
     * Post - if all goes well, the object will be updated in the database and no errors will be thrown. 
     * 
     * @param followup - The object that the database will use to update the row in the database. 
     * @return - A 1 if the update is a success, otherwise the method will throw an exception, or a null value. 
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
