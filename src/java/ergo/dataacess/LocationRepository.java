/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Location;
import java.util.List;
import javax.persistence.EntityManager;

public class LocationRepository {
    
    /**
     * 
     * Metod to insert into the database using the DButiltiy 
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
     * Method to update a location using the DBUtility 
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
     * Method to return the location of a company using the DBUtility
     * @param locationId
     * @return 
     */
    public Location getLocation(int locationId)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Location location = em.find(Location.class, locationId); 
            return location;
        } finally {
            em.close();    
        }
    }
    
    /**
     * Method to return a list of all locations. Uses the DButility 
     * @return 
     */
    public List<Location> getAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Location> locations = em.createNamedQuery("Location.findAll", Location.class).getResultList();
            return locations;
        } finally {
            em.close();    
        }
    }
    
   
    
    
}
