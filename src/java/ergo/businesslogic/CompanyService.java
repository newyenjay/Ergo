/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.CompanyRepository;
import ergo.domainmodel.Company;
import java.util.List;


public class CompanyService {
    CompanyRepository cr;
    
    /**
     * 
     * 
     * @param name
     * @return
     * @throws Exception 
     */
    public int insert(String name)throws Exception{
        cr = new CompanyRepository();
        Company company = new Company();
        company.setName(name);
        cr.insert(company);
        return company.getCompanyId();
    }
    
    /**
     * 
     * @param companyId
     * @param name
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
     * 
     * @param companyId
     * @return
     * @throws Exception 
     */
    public Company getCompany(Integer companyId)throws Exception{
        cr = new CompanyRepository();
        return cr.getCompany(companyId);
    }
    
    public Company getCompany(String compName)throws Exception{
        cr = new CompanyRepository();
        return cr.getCompany(compName);
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
