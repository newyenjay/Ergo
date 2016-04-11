/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.SiteRecRepository;
import ergo.domainmodel.SiteRec;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author waynelin
 */
public class SiteRecService {
    
    
    public int insert(String srRec,String srAcc,String srDate,Integer pwaeId)throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        SiteRecRepository srr = new SiteRecRepository();
        SiteRec siteRec = new SiteRec();
        PwaeService ps = new PwaeService();
        Date date = null;
        try {
             date = formatter.parse(srDate);
        } catch (Exception e) {
        }
        siteRec.setCompleteDate(date);
        siteRec.setRecommand(srRec);
        siteRec.setAccessoryType(srAcc);
        
        siteRec.setPwaeIdsite(ps.getPwae(pwaeId));
        return srr.insert(siteRec);
        
    }
    
}
