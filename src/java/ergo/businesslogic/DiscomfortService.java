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
 * 
 * @version 1.0 - Instantiated early methods, made everything work in this version.
 * @version 1.1 - Inserted javadoc. 06/04/2016
 */
public class DiscomfortService {
DiscomfortRepository dr;

    /**
     * Takes parameters and inserts them into the database, which creates a fully realized row in the database. If the insertion is a success then the 
     * method will return a 1, otherwise it will return a null pointer. 
     * pre - the exact row does not exist in the database. 
     * post - the row is now inserted into the database. 
     * 
     * @param notes - a variable that is used during insertion, will be saved to the database. 
     * @return - A 1 if the insertion to the database is a success, otherwise will return a null pointer exception. 
     * @throws Exception - Thrown if there is any errors during insertion. 
     */
    public int insert(String notes)throws Exception{
         dr = new DiscomfortRepository();
         Discomfort discomfort = new Discomfort();
         discomfort.setNotes(notes);
         return dr.insert(discomfort); //I don't think you need to create a discomfort ID here. However, if you want a discomfort ID you need to get one. 
    }
    
    /**
     * Returns a specific Discomfort Object from the database, taking in an Integer as the parameter, the database will search for this row and will return the Object if it exists in the
     * database, otherwise will return a null pointer. 
     * Pre - the row must exist in the database prior to calling this method. 
     * Post - There is a version of the row that exists in the Project as an Object. 
     * 
     * @param discomfortId - the parameter that the System uses to search for the specific Discomfort row. 
     * @return - a Discomfort Object that reflects the row in the database if the search is a success, otherwise if the database is unable to find the object it will return a null, or
     * if there is an error thrown during execution it will return a null pointer. 
     * @throws Exception - Thrown if there is an error during execution. 
     */
    public Discomfort get(Integer discomfortId)throws Exception{
        dr = new DiscomfortRepository();
        return dr.getDiscomfort(discomfortId);
    }
}
