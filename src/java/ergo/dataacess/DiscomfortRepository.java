/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Discomfort;
import javax.persistence.EntityManager;

/**
 *
 * @author Kimberly Oshiro
 * 
 * @version 1.0 - Created the class and added the insertion, and getDiscomfort method,
 *                  will add more as time goes if there's any need to. 
 * @version 1.1 - Adding documentation. 
 */
public class DiscomfortRepository {
    
    /**
     * Takes a newly created Discomfort Object and inserts it into the database. Requires a valid Discomfort object.
     * Pre - The Discomfort Object that is being inserted must have at least one field filled in- One of these fields being one of the text fields.
     * Post - The Discomfort object is successfully inserted into the database as a row, and the values in the instance variable values are saved as columns. 
     * 
     * @param discomfort - the Discomfort object that will be inserted into the database. Must be a valid Discomfort object. 
     * @return - a 1 if the insertion is successful, in some cases it can be a null that the method will return if the insertion is a failure.  
     * @throws Exception - if the insertion for some reason is not successful, the database will throw an exception that is something that only pertains to SQL's API.
     * Get good at reading at SQL API error messages. 
     */
    public int insert(Discomfort discomfort)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(discomfort);
            em.getTransaction().commit();
            return 1; //I don't think this is needed. 
        } finally {
            em.close();
        }
    }
    
    /**
     * Returns a discomfort Object based on the Discomfort Identification. The Object will be a valid Discomfort object. 
     * Pre - the object must exist in the database prior to calling this method. 
     * post - the row in the database will also exist as an object. 
     * 
     * @param discomfortId - The identifying factor that allows the database to search for the row in the database. Must be an Integer, 
     * @return - a Discomfort Object that is a representation of that row in the database, or a null pointer exception.  
     * @throws Exception - If anything goes wrong while attempting to execute the predetermined SQL queries, the method will throw an exception. 
     */
    public Discomfort getDiscomfort(Integer discomfortId)throws Exception{
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Discomfort discomfort = em.find(Discomfort.class,discomfortId);
            return discomfort;
        } finally {
            em.close();
        }
    }
    
}
