/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.DiscomfortRepository;
import ergo.domainmodel.Discomfort;

/**
 *
 * @author Kimberly Oshiro
 */
public class DiscomfortService {
DiscomfortRepository dr;

    //insert
    public int insert(String notes)throws Exception{
         dr = new DiscomfortRepository();
         Discomfort discomfort = new Discomfort();
         discomfort.setNotes(notes);
         return dr.insert(discomfort); //I don't think you need to create a discomfort ID here. However, if you want a discomfort ID you need to get one. 
    }
    
    public Discomfort getDiscomfort(Integer discomfortId)throws Exception{
        dr = new DiscomfortRepository();
        return dr.getDiscomfort(discomfortId);
    }
}
