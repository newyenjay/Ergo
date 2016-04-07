/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.CompanyRepository;
import ergo.domainmodel.Company;
import java.util.List;

/**
 *
 * @author Kimberly Oshiro
 * @version  1.0 - Got the basic methods down, will be doing the documentation in the next sitting. 01/03/2016 
 * @version 1.1 - I mean, this is technically the next sitting or something. The documentation is now getting done in this version. 06/04/2016
 */
public class CompanyService {
    CompanyRepository cr;
    
    /**
     * The method will take in parameters, and will insert the values into the database as a row. If there is any errors during insertion, the database will return a null pointer
     * exception, otherwise will return a 1. 
     * Pre - there is no row in the database that exists that has exact values to that of the one being inserted. 
     * Post - The new values now exist in the database, and it will have the highest id out of any of the most recently added values. 
     * 
     * @param name - a variable that is used during insertion, will be saved to the database. 
     * @return - a 1 if the insertion to the database is a success, otherwise will return a null pointer. 
     * @throws Exception - Thrown if anything goes wrong during the execution of the method. 
     */
    public int insert(String name)throws Exception{
        cr = new CompanyRepository();
        Company company = new Company();
        company.setName(name);
        return cr.insert(company);
    }
    
    /**
     * Takes in a the values that would create a new row in the database, and sets those values on a currently existing row in the database, updating its values. 
     * Pre - The referenced row in the database must exist, prior to the method being called. 
     * Post - value is now altered. 
     * 
     * @param companyId - a variable that is used during updating the row, may be different from the current value. will be saved to the database. 
     * @param name - a variable that is used during updating, may be different from the current value. will be saved to the database. 
     * @return -  a 1 if the update is a success, otherwise will return a null pointer. 
     * @throws Exception - Thrown if there's anything that goes wrong during the row update. 
     */
    public int update(Integer companyId, String name)throws Exception{
        cr = new CompanyRepository();
        Company company = cr.getCompany(companyId);
        company.setName(name); //Was previously commented out. 
        return cr.update(company);
    }
    
    
    /**
     * Takes a parameter and then deletes the referenced row from the table.
     * Pre - the Company row exists in the table.
     * Post - the Company row no longer exists in the table. 
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
     * Returns a company Object based on the Integer value sent in the parameter. 
     * Pre - The called Company exists in the database.  
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
     * Returns a Company Object based on the String value sent in the parameter. 
     * Pre - The called Company exists in the database. 
     * 
     * @param compName - The String reference in which the database uses to search. 
     * @return - Either a Company object, or a null pointer when the database runs into an error while execute the method. 
     * @throws Exception - Thrown if anything goes wrong during the execution of the method. 
     */
    public Company getCompany(String compName)throws Exception{
        cr = new CompanyRepository();
        return cr.getCompany(compName);
    }
    
    /**
     * Returns a java.util.List that contains all of the Company rows in the database. 
     * pre - there is at least one Company row in the database. 
     * 
     * @return -  A list of all of the Company Objects in the database, or a null pointer if the database runs into an error while running the method.
     * @throws Exception - Thrown if anything goes wrong during the execution of the method. 
     */
    public List<Company> getAll()throws Exception{
        cr = new CompanyRepository();
        return cr.getAll();
    } 
    
    
}
