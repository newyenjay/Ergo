/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Location;
import javax.persistence.EntityManager;

/**
 *
 * @author Kimberly Oshiro
 * 
 * @version 1.0 - Setting up the LocationRepository before heading off. 
 */
public class LocationRepository {
    
    /**
     * 
     * @param location
     * @return 
     */
    public int insert(Location location)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(location);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param location
     * @return 
     */
    public int delete(Location location)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(location));
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
   }
    
    /**
     * 
     * @param location
     * @return 
     */
    public int update(Location location) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(location);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    /**
     * 
     * @param locationId
     * @return 
     */
    public Location getLocation(String locationId)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Location location = em.find(Location.class, locationId); 
            return location;
        } finally {
            em.close();    
        }
    }
    //getbyemail
    
    
}
