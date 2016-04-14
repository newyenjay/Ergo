/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;
import ergo.dataacess.PmbRepository;
import ergo.domainmodel.Pmb;
import java.util.List;

/**
 * Service to help insert and update the table of prepare and maintain body in the database
 */
public class PmbService {
    private static PmbRepository pr; //I figured it'd be easier just to have a variable instantiated already instead of having to create a new one every time.
    
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
    public int insert(Boolean goalMetBool, String goalMetNotes, Boolean educBool,
            String educNotes, Boolean microBeBool, String microBeNotes, 
            Boolean microAfBool, String microAfNotes) throws Exception{
        
        pr = new PmbRepository();
        Pmb pmb = new Pmb();
        pmb.setGoalMetBool(goalMetBool);
        pmb.setGoalMetNotes(goalMetNotes);
        pmb.setEducBool(educBool);
        pmb.setEducNotes(educNotes);
        pmb.setMicroBeBool(microBeBool);
        pmb.setMicroBeNotes(microBeNotes);
        pmb.setMicroAfBool(microAfBool);
        pmb.setMicroAfNotes(microAfNotes);
        return pr.insert(pmb);
    }
    
    /**
     * By using a clientId as a reference, the method will be able to delete a row from the database by calling a row and by taking that referenced row, delete it. 
     * 
     * @param clientId - The clientId of the row that is going to be deleted. 
     * @return - a 1 if the deletion is a success, otherwise nothing if the deletion is not a success. 
     * @throws Exception - If the database throws an error in the process of deleting the row, an exception will be thrown that will be unique to that of the situation. 
     */
    public int remove(Integer pmbId)throws Exception{
        pr = new PmbRepository();
        Pmb pmb = pr.getPmb(pmbId);
        return pr.delete(pmb);
    }
    
    /**
     * Takes the parameters for an object, and calls the object from the database. Using the new parameters, will set all the variables to change the old ones on the Client
     * object if there are any changes. 
     * 
     * @param pmbId
     * @param goalMetBool
     * @param goalMetNotes
     * @param clientId - what is used to identify the client in the database, this row cannot be altered. 
     * @param educNotes 
     * @param firstName - The first name of the client,  is used to identify based on first name. 
     * @param lastName - the Last name of the client, is used to identify based on last name. 
     * @param email - the email of the client, is used to identify based on email. 
     * @return - a 1 if the sql query is a success. Otherwise, nothing. 
     * @throws Exception - If an exception is thrown from the database, then it will be shown in the web browser as a unique error message. 
     */
    public int update(Integer pmbId, Boolean goalMetBool, String goalMetNotes,
            Boolean educBool, String educNotes, Boolean microBeBool, String microBeNotes, 
            Boolean microAfBool, String microAfNotes) throws Exception{
        pr = new PmbRepository();
        Pmb pmb = pr.getPmb(pmbId);
        pmb.setGoalMetBool(goalMetBool);
        pmb.setGoalMetNotes(goalMetNotes);
        pmb.setEducBool(educBool);
        pmb.setEducNotes(educNotes);
        pmb.setMicroBeBool(microBeBool);
        pmb.setMicroBeNotes(microBeNotes);
        pmb.setMicroAfBool(microAfBool);
        pmb.setMicroAfNotes(microAfNotes);
        return pr.update(pmb);
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
    public Pmb getPmb(int pmbId)throws Exception{
        pr = new PmbRepository();
        return pr.getPmb(pmbId);
    }
    
    /**
     * returns a full Java.util.List of all the Clients in the database. 
     * pre- there must be at least one client object in the database. 
     * 
     * @return - a Java.util.List that contains the entire listing of the Clientele database.
     * @throws Exception - If there's an error while executing the code. 
     */
    public List<Pmb> getAll()throws Exception{
        pr = new PmbRepository();
        return pr.getAll();
    }
}
