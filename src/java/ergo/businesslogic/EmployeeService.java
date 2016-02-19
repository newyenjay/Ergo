/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.EmployeeRepository;
import ergo.domainmodel.Employee;
import java.util.List;
/**
 *
 * @author Kimberly Oshiro
 * 
 * @version 1.0 - Create the base workings of the class. Most likely will need to create some more methods later on to compensate for new methods and such that will come up
 * later on in the process. Will add more after the completion of the code. 
 */
public class EmployeeService {
    private EmployeeRepository er;
    
    /**
     * Handles the Insertion of a newly created Employee object into the database, is the interface between the Database and the Backend of the database. Will throw an exception if the 
     * database throws an error when attempting to insert into the database, otherwise a 1 is returned from the EmployeeRepository class. 
     * 
     * @param employee - Must be of type Employee in the ergo.domainmodel package, and must have all local variables filled in, otherwise the rows in the database will be empty. A check
     * must be made beforehand to check this out in order to do this. 
     * @return - a 1 if the insertion to the database is a success. 
     */
    public int insert(Employee employee)throws Exception{
        er = new EmployeeRepository();
        return er.insert(employee);
    }
    
    /**
     * Deletes the given parameter Employee object from the database. If the employee is successfully deleted from the database then the method called will return a 1, otherwise an error 
     * will be thrown from the database and eventually the method calling the database. 
     * 
     * @param employee - the Employee variable type that references the row that will be deleted from the database. 
     * @return - a 1 if the deletion from the database is a success, an exception if there is an error. 
     */
    public int delete(Employee employee)throws Exception{
        er = new EmployeeRepository();
        return er.delete(employee);
    }
    
    /**
     * Returns a list filled with all the Employees that are available in the database. 
     * @return - The list containing all the employees if the method call is successful. Otherwise, the method won't go through and there will be an exception thrown from the database. 
     */
    public List<Employee> getAll()throws Exception{
        er = new EmployeeRepository();
        return er.getAll();
    } 
    
    /**
     * Returns an Employee object from the database based on the Employee's username, if the username is in the database then the Row containing that employee will be returned. 
     * 
     * @param username - The Java.Lang.String object that will contain the username that the Database will use to search for the row. 
     * @return the Employee object if the Database finds the employee containing that Username, otherwise the method will return null if the database finds nothing. 
     */
    public Employee getEmployeeUsername(String username){
        er = new EmployeeRepository();
        return er.getUserUsername(username);
    }
    
    /**
     * Returns an Employee object from the database based on the Employee's email, if the email is in the database then the Row containing that Employee will be returned. 
     * @param email - The Java.Lang.String object that will contain the email that the Database will use to search for the row. 
     * @return - The Employee object if the Database finds the employee containing that Email, otherwise the method will return null. 
     */
    public Employee getEmployeeEmail(String email){
        er = new EmployeeRepository();
        return er.getUserEmail(email);
    }
    
    
}
