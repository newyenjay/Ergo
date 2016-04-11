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

/**
 *
 * @author tetsu
 */
public class AssessmentService {
    private static AssessmentRepository ar = new AssessmentRepository();
    public int insert(int clientId, String type) throws Exception{
        Assessment assessment = new Assessment();
        ClientService cs = new ClientService();

        assessment.setClientId(cs.getClient(clientId));
        assessment.setType(type);
        return ar.insert(assessment);
    }
    
    public int updateAdmin(int assessmentId, int adminId) throws Exception{
        Assessment assessment = ar.getAssessment(assessmentId);
        AdminService admins = new AdminService();
        assessment.setAdminId(admins.getAdmin(adminId));
        return ar.update(assessment);
    }
    
}
