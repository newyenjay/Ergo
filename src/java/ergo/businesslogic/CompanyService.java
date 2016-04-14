
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
        //company.setName(name);
        return cr.update(company);
    }
    
    
    /**
     * Method to delete a company if needed
     * 
     * @param companyId
     * @return
     * @throws Exception 
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
     * @param companyId
     * @return
     * @throws Exception 
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
     * @return
     * @throws Exception 
     */
    public List<Company> getAll()throws Exception{
        cr = new CompanyRepository();
        return cr.getAll();
    } 
    
    
}
