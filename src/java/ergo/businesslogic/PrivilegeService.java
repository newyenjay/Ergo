/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.PrivilegeRepository;
import ergo.domainmodel.Privilege;

/**
 * This service helps identify the type of employee, whether regular or admin status
 * @author 680420
 */
public class PrivilegeService {
    PrivilegeRepository pr; //The local object that is instantiated so that it doesn't have to be re-instantiated every time
    
    /**
     * Takes the specified ClientId and returns the Privilege object of that Client. If the method runs successfully then the method will return a Privilege object,
     * otherwise the method will throw an exception and return a null pointer. 
     * Pre - the client must exist in the database prior to this method call. 
     * 
     * @param clientId - The clientid that is used to check the database for an existing row with that similar clientId.
     * @return - A Privilege Object that exists in that table. Or a null pointer exception if the method throws an error. 
     * @throws Exception - If the method throws an error during execution.  
     */
    public Privilege getUserId(int clientId)throws Exception{
        pr = new PrivilegeRepository();
        return pr.getId(clientId);
    }
    
}
