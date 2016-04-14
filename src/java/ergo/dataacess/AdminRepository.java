    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Admin;
import java.util.List;
import javax.persistence.EntityManager;

public class AdminRepository {

    /**
     * Method to insert into the admin table 
     * 
     * @param admin
     * @return 
     */
    public int insert(Admin admin) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(admin);
            em.getTransaction().commit();
            return admin.getAdminId();
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to update the admin table
     * 
     * @param admin
     * @return 
     */
    public int update(Admin admin) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(admin);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }

    /**
     * Method to return all admins information by retrieving each row by
     * the unique id assigned to each admin insert. 
     * @return 
     */
    public List<Admin> getAll() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Admin> admin = em.createNamedQuery("Admin.findAll", Admin.class)
                    .getResultList();
            return admin;
        } finally {
            em.close();
        }
    }

    public Admin getAdminId(int adminId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Admin a = em.createNamedQuery("Admin.findByAdminId", Admin.class)
                    .setParameter("adminId", adminId).getSingleResult();
            return a;
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to get a single assessment 
     * @param aId
     * @return 
     */
    public Admin getAssessmentId(int aId){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Admin a = em.createNamedQuery("Admin.findByAssessmentId", Admin.class)
                    .setParameter("aId", aId).getSingleResult();
            return a;
        } finally {
            em.close();
        }
    }

}
