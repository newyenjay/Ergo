/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.ClientRepository;
import ergo.domainmodel.Assessment;
import ergo.domainmodel.Client;
import ergo.domainmodel.Company;
import java.util.Date;
import java.util.List;
/**
 *
 * Service that will handle the calls for the Employee repository. 
 */
public class ClientService {
    private static ClientRepository cr; 
    
    /**
     * Takes the parameters that are required to create a Client object, creates a Client object using the parameters given, and inserts the object into the database. 
     * @param clientId - the integer that represents the clientele id, what is the primary key in the database and is used to identify the object out of every other row in the
     * database. Cannot be altered. 
     * @param firstName - The first name of the client, is used to identify based on first name. 
     * @param comloc 
     * @param companyList 
     * @param lastName - The last name of the client, is used to identify based on last name.
     * @param email - The last name of the client, is used to identify based on email. 
     * @return - an integer if the insertion was successful into the database, or an exception that the database will throw because something went wrong during the insertion
     *  into the database. 
     * @throws Exception 
     */
    public int insert(String firstName, String lastName, Integer comloc)throws Exception{
       CompanyService cs = new CompanyService();
        cr = new ClientRepository();
       Client client = new Client();
       client.setFirstName(firstName);
       client.setLastName(lastName);
       client.setCompanyId(cs.getCompany(comloc));

       return cr.insert(client);
    }
    
    /**
     * By using a clientId as a reference, the method will be able to delete a row from the database by calling a row and by taking that referenced row, delete it. 
     * 
     * @param clientId - The clientId of the row that is going to be deleted. 
     * @return - a 1 if the deletion is a success, otherwise nothing if the deletion is not a success. 
     * @throws Exception - If the database throws an error in the process of deleting the row, an exception will be thrown that will be unique to that of the situation. 
     */
    public int remove(Integer clientId)throws Exception{
        cr = new ClientRepository();
        Client client = cr.getClient(clientId);
        return cr.delete(client);
    }
    
    /**
     * Takes the parameters for an object, and calls the object from the database. Using the new parameters, will set all the variables to change the old ones on the Client
     * object if there are any changes. 
     * 
     * @param clientId - what is used to identify the client in the database, this row cannot be altered. 
     * @param firstName - The first name of the client,  is used to identify based on first name. 
     * @param lastName - the Last name of the client, is used to identify based on last name. 
     * @param email - the email of the client, is used to identify based on email. 
     * @return - a 1 if the sql query is a success. Otherwise, nothing. 
     * @throws Exception - If an exception is thrown from the database, then it will be shown in the web browser as a unique error message. 
     */
    public int update(Integer clientId, String firstName, String lastName, String email) throws Exception{
        cr = new ClientRepository();
        Client client = cr.getClient(clientId);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        return cr.update(client);
    } 
    
    /**
     * Returns a Client object based on the clientId that is sent in as a parameter. Will only return one object. 
     * Pre - the object must exist in the database before being called. 
     * Post - the object will be called in the program after this method. 
     * 
     * @param clientId - the id of the row in which the Client resides in, is unique and serves as a primary key in the database. 
     * @return - a Client object that contains the Client with this clientId if the operation is a success. 
     * @throws Exception - if any of the operations that are attempted to be done results in an error. 
     */
    public Client getClient(int clientId)throws Exception{
        cr = new ClientRepository();
        return cr.getClient(clientId);
    }
    
    /**
     * Searches for a Client in the database based on the email given to the method. 
     * Pre - the object must exist in the database before this method is called.
     * Post - the method will be existent in the Program. 
     * 
     * @param email - the string object that will be used to search for the Client object. Must be a valid email. 
     * @return -  A client object if the Client exists in the database.
     * @throws Exception - An exception if the client does not exist in the database, or if there is an exception while executing the query. 
     */
    public Client getClientEmail(String email)throws Exception{
        cr = new ClientRepository();
        return cr.getClientEmail(email);
    }
    /**
     * returns a full Java.util.List of all the Clients in the database. 
     * pre- there must be at least one client object in the database. 
     * 
     * @return - a Java.util.List that contains the entire listing of the Clientele database.
     * @throws Exception - If there's an error while executing the code. 
     */
    public List<Client> getAll()throws Exception{
        cr = new ClientRepository();
        return cr.getAll();
    }
    
    /**
     * Method to update an assessment if it is modified
     * @param clientId
     * @param assessmentId
     * @return
     * @throws Exception 
     */
    public int updateAssess(int clientId, int assessmentId) throws Exception{
        cr = new ClientRepository();
        AssessmentService assessS = new AssessmentService();
        Assessment assessment= assessS.getAssessment(assessmentId);
        Client client = cr.getClient(clientId);
        client.getAssessmentList().add(assessment);
        return cr.update(client);
    }
    
}
