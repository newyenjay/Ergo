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
    PrivilegeRepository pr;
    
    public Privilege getUserId(int clientId)throws Exception{
        pr = new PrivilegeRepository();
        return pr.getId(clientId);
    }
    
}
