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
 */
public class DiscomfortRepository {
    
    //insertion
    public int insert(Discomfort discomfort)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(discomfort);
            em.getTransaction().commit();
            return discomfort.getDiscomfortId(); //I don't think this is needed. 
        } finally {
            em.close();
        }
    }
    
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
