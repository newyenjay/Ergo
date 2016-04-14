/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Privilege;
import javax.persistence.EntityManager;

/**
 * 
 * The repository unit that handles the privilege table in the database. This simply uses the joint table in the database and checks whether or not a user in the
 * database is an administrator.
 * 
 */
public class PrivilegeRepository {
    
    /**
     * Takes in a Employee id from the database, and returns the privilege level of that employee. Either being a administrator or a user of the program. Will return an
     * exception if there is any problems while executing the script. 
     * 
     * @param id - must be a valid int variable, and must be a valid id of an employee in the database. 
     * @return - a Privilege object that depicts the level of privilege that that user has, either being an administrator, or a user.
     */
    public Privilege getId(int id){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Privilege privilege = em.find(Privilege.class, id); 
            return privilege;
        } finally {
            em.close();    
        }
    }
    
}
