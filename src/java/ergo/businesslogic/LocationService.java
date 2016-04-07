/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.DBUtil;
import ergo.dataacess.LocationRepository;
import ergo.domainmodel.Company;
import ergo.domainmodel.Location;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Kimberly Oshiro
 * @version 1.0 added everything pretty much, will be adding documentation
 * shortly. 01/03/2016
 * @version 1.1 Adding documentation not really shortly, but now. 04/05/2016
 *         There was some alterations made to the insertion method on an unknown date - I'm unable to locate it amongst the github changes. It will remain anonymous for now. 
 * 
 */
public class LocationService {

    LocationRepository lr;

    /**
     *Returns a Location object that references a Location row from the database that was found using the integer parameter. Will return a null pointer if 
     * there is any issues while executing this method, also will throw an exception if there is any issues. 
     * Pre - The location must exist in the database prior to this method call. 
     * 
     * @param locationId - the referential key that is used to locate the information for the Location object. 
     * @return - the Location object, or a null pointer.
     * @throws Exception - if there is any issues while attempting to locate the object in the database. 
     */
    public Location getLocation(int locationId) throws Exception {
        lr = new LocationRepository();
        return lr.getLocation(locationId);
    }

    /**
     * The method will take the parameters and create a new Location object within the method, and insert it to the database. If any issues arise while inserting
     * to the database, the method will return a null pointer while throwing an exception. 
     * Pre - The object does not exist in the database.
     * Pos - The object now exists in the database with a new LocationId. 
     * 
     * @param companyId - A variable that is stored in the Database with the Location. 
     * @param address -  A variable that is stored in the database with the Location. 
     * @return - A newly created Location object from the database that has all fields filled in, or a null pointer because an exception was thrown. 
     * @throws Exception - If there is any errors that occur during insertion, the method will throw an exception. 
     */
    public int insert(Company companyId, String address) throws Exception {
        lr = new LocationRepository();
        Location location = new Location();
        location.setAddress(address);
        location.setCompanyId(companyId);
        return lr.insert(location);
    }

    /**
     *By submitting a new valid Location object, the method can update a row in the database with new information. Will return a 1 if the update is a success, otherwise
     * will throw an exception, and will return a null pointer if there is an error during the update. 
     * Pre - The referenced row in the database must exist prior to this method call. 
     * Post - The referenced row will be changed in the update. 
     * 
     * @param locationId - The referenced Location to be updated in the database, note that the Location in the database must already exist. 
     * @param address - The address that is going to be replacing the current address in the database. 
     * @return - A 1 if the update is a  success, or a null pointer if an error occurrs while attempting to update the row. 
     * @throws Exception - Only thrown if the database encounters an error while attempting to update the row. 
     */
    public int update(int locationId, String address) throws Exception {
        lr = new LocationRepository();
        Location location = lr.getLocation(locationId);
        location.setAddress(address);
        return lr.update(location);
    }

    /**
     *Removes a referenced Row from the database permanently. 
     * Pre - The row exists in the database and actions can be performed upon it.
     * Pos - The row is no longer in the database, and it cannot be found by searching specifically for that row. 
     * 
     * @param locationId - The integer that the database uses to search for the Location and delete it. 
     * @return - A 1 if the deletion is a success, a null pointer if there is an error during deletion. 
     * @throws Exception - If there is an error the method will throw an exception. 
     */
    public int delete(int locationId) throws Exception {
        lr = new LocationRepository();
        Location location = lr.getLocation(locationId);
        return lr.delete(location);
    }

    /**
     *Returns a java.util.List that contains all the Locations within the database. 
     * Pre - there must be at least one Location within the database at the time. 
     * 
     * @return a java.util.List that has all the Locations in the database, or a null pointer if there is an error during execution. 
     * @throws Exception - If there is an error during execution, the database will throw the exception. 
     */
    public List<Location> getAll() throws Exception {
        lr = new LocationRepository();
        return lr.getAll();
    }

}
