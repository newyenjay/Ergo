/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Pwae;
import javax.persistence.EntityManager;

/**
 *
 * @author waynelin
 */
public class PwaeRepository {
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
    
     public Pwae getPwae(Integer pwaeId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Pwae pwae = em.find(Pwae.class,pwaeId);
            return pwae;
        } finally {
            em.close();
        }
    }
    
}
