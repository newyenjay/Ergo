/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.PwaeRepository;
import ergo.domainmodel.Pwae;

/**
 *
 * @author waynelin
 */
public class PwaeService {

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

    public int updateMonitorList(int pwaeId) throws Exception {
        PwaeRepository pwaeRepo = new PwaeRepository();
        MonitorService ms = new MonitorService();
        Pwae pwae = this.getPwae(pwaeId);
        pwae.getMonitorList().clear();
        pwae.setMonitorList(ms.getMonitorByPwae(pwaeId));
        return pwaeRepo.update(pwae);
    }
    
    public int updateSiteRecList(int pwaeId)throws Exception{
        PwaeRepository pwaeRepo = new PwaeRepository();
        SiteRecService srs = new SiteRecService();
        Pwae pwae =this.getPwae(pwaeId);
        pwae.getSiteRecList().clear();
        pwae.setSiteRecList(srs.getSiteRecsByPwae(pwaeId));
        return pwaeRepo.update(pwae);

    }

    public Pwae getPwae(Integer pwaeId) throws Exception {
        PwaeRepository pwaeRepo = new PwaeRepository();
        return pwaeRepo.getPwae(pwaeId);
    }

}
