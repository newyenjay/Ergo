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
import java.util.List;

/**
 * Service to insert and update the site recommendated table in the database 
 */
public class SiteRecService {

    /**
     * Method to insert into the followup table. Takes an object and inserts into the table
     * @param srRec
     * @param srAcc
     * @param srDate
     * @param pwaeId
     * @return
     * @throws Exception 
     */
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

    /**
     * Method to update the site recommended table in the database.
     * @param siteRecId
     * @param srRec
     * @param srAcc
     * @param srDate
     * @param pwaeId
     * @return
     * @throws Exception 
     */
    public int update(int siteRecId, String srRec, String srAcc, String srDate, Integer pwaeId) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        SiteRecRepository srr = new SiteRecRepository();
        SiteRec siteRec = this.getSiteRec(siteRecId);
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
