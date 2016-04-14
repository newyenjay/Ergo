/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.MonitorRepository;
import ergo.domainmodel.Monitor;
import java.util.List;

/**
 * Service to help with the prepare work area and equipment page in the application.
 * This service helps with one table in the application where it can be 
 * duplicated
 */
public class MonitorService {

    MonitorRepository mr;

    /**
     * Method to insert just the information regarding monitor into the monitor
     * table
     * 
     * @param monType type of monitor
     * @param monCurr which is the current monitor
     * @param monRec monitor recommendations
     * @param monSit is the monitor a regular one or is it a standing monitor
     * @param pwaeId ID of prepare and maintain body table
     * @return
     * @throws Exception 
     */
    public int insert(String monType, String monCurr, String monRec, String monSit, Integer pwaeId) throws Exception {
        mr = new MonitorRepository();
        Monitor monitor = new Monitor();
        PwaeService ps = new PwaeService();
        monitor.setCurrent(monCurr);
        monitor.setRecommand(monRec);
        monitor.setSitStand(monSit);
        monitor.setType(monType);
        monitor.setPwaeId(ps.getPwae(pwaeId));
        return mr.insert(monitor);
    }

    /**
     * Method to update the table
     * 
     * @param monitorId unique id
     * @param monType type of monitor
     * @param monCurr which is the current monitor
     * @param monRec monitor recommendations
     * @param monSit is the monitor a regular one or is it a standing monitor
     * @param pwaeId ID of prepare and maintain body table
     * @return
     * @return
     * @throws Exception 
     */
    public int update(int monitorId, String monType, String monCurr, String monRec, String monSit, Integer pwaeId) throws Exception {
        mr = new MonitorRepository();
        Monitor monitor = this.getMonitor(monitorId);
        PwaeService ps = new PwaeService();
        monitor.setCurrent(monCurr);
        monitor.setRecommand(monRec);
        monitor.setSitStand(monSit);
        monitor.setType(monType);
        monitor.setPwaeId(ps.getPwae(pwaeId));
        return mr.update(monitor);
        
    }

    /**
     * Method to get a particular monitor based on the id of monitor
     * 
     * @param monitorId
     * @return
     * @throws Exception 
     */
    public Monitor getMonitor(int monitorId) throws Exception {
        mr = new MonitorRepository();

        return mr.getMonitor(monitorId);
    }
    
    /**
     * Method to get a list of monitors by the prepare work area equipment id
     * 
     * @param pwae
     * @return
     * @throws Exception 
     */
    public List<Monitor> getMonitorByPwae(int pwae) throws Exception{
        mr = new MonitorRepository();

        return mr.getMonitorByPwae(pwae);
    }

}
