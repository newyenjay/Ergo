package ergo.businesslogic;

import ergo.dataacess.EmployeeRepository;
import ergo.domainmodel.Employee;
import ergo.domainmodel.Privilege;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Service to help insert, update and delete the employee table in the database 
 */
public class EmployeeService {
    private EmployeeRepository er;
    
    /**
     * Handles the Insertion of a newly created Employee object into the database, is the interface between the Database and the Backend of the database. Will throw an exception if the 
     * database throws an error when attempting to insert into the database, otherwise a 1 is returned from the EmployeeRepository class. 
     * Pre - The exact Employee will not exist in the database. 
     * Post - The Employee row will now exist in the database. 
     * 
     * @param username - a variable that is used during insertion, will be saved to the database. 
     * @param firstName - a variable that is used during insertion, will be saved to the database. 
     * @param lastName - a variable that is used during insertion, will be saved to the database. 
     * @param password - a variable that is used during insertion, will be saved to the database. 
     * @param email - a variable that is used during insertion, will be saved to the database. 
     * @return - a 1 if the insertion to the database is a success, otherwise will return a null pointer. 
     * @throws java.lang.Exception - Will be thrown if an error is thrown during insertion. 
     */
    public int insert(String username, String firstName, String lastName, String password, String email)throws Exception{
        er = new EmployeeRepository();
        PrivilegeService ps = new PrivilegeService();
        Employee employee = new Employee(username, firstName, lastName, password, email);
        Privilege privilege = ps.getUserId(0);
        //employee.setPrivilegeId(privilege);
        return er.insert(employee);
    }
    
    /**
     * Deletes the given parameter Employee object from the database. If the employee is successfully deleted from the database then the method called will return a 1, otherwise an error 
     * will be thrown from the database and eventually the method calling the database. 
     * Pre - The Employee exists in the database.
     * Post - The Employee no longer exists in the database. 
     * 
     * @param username - the username variable that references the row that will be deleted from the database. 
     * @return - a 1 if the deletion from the database is a success, an exception if there is an error. 
     * @throws java.lang.Exception - Is only thrown if there is an error during deletion. 
     */
    public int delete(String username)throws Exception{
        er = new EmployeeRepository();
        Employee emp = er.getEmployee(username);
        return er.delete(emp);
    }
    
    /**
     * Returns a list filled with all the Employees that are available in the database. 
     * Pre - At least one Employee row must exist in the database. 
     * 
     * @return - The list containing all the employees if the method call is successful. Otherwise, the method won't go through and there will be an exception thrown from the database.
     * @throws java.lang.Exception - Will be thrown if there is an error during the method run. 
     */
    public List<Employee> getAll()throws Exception{
        er = new EmployeeRepository();
        return er.getAll();
    } 
    
    /**
     * Logs in a user based on the information such as the password and the username. 
     * This method also checks to see if the user is an admin by checking the privileges
     * 
     * 
     * @param request
     * @param username - The Java.Lang.String object that will contain the username that the Database will use to search for the row. 
     * @param password - The password variable that will be used to check whether or not the user is valid. 
     * @return the Employee object if the Database finds the employee containing that Username, otherwise the method will return null if the database finds nothing. 
     */
    public boolean login(HttpServletRequest request, String username, String password) { //Exception Must be thrown here, just to be safe. 
        HttpSession session = request.getSession();
       
        
        if (username == null || password == null) {
            session.invalidate();
            return false;
        }

        EmployeeRepository er = new EmployeeRepository();
        Employee employee = er.getEmployee(username);
        
        if (employee == null) {
            session.invalidate();
            return false;
        } 
        
        if (!employee.getPassword().equals(password)) {
            session.invalidate();
            return false;
        }
        
        List<Privilege> privilegeList = employee.getPrivilegeList();
        int id = 0 ;
        for(Privilege pv :privilegeList){
             id =pv.getPrivilegeId();
        }
        if(id == 1) {
            session.setAttribute("isAdmin", 1);
        } else {
            session.setAttribute("isAdmin", 0);
        }
        
        session.setAttribute("currentUser", employee);
        
        
        return true; 
    }
    
    /**
     *This will return an employee object from the database using the username as a reference to search the database. 
     * Pre - The Employee Row must exist in the database prior to running this method. 
     * Post - The Employee Object will be called into the System as an Employee Object. 
     * 
     * @param username - the parameter that the database would use to search for the required row. 
     * @return - An Employee Object if the Method and Database call runs without error, otherwise a Null Pointer will be returned. 
     * @throws Exception - Throws a null pointer when an error is thrown during the method call. 
     */
    public Employee getEmployee(String username)throws Exception{
        er = new EmployeeRepository();
        return er.getEmployee(username);
    }
    
    /**
     * Returns an Employee object from the database based on the Employee's email, if the email is in the database then the Row containing that Employee will be returned. 
     * Pre - The Employee row must exist in the database prior to calling this method. 
     * Pos - the Employee method will be returned into the program as an Employee Object. 
     * @param email - The Java.Lang.String object that will contain the email that the Database will use to search for the row. 
     * @return - The Employee object if the Database finds the employee containing that Email, otherwise the method will return null. 
     */
    public Employee getEmployeeEmail(String email){
        er = new EmployeeRepository();
        return er.getUserEmail(email);
    }
    
    /**
     * Method to logout of the application. It invalidates all sessions
     * @param request 
     */
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
    }
    
    /**
     * Method to update the employee information
     * 
     * @param employee
     * @return
     * @throws Exception 
     */
    public int update(String username, String firstName, String lastName, String password, String email)throws Exception{
        er = new EmployeeRepository();
        Employee employee = er.getEmployee(username);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setPassword(password);
        employee.setEmail(email);
        return er.update(employee);
    }
}
