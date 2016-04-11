/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import ergo.domainmodel.Assessment;
import javax.persistence.EntityManager;

/**
 *
 * @author tetsu
 */
public class AssessmentRepository {
     public int insert(Assessment assessment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(assessment);
            em.getTransaction().commit();
            return assessment.getAssessmentId();
        } finally {
            em.close();
        }
    }
     public int update(Assessment assessment) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(assessment);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
     public Assessment getAssessment(int AssessmentId)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Assessment Assessment = em.find(Assessment.class, AssessmentId); //this will need to be fixed because the variable type might not be exactly the same. 3
            return Assessment;
        } finally {
            em.close();    
        }
    }
}
