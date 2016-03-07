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
 *
 * @author Kimberly Oshiro
 */
public class AccessoryService {
    AccessoryRepository ar;
    
    /**
     * 
     * @param accessoryId
     * @return
     * @throws Exception 
     */
    public Accessory getLocation(int accessoryId)throws Exception{
        ar = new AccessoryRepository();
        return ar.getAccessory(accessoryId);
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public List<Accessory> getAll()throws Exception{
        ar = new AccessoryRepository();
        return ar.getAll();
    } 
}
