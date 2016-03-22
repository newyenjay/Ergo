/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.DBUtil;
import ergo.dataacess.LocationRepository;
import ergo.domainmodel.Location;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Kimberly Oshiro
 * @version 1.0 added everything pretty much, will be adding documentation shortly. 01/03/2016
 */
public class LocationService {
    LocationRepository lr;
    
    /**
     * 
     * @param locationId
     * @return
     * @throws Exception 
     */
    public Location getLocation(int locationId)throws Exception{
        lr = new LocationRepository();
        return lr.getLocation(locationId);
    }
    
    
    /**
     * 
     * @param locationId
     * @param address
     * @return
     * @throws Exception 
     */
   // public int insert(Integer locationId, String address)throws Exception{
   //     lr = new LocationRepository();
        //Location location = new Location(locationId, address);
   //     return lr.insert(location);
  //  }    
    
    /**
     * 
     * @param locationId
     * @param address
     * @return
     * @throws Exception 
     */
    public int update(int locationId, String address)throws Exception{
        lr = new LocationRepository();
        Location location = lr.getLocation(locationId);
        location.setAddress(address);
        return lr.update(location);
    }

    
    /**
     * 
     * @param locationId
     * @return
     * @throws Exception 
     */
    public int delete(int locationId)throws Exception{
        lr = new LocationRepository();
        Location location = lr.getLocation(locationId);
        return lr.delete(location);
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public List<Location> getAll()throws Exception{
        lr = new LocationRepository();
        return lr.getAll();
    } 
    
}
