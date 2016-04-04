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
 */
public class FollowupService {
    FollowupRepository fr; 
    
    
    /**
     * 
     * @param notes
     * @param comments
     * @param recommendations
     * @return 
     */
    public int insert(String notes, String comments, String recommendations) throws Exception{
        fr =  new FollowupRepository();
        Followup followup = new Followup(); //Should we create the object here or in the object simply because most of the fields don't have to be filled?
        followup.setNote(notes);
        followup.setComments(comments);
        followup.setRecommendations(recommendations);
        return fr.insert(followup);
        
    }
    
    /**
     * 
     * @param followUpId
     * @return 
     */
    public Followup getFollowup(int followUpId) throws Exception{
        fr = new FollowupRepository();
        return fr.getFollowup(followUpId);
        //Created the get method purely for necessity. 
    }
   
    
}
