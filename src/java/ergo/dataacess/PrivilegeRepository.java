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
 * 
 * 
 * @author Kimberly Oshiro
 */
public class PrivilegeRepository {
    
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
