package ergo.businesslogic;

import ergo.dataacess.DiscomfortRepository;
import ergo.domainmodel.Discomfort;

/**
 * Service to help the discomfort table be inserted into the database
 */
public class DiscomfortService {

    DiscomfortRepository dr;

    /**
     * Method to help insert into the discomfort table
     * 
     * @param notes to be inserted into the database 
     * @return
     * @throws Exception 
     */
    public int insert(String notes) throws Exception {
        dr = new DiscomfortRepository();
        Discomfort discomfort = new Discomfort();
        discomfort.setNotes(notes);
        return dr.insert(discomfort);
    }

    /**
     * Method to update the discomfort table in the database
     * 
     * @param discomfortId id to identify the discomfort with each assessment
     * @param note notes that can be updated in the database 
     * @return
     * @throws Exception 
     */
    public int update(int discomfortId, String note) throws Exception {
        dr = new DiscomfortRepository();
        Discomfort discomfort = this.getDiscomfort(discomfortId);
        discomfort.setNotes(note);
        return dr.update(discomfort);
    }

    /**
     * Method to help get the discomfort id, to help with overall asssessment information 
     * @param discomfortId
     * @return
     * @throws Exception 
     */
    public Discomfort getDiscomfort(Integer discomfortId) throws Exception {
        dr = new DiscomfortRepository();
        return dr.getDiscomfort(discomfortId);
    }
}
