/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Pwae;
import javax.persistence.EntityManager;


public class PwaeRepository {
    
    /**
     * Method to insert into the table using the DBUtility
     * @param pwae
     * @return 
     */
    public int insert(Pwae pwae)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pwae);
            em.getTransaction().commit();
            return pwae.getPwaeId();
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to retrieve from the database using DBUtility
     * @param pwaeId
     * @return 
     */
     public Pwae getPwae(Integer pwaeId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Pwae pwae = em.find(Pwae.class,pwaeId);
            return pwae;
        } finally {
            em.close();
        }
    }
    
     /**
      * Method to update using the DBUtility 
      * @param pwae
      * @return 
      */
     public int update(Pwae pwae){
         EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(pwae);
            em.getTransaction().commit();
            return pwae.getPwaeId();
        } finally {
            em.close();
        }
     }
}
