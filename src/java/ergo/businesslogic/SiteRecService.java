/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.SiteRecRepository;
import ergo.domainmodel.SiteRec;
import ergo.servlet.WorkAreaServlet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author waynelin
 */
public class SiteRecService {

    public int insert(String srRec, String srAcc, String srDate, Integer pwaeId) throws Exception {
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

    public int update(int siteRecId, String srRec, String srAcc, String srDate, Integer pwaeId) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");
        SiteRecRepository srr = new SiteRecRepository();
        SiteRec siteRec = this.getSiteRec(siteRecId);
        PwaeService ps = new PwaeService();
        Date date = null;
        try {
            date = formatter.parse(srDate);
        } catch (Exception e) {
            Logger.getLogger(WorkAreaServlet.class.getName()).log(Level.SEVERE, null, e);

        }
        siteRec.setCompleteDate(date);
        siteRec.setRecommand(srRec);
        siteRec.setAccessoryType(srAcc);

        siteRec.setPwaeIdsite(ps.getPwae(pwaeId));
        return srr.update(siteRec);
    }

    public SiteRec getSiteRec(int siteRecId) throws Exception {
        SiteRecRepository srr = new SiteRecRepository();
        return srr.getSiteRec(siteRecId);
    }

    public List<SiteRec> getSiteRecsByPwae(int pwae) throws Exception {
        SiteRecRepository srr = new SiteRecRepository();
        return srr.getSiteRecByPwae(pwae);
    }

}
