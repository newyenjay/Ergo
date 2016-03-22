/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Monitor;
import javax.persistence.EntityManager;

/**
 *
 * @author Kimberly Oshiro
 */
public class MonitorRepository {
    
    
    /**
     * 
     * @param monitorId
     * @return 
     */
    public Monitor getMonitor(int monitorId)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Monitor monitor = em.find(Monitor.class, monitorId); 
            return monitor;
        } finally {
            em.close();    
        }
    }
    
    
    
}
