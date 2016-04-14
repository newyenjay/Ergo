package ergo.businesslogic;

import ergo.dataacess.AssessmentRepository;
import ergo.domainmodel.Assessment;
import java.util.Date;

/**
 * Service to update each tab for the assessment. 
 * Each method will update a specific table in the database.
 */
public class AssessmentService {

    private static AssessmentRepository ar = new AssessmentRepository();
    private final Date date = new Date();

    /**
     * Method to insert a new initial assessment.
     * @param clientId unique client ID
     * @param type Type of the assessment 
     * @return Return the assessment ID 
     * @throws Exception 
     */
    public int insert(int clientId, String type) throws Exception {
        Assessment assessment = new Assessment();
        ClientService cs = new ClientService();
        assessment.setClientId(cs.getClient(clientId));
        assessment.setType(type);
        assessment.setCreateDate(date);
        assessment.setEditDate(date);
        return ar.insert(assessment);
    }

    /**
     * Method to update the admin table in the database. Uses the 
     * adminID as a primary key and will return a unique assessment admin ID
     * 
     * @param assessmentId
     * @param adminId
     * @return
     * @throws Exception 
     */
    public int updateAdmin(int assessmentId, int adminId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        AdminService admins = new AdminService();
        assessment.setAdminId(admins.getAdmin(adminId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }

    /**
     * Method to update the prepare and maintain body table in the database. 
     * Uses the assessmentID as a primary key and will return a unique 
     * assessment assessmentId
     * 
     * @param assessmentId
     * @param pmbId
     * @return
     * @throws Exception 
     */
    public int updatePmb(int assessmentId, int pmbId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        PmbService pmbs = new PmbService();
        assessment.setPmbId(pmbs.getPmb(pmbId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }

    /**
     * Method to update the  table in the database. 
     * Uses the assessmentID as a primary key and will return a unique 
     * assessment assessmentId
     * @param assessmentId
     * @param spmId
     * @return
     * @throws Exception 
     */
    public int updateSpm(int assessmentId, int spmId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        SpmService spms = new SpmService();
        assessment.setSpmId(spms.getSpm(spmId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }

    public int updatePwae(int assessmentId, int pwaeId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        PwaeService pwaeS = new PwaeService();
        assessment.setPwaId(pwaeS.getPwae(pwaeId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }

    public int updateDiscomfort(int assessmentId, int discomfortId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        DiscomfortService discomfortS = new DiscomfortService();
        assessment.setDiscomfortId(discomfortS.getDiscomfort(discomfortId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }

    public int updateFollow(int assessmentId, int followId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        FollowupService followS = new FollowupService();
        assessment.setFollowupId(followS.getFollowup(followId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }
    
    public Assessment getAssessment(int assessmentId)throws Exception{
        return ar.getAssessment(assessmentId);
    }
}
