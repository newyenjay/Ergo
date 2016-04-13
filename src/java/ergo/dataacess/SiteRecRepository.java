/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Pwae;
import ergo.domainmodel.SiteRec;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author waynelin
 */
public class SiteRecRepository {
    
    public int insert(SiteRec siteRec) throws Exception  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {       
            Pwae pwae =siteRec.getPwaeIdsite();
            pwae.getSiteRecList().add(siteRec);

            em.getTransaction().begin();
            em.merge(pwae);
            em.persist(em.merge(siteRec));
            em.getTransaction().commit();
            return 1;
            
        } finally {
            em.close();
        }
    }
    
     public int update(SiteRec siteRec)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(siteRec);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
     
     
}
