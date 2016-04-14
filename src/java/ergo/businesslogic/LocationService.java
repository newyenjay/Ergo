package ergo.businesslogic;

import ergo.dataacess.DBUtil;
import ergo.dataacess.LocationRepository;
import ergo.domainmodel.Company;
import ergo.domainmodel.Location;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Service to update the entire location table
 * 
 */
public class LocationService {

    LocationRepository lr;

    /**
     * Method to return the location of a company
     * 
     * @param locationId
     * @return
     * @throws Exception
     */
    public Location getLocation(int locationId) throws Exception {
        lr = new LocationRepository();
        return lr.getLocation(locationId);
    }

    /**
     * Method to insert into the location table, a company id, and the address of
     * the company
     * 
     * @param companyId 
     * @param address
     * @return
     * @throws Exception 
     */
    public int insert(Company companyId, String address) throws Exception {
        lr = new LocationRepository();
        Location location = new Location();
        location.setAddress(address);
        location.setCompanyId(companyId);
        return lr.insert(location);
    }

    /**
     * Method to help update the company name or address in the location table
     * 
     * @param locationId
     * @param address
     * @return
     * @throws Exception
     */
    public int update(int locationId, String address) throws Exception {
        lr = new LocationRepository();
        Location location = lr.getLocation(locationId);
        location.setAddress(address);
        return lr.update(location);
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
