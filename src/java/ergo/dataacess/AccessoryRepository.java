/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Accessory;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * The accessory Repository that handles the interfacing between the Program and the Database. 
 * 
 * This class will most likely only contain getters, not setters, unless the company wishes to insert new accessories. However. We are going to work under the assumption that
 * ErgoRisk is not under the need of having to insert new Accessories into the accessory table!
 * 
 * Currently these are the only two ways that the Accessory object can return the objects from the database, so if you want to do any other forms of listing, you will have to
 * handle the objects yourself in the Servlet. 
 *
 * @version 1.0 - implemented all methods
 * @version 1.1 - implemented javdoc
 * 
 * @author Kimberly Oshiro
 */
public class AccessoryRepository {
    
    /**
     * Returns a Accessory object with the specified AccessoryID that is given within the Parameters. If anything goes wrong while executing this SQL script, the 
     * method will return a null pointer.
     * 
     * @param accessoryId - The id that the database uses to find the specified Accessory object from the database and return it. 
     * @return - A newly created Accessory Object if the method executes correctly, otherwise a nullpointer. 
     */
    public Accessory getAccessory(int accessoryId)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Accessory accessory = em.find(Accessory.class, accessoryId); 
            return accessory;
        } finally {
            em.close();    
        }
    }
    
    
    /**
     * When this method is called, will return a java.util.List Object containing all the Accessories in the database. If anything happens to go wrong during this time, 
     * the method will throw an exception and will return a nullpointer. 
     * Pre - there mulst be at least one Accessory Object within the Database.
     * Pos - All the Accessory objects are returned within a list., 
     * @return 
     */
    public List<Accessory> getAll(){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Accessory> accessories = em.createNamedQuery("Accessory.findAll", Accessory.class).getResultList();
            return accessories;
        } finally {
            em.close();    
        }
    }
    
}
