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
        Followup followup = new Followup();
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
    
    public int update(int followupId, String notes, String comments, String recommendations)throws Exception{
        
        fr = new FollowupRepository();
        Followup followup =this.getFollowup(followupId);
        followup.setNote(notes);
        followup.setComments(comments);
        followup.setRecommendations(recommendations);
        return fr.update(followup);
        
    }
   
    
}
