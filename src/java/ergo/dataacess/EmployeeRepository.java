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
 * @version 1.1 - Added Documentation 
 */
public class EmployeeRepository {
    
    /**
     * This method will continue to check on whether or not the Employee with the username is in the database. Will return the employee if the employee is 
     * in the database, or will return nothing if the employee with the username does not exist in the database. 
     * 
     * @param username The parameter that will be sent to the database, and that will find the corresponding row to the username if it exists. 
     * @return the employee object if it exists in the database, returns nothing if the row does not exist.
     */
    public Employee getUserUsername(String username)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Employee employee = em.find(Employee.class, username); //this will need to be fixed because the variable type might not be exactly the same. 3
            return employee;
        } finally {
            em.close();    
        }
    }
    
    
    /**
     * Updates the row in the database with the selected employee. If the update is a success then it returns a 1, otherwise it returns nothing. 
     * 
     * @param employee the employee object that will be used to update a specific row in the database. 
     * @return a 1 if there is a successful update, if it isn't a success, then it will return nothing. 
     */
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
    
    public Employee getEmployee(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Employee emp = em.createNamedQuery("Employee.findByUsername", Employee.class).setParameter("username", username).getSingleResult();
            //Employee emp = em.find(Employee.class,username);
            return emp;
        } finally {
            em.close();
        }
    }
    
    /**
     * Returns the entire list of Employee objects in the database stored in a List interface. 
     * 
     * @return a list object that stores all of the Employee objects that are in the database. 
     */
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
    
    /**
     * Deletes a employee from the database by using the parameter object as a reference to delete with. Will throw an error and not return anything if an exception is
     * thrown, if the deletion is successful, then the row in the database will be deleted. 
     * 
     * @param employee - The object that is being used as a reference that will delete a row from the database. 
     * @return - A 1 if the program actually manages to run this method and it deletes the row 
     */
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
    
    /**
     * Inserts a newly created Employee object into the database, the database will insert the object into the database and will return a 1 if the insertion was 
     * a success, otherwise an error will be thrown by the database. 
     * 
     * @param employee - The employee object, that will be be used to be inserted into the database. 
     * @return - a 1 if the insertion is a success, nothing if the insertion causes the database to throw an error. 
     */ 
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
    
    /**
     * Makes the database return a Employee based on the String parameter given to the method, will return a employee based on the email, will return a null if the employee
     * does not exist. 
     * 
     * @param email - must be a valid email, but this email will make the database return a Employee object. 
     * @return the employee object if it exists in the database. 
     */ 
    public Employee getUserEmail(String email)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Employee employee = em.createNamedQuery("Employee.findByEmail", Employee.class).setParameter("email", email).getSingleResult();
            return employee;
        } finally {
            em.close();    
        } 
    }
    //First name
    //Last Name
    //Phone Number
}
