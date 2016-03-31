/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.AdminRepository;
import ergo.domainmodel.Admin;

/**
 *
 * @author 680420
 */
public class AdminService {
    
    private AdminRepository ar; 
    
    public int insert ( String proactive, String reactive, String assessor, String manager, String businessUnit,
            String workspace, String jobTitle, String gender, int heightInFeet, int heightInInches, String handedness, int daysPerWeek,
            int hoursPerDay, int hoursVDT, int hoursOnPhone, String discomfortPresent, String discomfortReported, String treatmentSought,
            int maxDiscomfort, int workstationFit, String risks, String generalNotes, String followup, int score) {
        ar = new AdminRepository();
        Admin admin = new Admin(); 
        
        admin.setProactive(proactive);
        admin.setReactive(reactive);
        admin.setAssessor(assessor);
        admin.setManager(manager);
        admin.setBusinessUnit(businessUnit);
        admin.setWorkspace(workspace);
        admin.setJobTitle(jobTitle);
        admin.setGender(gender);
        admin.setHeightInFeet(heightInFeet);
        admin.setHeightInInches(heightInInches);
        admin.setHandedness(handedness);
        admin.setDaysPerWeek(daysPerWeek);
        admin.setHoursPerDay(hoursPerDay);
        admin.setHoursVDT(hoursVDT);
        admin.setDiscomfortPresent(discomfortPresent);
        admin.setDiscomfortReported(discomfortReported);
        admin.setMaxDiscomfort(maxDiscomfort);
        admin.setRisks(risks);
        admin.setGeneralNotes(generalNotes);
        admin.setScore(score);
        
        return ar.insert(admin); 
        
    }
    
}
