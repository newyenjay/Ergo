/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.AssessmentRepository;
import ergo.domainmodel.Admin;
import ergo.domainmodel.Assessment;
import ergo.domainmodel.Client;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tetsu
 */
public class AssessmentService {

    private static AssessmentRepository ar = new AssessmentRepository();
    private final Date date = new Date();

    public int insert(int clientId, String type) throws Exception {
        Assessment assessment = new Assessment();
        ClientService cs = new ClientService();
        assessment.setClientId(cs.getClient(clientId));
        assessment.setType(type);
        assessment.setCreateDate(date);
        assessment.setEditDate(date);
        return ar.insert(assessment);
    }

    public int updateAdmin(int assessmentId, int adminId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        AdminService admins = new AdminService();
        assessment.setAdminId(admins.getAdmin(adminId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }

    public int updatePmb(int assessmentId, int pmbId) throws Exception {
        Assessment assessment = ar.getAssessment(assessmentId);
        PmbService pmbs = new PmbService();
        assessment.setPmbId(pmbs.getPmb(pmbId));
        assessment.setEditDate(date);
        return ar.update(assessment);
    }

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
