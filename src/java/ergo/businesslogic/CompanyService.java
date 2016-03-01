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
 */
public class CompanyService {
    CompanyRepository cr;
    //insert
    //update
    //delete
    
    /**
     * 
     * @param companyId
     * @return
     * @throws Exception 
     */
    public Company getEmployee(Integer companyId)throws Exception{
        cr = new CompanyRepository();
        return cr.getCompany(companyId);
    }
    
    /**
     * 
     * @return
     * @throws Exception 
     */
    public List<Company> getAll()throws Exception{
        cr = new CompanyRepository();
        return cr.getAll();
    } 
    
    
}
