/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.PwaeRepository;
import ergo.domainmodel.Pwae;

/**
 * Service to help insert and update into the prepare work area equipment table
 * @author 680420
 */
public class PwaeService {

    /**
     * Method to insert into the table of prepare work area and equipment.
     * Takes in an object that has all values and inserts them into the table
     * 
     * @param elbowCurr
     * @param elbowRec
     * @param elbowSit
     * @param eyeCurr
     * @param eyeRec
     * @param eyeSit
     * @param deskCurr
     * @param deskRec
     * @param deskSit
     * @param keyboardCurr
     * @param keyboardRec
     * @param keyboardSit
     * @param chairNote
     * @param monitorNote
     * @param inputNote
     * @param deskNote
     * @param accessNote
     * @return
     * @throws Exception 
     */
    public int insert(String elbowCurr,
            String elbowRec,
            String elbowSit,
            String eyeCurr,
            String eyeRec,
            String eyeSit,
            String deskCurr,
            String deskRec,
            String deskSit,
            String keyboardCurr,
            String keyboardRec,
            String keyboardSit,
            String chairNote,
            String monitorNote,
            String inputNote,
            String deskNote,
            String accessNote) throws Exception {
        PwaeRepository pwaeRepo = new PwaeRepository();
        Pwae pwae = new Pwae();

        pwae.setElbowCurr(elbowCurr);
        pwae.setElbowRec(elbowRec);
        pwae.setElbowSit(elbowSit);
        pwae.setEyeCurr(eyeCurr);
        pwae.setEyeRec(eyeRec);
        pwae.setEyeSit(eyeSit);
        pwae.setDeskCurr(deskCurr);
        pwae.setDeskRec(deskRec);
        pwae.setDeskSit(deskSit);
        pwae.setKeyboardCurr(keyboardCurr);
        pwae.setKeyboardRec(keyboardRec);
        pwae.setKeyboardSit(keyboardSit);
        pwae.setAccessoriesNote(accessNote);
        pwae.setChairNote(chairNote);
        pwae.setDeskNote(deskNote);
        pwae.setInputNote(inputNote);
        pwae.setMonitorNote(monitorNote);

        return pwaeRepo.insert(pwae);
    }

    /**
     * Method to update the table of prepare work area and equipment. 
     * 
     * 
     * @param pwaeId
     * @param elbowCurr
     * @param elbowRec
     * @param elbowSit
     * @param eyeCurr
     * @param eyeRec
     * @param eyeSit
     * @param deskCurr
     * @param deskRec
     * @param deskSit
     * @param keyboardCurr
     * @param keyboardRec
     * @param keyboardSit
     * @param chairNote
     * @param monitorNote
     * @param inputNote
     * @param deskNote
     * @param accessNote
     * @return
     * @throws Exception 
     */
    public int updatePwae(int pwaeId, String elbowCurr,
            String elbowRec,
            String elbowSit,
            String eyeCurr,
            String eyeRec,
            String eyeSit,
            String deskCurr,
            String deskRec,
            String deskSit,
            String keyboardCurr,
            String keyboardRec,
            String keyboardSit,
            String chairNote,
            String monitorNote,
            String inputNote,
            String deskNote,
            String accessNote) throws Exception {
        PwaeRepository pwaeRepo = new PwaeRepository();
        Pwae pwae = this.getPwae(pwaeId);
        pwae.setElbowCurr(elbowCurr);
        pwae.setElbowRec(elbowRec);
        pwae.setElbowSit(elbowSit);
        pwae.setEyeCurr(eyeCurr);
        pwae.setEyeRec(eyeRec);
        pwae.setEyeSit(eyeSit);
        pwae.setDeskCurr(deskCurr);
        pwae.setDeskRec(deskRec);
        pwae.setDeskSit(deskSit);
        pwae.setKeyboardCurr(keyboardCurr);
        pwae.setKeyboardRec(keyboardRec);
        pwae.setKeyboardSit(keyboardSit);
        pwae.setAccessoriesNote(accessNote);
        pwae.setChairNote(chairNote);
        pwae.setDeskNote(deskNote);
        pwae.setInputNote(inputNote);
        pwae.setMonitorNote(monitorNote);
        return pwaeRepo.update(pwae);
    }

    /**
     * Method to update the monitor list. This method is used with the monitor
     * service as well. When updating the monitor list, it will use the service
     * in order to update it
     * @param pwaeId
     * @return
     * @throws Exception 
     */
    public int updateMonitorList(int pwaeId) throws Exception {
        PwaeRepository pwaeRepo = new PwaeRepository();
        MonitorService ms = new MonitorService();
        Pwae pwae = this.getPwae(pwaeId);
        pwae.getMonitorList().clear();
        pwae.setMonitorList(ms.getMonitorByPwae(pwaeId));
        return pwaeRepo.update(pwae);
    }
    
    /**
     * Method to update the update site recommendation list
     * This method grabs the id of the assessment 
     * @param pwaeId
     * @return
     * @throws Exception 
     */
    public int updateSiteRecList(int pwaeId)throws Exception{
        PwaeRepository pwaeRepo = new PwaeRepository();
        SiteRecService srs = new SiteRecService();
        Pwae pwae =this.getPwae(pwaeId);
        pwae.getSiteRecList().clear();
        pwae.setSiteRecList(srs.getSiteRecsByPwae(pwaeId));
        return pwaeRepo.update(pwae);

    }

    /**
     * Method to get the unique id of a prepare work area and equipment.
     * This helps with making the overall assessment 
     * @param pwaeId
     * @return
     * @throws Exception 
     */
    public Pwae getPwae(Integer pwaeId) throws Exception {
        PwaeRepository pwaeRepo = new PwaeRepository();
        return pwaeRepo.getPwae(pwaeId);
    }

}
