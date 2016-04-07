/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.FollowupRepository;
import ergo.domainmodel.Followup;



/**
 *
 * @author Kimberly Oshiro
 * 
 * Handles the interfacing with the FollowupRepository.java, and eventually Database. 
 * 
 * @version 1.0 - INserted code
 * @version 1.1 - Inserting Javadoc - 04/05/2016
 */
public class FollowupService {
    FollowupRepository fr; 
    
    
    /**
     * Takes in the parameters that can create a Followup Object, and inserts them into the database. 
     * Pre - The Followup object does not exist in the database.
     * Post - the Followup object now exists in the database. 
     * 
     * @param notes - A variable that is stored in the database
     * @param comments - A variable that is stored in the database. 
     * @param recommendations - A variable that is stored in the database. 
     * @return A 1 if the insertion is a success, a null pointer if there is any errors while inserting into the database.
     * @throws java.lang.Exception - Is thrown if there is any errors while attempting to run the method. 
     */
    public int insert(String notes, String comments, String recommendations) throws Exception{
        fr =  new FollowupRepository();
        Followup followup = new Followup();
        followup.setNote(notes);
        followup.setComments(comments);
        followup.setRecommendations(recommendations);
        return fr.insert(followup);
        
    }
    
    /**
     * Returns a Followup Object from the database based on the parameter id given. 
     * Pre - the Followup Must exist in the database prior to the method being run. 
     * 
     * @param followUpId - The id that the Database uses to search for the Followup object in the database. 
     * @return - a Followup object if the method is run successfully, a null pointer if the method runs into an error while running. 
     * @throws java.lang.Exception - Thrown if the method runs into errors while attempting to run.
     */
    public Followup getFollowup(int followUpId) throws Exception{
        fr = new FollowupRepository();
        return fr.getFollowup(followUpId);
        //Created the get method purely for necessity. 
    }
   
    
}
