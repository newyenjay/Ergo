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
 *
 * @author Kimberly Oshiro
 */
public class MonitorService {

    MonitorRepository mr;

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

    public Monitor getMonitor(int monitorId) throws Exception {
        mr = new MonitorRepository();

        return mr.getMonitor(monitorId);
    }
    
    public List<Monitor> getMonitorByPwae(int pwae) throws Exception{
        mr = new MonitorRepository();

        return mr.getMonitorByPwae(pwae);
    }

}
