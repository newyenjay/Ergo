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
    
    public int insert (int adminId, String proactive, String reactive, String assessor, String manager, String businessUnit,
            String workspace, String jobTitle, String gender, int heightInFeet, int heightInInches, String handedness, int daysPerWeek,
            int hoursPerDay, int hoursVDT, int hoursOnPhone, String discomfortPresent, String discomfortReported, String treatmentSought,
            String maxDiscomfort, String risks, String equip, String generalNotes, int score, String followup) {
        ar = new AdminRepository();
        Admin admin = new Admin(); 
        
        admin.setAdminId(adminId);
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
        admin.setEquipmentRecommendations(equip);
        admin.setGeneralNotes(generalNotes);
        admin.setScore(score);
        
        return ar.insert(admin); 
        
    }
    
}
