/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Discomfort;
import javax.persistence.EntityManager;

/**
 * Repository to help insert and update using the DBUtility
 */
public class DiscomfortRepository {
    
    /**
     * Method to insert into the database using the DBUtility 
     * @param discomfort
     * @return
     * @throws Exception 
     */
    public int insert(Discomfort discomfort)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(discomfort);
            em.getTransaction().commit();
            return discomfort.getDiscomfortId(); 
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to update the discomfort table using the DBUtility
     * @param discomfort
     * @return
     * @throws Exception 
     */
    public int update(Discomfort discomfort)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(discomfort);
            em.getTransaction().commit();
            return discomfort.getDiscomfortId(); 
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to retrieve from the database using the DBUtility
     * @param discomfortId
     * @return
     * @throws Exception 
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
