
package ergo.businesslogic;

import ergo.dataacess.CompanyRepository;
import ergo.domainmodel.Company;
import java.util.List;

/**
 * Service to update the company table in the database.  
 */
public class CompanyService {
    CompanyRepository cr;
    
    /**
     * Inserting a new company into the database
     * 
     * @param name name of company
     * @return
     * @throws Exception 
     */
    public int insert(String name)throws Exception{
        cr = new CompanyRepository();
        Company company = new Company();
        company.setName(name);
        return cr.insert(company);
    }
    
    /**
     * Method to update a company
     * 
     * @param companyId each company has a unique id
     * @param name of company
     * @return
     * @throws Exception 
     */
    public int update(Integer companyId, String name)throws Exception{
        cr = new CompanyRepository();
        Company company = cr.getCompany(companyId);
        company.setName(name); //Was previously commented out. 
        return cr.update(company);
    }
    
    
    /**
     * Method to delete a company if needed
     * 
     * @param companyId - The parameter that is used to identify the row to be deleted.
     * @return - a 1 if the deletion is a success, and a null pointer if an error is thrown during deletion.  
     * @throws Exception - Thrown during the deletion if there's any errors during the deletion. 
     */
    public int delete(Integer companyId)throws Exception{
        cr = new CompanyRepository();
        Company company = cr.getCompany(companyId);
        return cr.delete(company);
    }
    
    /**
     * Method to help get the name of a company
     * This method uses it by having a parameter of a company id 
     * 
     * @param companyId - The Integer reference in which the database uses to search. 
     * @return - Either a Company object, or a null pointer when the database runs into an error while executing the method. 
     * @throws Exception - Thrown if the database runs into any difficulties while trying to run the method. 
     */
    public Company getCompany(Integer companyId)throws Exception{
        cr = new CompanyRepository();
        return cr.getCompany(companyId);
    }
    
    /**
     * Method to return a company by giving it a parameter String of company name
     * @param compName
     * @return
     * @throws Exception 
     */
    public Company getCompany(String compName)throws Exception{
        cr = new CompanyRepository();
        return cr.getCompany(compName);
    }
    
    /**
     * Method to return all companies in a list 
     * 
     * @return -  A list of all of the Company Objects in the database, or a null pointer if the database runs into an error while running the method.
     * @throws Exception - Thrown if anything goes wrong during the execution of the method. 
     */
    public List<Company> getAll()throws Exception{
        cr = new CompanyRepository();
        return cr.getAll();
    } 
    
    
}
