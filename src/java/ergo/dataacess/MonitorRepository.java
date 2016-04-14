/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Monitor;
import ergo.domainmodel.Pwae;
import java.util.List;
import javax.persistence.EntityManager;


public class MonitorRepository {
    
    /**
     * MEthod to insert a monitor into the monitor table.
     * Uses the DBUtility 
     * @param monitor
     * @return
     * @throws Exception 
     */
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
    
    /**
     * Method to update the table, uses the DBUtility
     * @param monitor
     * @return
     * @throws Exception 
     */
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
    
    /**
     * Method to retrieve from the database using the DButility 
     * @param monitorId
     * @return 
     */
    public Monitor getMonitor(int monitorId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Monitor monitor = em.find(Monitor.class,monitorId);
            return monitor;
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to return a list of all the monitors by using the DButility 
     * @param pwae
     * @return
     * @throws Exception 
     */
    public List<Monitor> getMonitorByPwae(int pwae)  throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Monitor> monitors = em.createNamedQuery("Monitor.findByPwaeId", Monitor.class).setParameter("pwaeId", pwae).
                    getResultList();
            return monitors;
        } finally {
            em.close();    
        }
    }
   
}
