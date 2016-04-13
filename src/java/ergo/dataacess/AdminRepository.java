    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Admin;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author 680420
 */
public class AdminRepository {

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
