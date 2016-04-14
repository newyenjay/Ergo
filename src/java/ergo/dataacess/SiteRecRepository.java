/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Pwae;
import ergo.domainmodel.SiteRec;
import java.util.List;
import javax.persistence.EntityManager;


public class SiteRecRepository {
    
    /**
     * Method to insert into the table using the DBUtility
     * @param siteRec
     * @return
     * @throws Exception 
     */
    public int insert(SiteRec siteRec) throws Exception  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {       
            Pwae pwae =siteRec.getPwaeIdsite();
            pwae.getSiteRecList().add(siteRec);

            em.getTransaction().begin();
            em.merge(pwae);
            em.persist(em.merge(siteRec));
            em.getTransaction().commit();
            return 1;
            
        } finally {
            em.close();
        }
    }
    
    /**
     * Method to update using the DBUtility 
     * @param siteRec
     * @return
     * @throws Exception 
     */
     public int update(SiteRec siteRec)throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(siteRec);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
     
     /**
     * Method to retrieve from the database using DBUtility
      * @param siteRecId
      * @return
      * @throws Exception 
      */
     public SiteRec getSiteRec(int siteRecId)throws Exception{
         EntityManager em =DBUtil.getEmFactory().createEntityManager();
         try {
            SiteRec siteRec = em.find(SiteRec.class,siteRecId);
            return siteRec;
        } finally {
            em.close();
        }
     }
     
     /**
      * Method to return a list of the site recommendations by each row
      * using the DBUtitliy 
      * @param pwae
      * @return
      * @throws Exception 
      */
     public List<SiteRec> getSiteRecByPwae(int pwae)  throws Exception{
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<SiteRec> siteRecs = em.createNamedQuery("SiteRec.findBySiteRecId", SiteRec.class).setParameter("siteRecId", pwae).
                    getResultList();
            return siteRecs;
        } finally {
            em.close();    
        }
    }
}
