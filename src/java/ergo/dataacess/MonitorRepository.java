/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Monitor;
import ergo.domainmodel.Pwae;
import javax.persistence.EntityManager;

/**
 *
 * @author Kimberly Oshiro
 */
public class MonitorRepository {
    
    
    public int insert(Monitor monitor) throws Exception  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Pwae pwae =monitor.getPwaeId();
            pwae.getMonitorList().add(monitor);
            
            em.getTransaction().begin();
            em.merge(pwae);
            em.persist(em.merge(monitor));
            em.getTransaction().commit();
            return 1;
            
        } finally {
            em.close();
        }
    }
    
    public int update(Monitor monitor)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(monitor);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    
    }
}
