/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import java.util.List;
import javax.persistence.EntityManager;
import ergo.domainmodel.Employee;
/**
 *
 * @author Kimberly Oshiro
 * 
 * @version 1.0 - Changed the name from EmployeeDB to EmployeeRepository. Was decided that it was better for the operation for this to be named this way. 
 */
public class EmployeeRepository {
      //getUser
    public Employee getUser(String userName)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Employee employee = em.find(Employee.class, userName); //this will need to be fixed because the variable type might not be exactly the same. 3
            return employee;
        } finally {
            em.close();    
        }
    }
    
    //update
    public int update(Employee employee) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(employee);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    //getAll
    public List<Employee> getAll()  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Employee> employee = em.createNamedQuery("Employee.findAll", Employee.class).
                    getResultList();
            return employee;
        } finally {
            em.close();    
        }
    }
    
    //delete
    public int delete(Employee employee)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(employee));
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
   }
    
    //insert 
    public int insert(Employee employee)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
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
            Employee employee = em.createNamedQuery("Employee.findByEmail", Employee.class).setParameter("email", email).getSingleResult();
            return employee;
        } finally {
            em.close();    
        } 
    }
    //I can't think of anything else here. 
}
