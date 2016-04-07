/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.AccessoryRepository;
import ergo.domainmodel.Accessory;
import java.util.List;

/**
 *Accessory Service. Will retrieve information from the Accessory Database. 
 * 
 * there is no plans to be able to insert things. 
 * 
 * @version 1.0 code implemented, as well as javadoc. 
 * 
 * @author Kimberly Oshiro
 */
public class AccessoryService {
    AccessoryRepository ar;
    
    /**
     * Returns an Accessory object based on the accessoryId. If there is no Accessory Object in the database, then the database will throw an exception. 
     * 
     * @param accessoryId - The id in which the Database will use to search for the object. Must be a valid integer, and must be a positive integer. 
     * @return an Accessory object that has all its fields filled from a row in the database. 
     * @throws Exception - If the database throws an error, the Java error will be translated to that of an exception to something that is valid in Java. 
     */
    public Accessory getLocation(int accessoryId)throws Exception{
        ar = new AccessoryRepository();
        return ar.getAccessory(accessoryId);
    }
    
    /**
     * Returns a java.util.list that contains all Accessory Objects in the database. 
     * pre - there is at least one Accessory row in the database.
     * 
     * @return - A java.util.List that contains all Accessory Objects in the database, or a null pointer if the database runs into an error while executing the method.
     * @throws Exception - Thrown if anything goes wrong during the execution of the method. 
     */
    public List<Accessory> getAll()throws Exception{
        ar = new AccessoryRepository();
        return ar.getAll();
    } 
}
