/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.MonitorRepository;
import ergo.domainmodel.Monitor;

/**
 *
 * @author Kimberly Oshiro
 */
public class MonitorService {
    
    MonitorRepository mr;
    
    public int insert(String monType,String monCurr,String monRec,String monSit,Integer pwaeId) throws Exception{
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
}
