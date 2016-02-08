/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import java.util.List;
import javax.persistence.EntityManager;
/**
 *
 * @author Kimberly Oshiro
 */
/**public class ClientDB {
    
    //getUser
    public Object getUser(String userName)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Object user = em.find(Object.class, userName);
            return user;
        } finally {
            em.close();    
        }
    }
    
    //update
    public int update(Object user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    //getAll
    public List<Object> getAll()  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Object> users = em.createNamedQuery("User.findAll", Object.class).
                    getResultList();
            return users;
        } finally {
            em.close();    
        }
    }
    
    //delete
    public int delete(User user)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();s
            em.remove(em.merge(user));
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
   }
    
    //insert 
    public int insert(Object user)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    //getEmail
    public Object getUserEmail(String email)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Object user = em.createNamedQuery("User.findByEmail", Object.class).setParameter("email", email).getSingleResult();
            return user;
        } finally {
            em.close();    
        } 
    }
    //I can't think of anything else here. 
}
**/