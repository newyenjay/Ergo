package ergo.businesslogic;

import ergo.dataacess.FollowupRepository;
import ergo.domainmodel.Followup;

/**
 * Service to help insert into the table of followup in the database
 */
public class FollowupService {
    FollowupRepository fr; 
    
    
    /**
     * Method to insert into the followup table
     * @param notes takes in notes to insert into the table
     * @param comments takes in comments to insert into the table
     * @param recommendations takes in recommendations to insert into a table
     * @return 
     * @throws java.lang.Exception 
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
     * Method to get all data from the followup 
     * 
     * @param followUpId
     * @return 
     * @throws java.lang.Exception 
     */
    public Followup getFollowup(int followUpId) throws Exception{
        fr = new FollowupRepository();
        return fr.getFollowup(followUpId);
        //Created the get method purely for necessity. 
    }
    
    /**
     * Method to update the followup table
     * 
     * @param followupId
     * @param notes
     * @param comments
     * @param recommendations
     * @return
     * @throws Exception 
     */
    public int update(int followupId, String notes, String comments, String recommendations)throws Exception{
        
        fr = new FollowupRepository();
        Followup followup =this.getFollowup(followupId);
        followup.setNote(notes);
        followup.setComments(comments);
        followup.setRecommendations(recommendations);
        return fr.update(followup);
        
    }
   
    
}
