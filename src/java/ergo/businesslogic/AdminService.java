package ergo.businesslogic;

import ergo.dataacess.AdminRepository;
import ergo.domainmodel.Admin;


/**
 * Service for admin page assessment to insert and update into the database. 
 */
public class AdminService {
    
    private AdminRepository ar; 
    
    /**
     * Method to insert into the admin table of the database 
     * 
     * @param proactive Sets the status of the client
     * @param reactive Sets the status of the client
     * @param assessor Person who takes the assessment
     * @param manager Manager of assessor
     * @param businessUnit Location of business if necessary 
     * @param workspace Type of workspace
     * @param jobTitle Job Title of client
     * @param gender Gender of client
     * @param heightInFeet Height in feet of client, for example 6 feet
     * @param heightInInches Height of client, for example, 6 feet 1 inch
     * @param handedness Left or right
     * @param daysPerWeek Monday, Tuesday, Wednesday, Thursday, Friday
     * @param hoursPerDay Hours worked per day
     * @param hoursVDT Hours in VDT 
     * @param hoursOnPhone hours spent on phone
     * @param discomfortPresent Yes or no
     * @param discomfortReported Yes or no
     * @param treatmentSought Yes or no
     * @param maxDiscomfort Yes or no
     * @param workstationFit Yes or no
     * @param risks Risks associated with job
     * @param equipmentRecommendations types of recommendations for equip. 
     * @param generalNotes Notes 
     * @param followup Does the client need a followup
     * @param score Score provided by VDT
     * @return returns the inserted object 
     * @throws Exception 
     */
    public int insert ( String proactive, String reactive, String assessor, String manager, String businessUnit,
            String workspace, String jobTitle, String gender, int heightInFeet, int heightInInches, String handedness, int daysPerWeek,
            int hoursPerDay, int hoursVDT, int hoursOnPhone, String discomfortPresent, String discomfortReported, String treatmentSought,
            int maxDiscomfort, int workstationFit, String risks,String equipmentRecommendations, String generalNotes, String followup, int score) throws Exception{
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
        admin.setWorkFit(workstationFit);
        admin.setEquipmentRecommendations(equipmentRecommendations);
        admin.setRisks(risks);
        admin.setGeneralNotes(generalNotes);
        admin.setScore(score);
        admin.setTreatmentSought(treatmentSought);
        admin.setHoursOnPhone(hoursOnPhone);
        admin.setFollowUpNeeded(followup);
        
        return ar.insert(admin); 
        
    }
    
    /**
     * Method to update into the admin table in database. This method will give
     * have a unique ID in the table.
     * 
     * @param proactive Sets the status of the client
     * @param reactive Sets the status of the client
     * @param assessor Person who takes the assessment
     * @param manager Manager of assessor
     * @param businessUnit Location of business if necessary 
     * @param workspace Type of workspace
     * @param jobTitle Job Title of client
     * @param gender Gender of client
     * @param heightInFeet Height in feet of client, for example 6 feet
     * @param heightInInches Height of client, for example, 6 feet 1 inch
     * @param handedness Left or right
     * @param daysPerWeek Monday, Tuesday, Wednesday, Thursday, Friday
     * @param hoursPerDay Hours worked per day
     * @param hoursVDT Hours in VDT 
     * @param hoursOnPhone hours spent on phone
     * @param discomfortPresent Yes or no
     * @param discomfortReported Yes or no
     * @param treatmentSought Yes or no
     * @param maxDiscomfort Yes or no
     * @param workstationFit Yes or no
     * @param risks Risks associated with job
     * @param equipmentRecommendations types of recommendations for equip. 
     * @param generalNotes Notes 
     * @param followup Does the client need a followup
     * @param score Score provided by VDT
     * @return returns the inserted object 
     * @throws Exception 
     */
    public int update( String proactive, String reactive, String assessor, String manager, String businessUnit,
            String workspace, String jobTitle, String gender, int heightInFeet, int heightInInches, String handedness, int daysPerWeek,
            int hoursPerDay, int hoursVDT, int hoursOnPhone, String discomfortPresent, String discomfortReported, String treatmentSought,
            int maxDiscomfort, int workstationFit, String risks,String equipmentRecommendations, String generalNotes, String followup, int score, int adminId) throws Exception{
         ar = new AdminRepository(); 
        Admin admin = this.getAdmin(adminId);
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
        admin.setWorkFit(workstationFit);
        admin.setEquipmentRecommendations(equipmentRecommendations);
        admin.setRisks(risks);
        admin.setGeneralNotes(generalNotes);
        admin.setScore(score);
        admin.setTreatmentSought(treatmentSought);
        admin.setHoursOnPhone(hoursOnPhone);
        admin.setFollowUpNeeded(followup);
        
        
    return ar.update(admin);
    }
    
    
    /**
     * Method to see if the current user of the system is an admin status. 
     * @param adminId
     * @return
     * @throws Exception 
     */
    public Admin getAdmin(int adminId)throws Exception{
        ar = new AdminRepository();
        return ar.getAdminId(adminId);
    }
    
}
