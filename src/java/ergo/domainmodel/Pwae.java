/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author waynelin
 */
@Entity
@Table(name = "pwae")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pwae.findAll", query = "SELECT p FROM Pwae p"),
    @NamedQuery(name = "Pwae.findByPwaeId", query = "SELECT p FROM Pwae p WHERE p.pwaeId = :pwaeId"),
    @NamedQuery(name = "Pwae.findByElbowCurr", query = "SELECT p FROM Pwae p WHERE p.elbowCurr = :elbowCurr"),
    @NamedQuery(name = "Pwae.findByElbowRec", query = "SELECT p FROM Pwae p WHERE p.elbowRec = :elbowRec"),
    @NamedQuery(name = "Pwae.findByElbowSit", query = "SELECT p FROM Pwae p WHERE p.elbowSit = :elbowSit"),
    @NamedQuery(name = "Pwae.findByEyeCurr", query = "SELECT p FROM Pwae p WHERE p.eyeCurr = :eyeCurr"),
    @NamedQuery(name = "Pwae.findByEyeRec", query = "SELECT p FROM Pwae p WHERE p.eyeRec = :eyeRec"),
    @NamedQuery(name = "Pwae.findByEyeSit", query = "SELECT p FROM Pwae p WHERE p.eyeSit = :eyeSit"),
    @NamedQuery(name = "Pwae.findByDeskCurr", query = "SELECT p FROM Pwae p WHERE p.deskCurr = :deskCurr"),
    @NamedQuery(name = "Pwae.findByDeskRec", query = "SELECT p FROM Pwae p WHERE p.deskRec = :deskRec"),
    @NamedQuery(name = "Pwae.findByDeskSit", query = "SELECT p FROM Pwae p WHERE p.deskSit = :deskSit"),
    @NamedQuery(name = "Pwae.findByChairNote", query = "SELECT p FROM Pwae p WHERE p.chairNote = :chairNote"),
    @NamedQuery(name = "Pwae.findByMonitorNote", query = "SELECT p FROM Pwae p WHERE p.monitorNote = :monitorNote"),
    @NamedQuery(name = "Pwae.findByInputNote", query = "SELECT p FROM Pwae p WHERE p.inputNote = :inputNote"),
    @NamedQuery(name = "Pwae.findByDeskNote", query = "SELECT p FROM Pwae p WHERE p.deskNote = :deskNote"),
    @NamedQuery(name = "Pwae.findByAccessoriesNote", query = "SELECT p FROM Pwae p WHERE p.accessoriesNote = :accessoriesNote"),
    @NamedQuery(name = "Pwae.findByKeyboardCurr", query = "SELECT p FROM Pwae p WHERE p.keyboardCurr = :keyboardCurr"),
    @NamedQuery(name = "Pwae.findByKeyboardRec", query = "SELECT p FROM Pwae p WHERE p.keyboardRec = :keyboardRec"),
    @NamedQuery(name = "Pwae.findByKeyboardSit", query = "SELECT p FROM Pwae p WHERE p.keyboardSit = :keyboardSit")})
public class Pwae implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pwaeId")
    private Integer pwaeId;
    @Size(max = 45)
    @Column(name = "elbowCurr")
    private String elbowCurr;
    @Size(max = 45)
    @Column(name = "elbowRec")
    private String elbowRec;
    @Size(max = 45)
    @Column(name = "elbowSit")
    private String elbowSit;
    @Size(max = 45)
    @Column(name = "eyeCurr")
    private String eyeCurr;
    @Size(max = 45)
    @Column(name = "eyeRec")
    private String eyeRec;
    @Size(max = 45)
    @Column(name = "eyeSit")
    private String eyeSit;
    @Size(max = 45)
    @Column(name = "deskCurr")
    private String deskCurr;
    @Size(max = 45)
    @Column(name = "deskRec")
    private String deskRec;
    @Size(max = 45)
    @Column(name = "deskSit")
    private String deskSit;
    @Size(max = 45)
    @Column(name = "chairNote")
    private String chairNote;
    @Size(max = 45)
    @Column(name = "monitorNote")
    private String monitorNote;
    @Size(max = 45)
    @Column(name = "inputNote")
    private String inputNote;
    @Size(max = 45)
    @Column(name = "deskNote")
    private String deskNote;
    @Size(max = 45)
    @Column(name = "accessoriesNote")
    private String accessoriesNote;
    @Size(max = 45)
    @Column(name = "keyboardCurr")
    private String keyboardCurr;
    @Size(max = 45)
    @Column(name = "keyboardRec")
    private String keyboardRec;
    @Size(max = 45)
    @Column(name = "keyboardSit")
    private String keyboardSit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaeIdsite")
    private List<SiteRec> siteRecList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pwaeId")
    private List<Monitor> monitorList;
    @OneToMany(mappedBy = "pwaId")
    private List<Assessment> assessmentList;

    /**
     * The default constructor with no parameters. Will create a Pwae object with no variables. 
     */
    public Pwae() {
    }

    /**
     * Assessment Object constructor. takes in the pwaeId as a parameter during object construction and sets it as an object variable. 
     * Pre - Parameter must be an integer. 
     * Post - the pwaeId is set as the object variable. 
     * 
     * @param pwaeId - using this parameter, the Assessment will update the object variable. 
     */
    public Pwae(Integer pwaeId) {
        this.pwaeId = pwaeId;
    }

    /**
     * Returns the pwaeId value of the object. 
     * pre - the Object must have a locationId. 
     * 
     * @return - An Integer value that represents the Object's pwaeId. 
     */
    public Integer getPwaeId() {
        return pwaeId;
    }

    /**
     * Takes in a parameter and sets the pwaeId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the pwaeId value has been updated.
     * 
     * @param pwaeId - An Integer value that represents the Object's pwaeId that will replace the current value. 
     */
    public void setPwaeId(Integer pwaeId) {
        this.pwaeId = pwaeId;
    }

    /**
     * Returns the elbowCurr value of the object. 
     * pre - the Object must have a elbowCurr. 
     * 
     * @return - A String value that represents the Object's elbowCurr. 
     */
    public String getElbowCurr() {
        return elbowCurr;
    }

    /**
     * Takes in a parameter and sets the elbowCurr object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the elbowCurr value has been updated.
     * 
     * @param elbowCurr - An Integer value that represents the Object's pwaeId that will replace the current value. 
     */
    public void setElbowCurr(String elbowCurr) {
        this.elbowCurr = elbowCurr;
    }

    /**
     * Returns the elbowRec value of the object. 
     * pre - the Object must have a elbowRec. 
     * 
     * @return - A String value that represents the Object's elbowRec. 
     */
    public String getElbowRec() {
        return elbowRec;
    }

    /**
     * Takes in a parameter and sets the elbowRec object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the elbowRec value has been updated.
     * 
     * @param elbowRec - An Integer value that represents the Object's elbowRec that will replace the current value. 
     */
    public void setElbowRec(String elbowRec) {
        this.elbowRec = elbowRec;
    }

    /**
     * Returns the elbowSit value of the object. 
     * pre - the Object must have a elbowSit. 
     * 
     * @return - A String value that represents the Object's elbowSit. 
     */
    public String getElbowSit() {
        return elbowSit;
    }

    /**
     * Takes in a parameter and sets the elbowSit object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the elbowSit value has been updated.
     * 
     * @param elbowSit - An Integer value that represents the Object's elbowSit that will replace the current value. 
     */
    public void setElbowSit(String elbowSit) {
        this.elbowSit = elbowSit;
    }

    /**
     * Returns the eyeCurr value of the object. 
     * pre - the Object must have a eyeCurr. 
     * 
     * @return - A String value that represents the Object's eyeCurr. 
     */
    public String getEyeCurr() {
        return eyeCurr;
    }

    /**
     * Takes in a parameter and sets the eyeCurr object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the eyeCurr value has been updated.
     * 
     * @param eyeCurr - An Integer value that represents the Object's eyeCurr that will replace the current value. 
     */
    public void setEyeCurr(String eyeCurr) {
        this.eyeCurr = eyeCurr;
    }

    /**
     * Returns the eyeRec value of the object. 
     * pre - the Object must have a eyeRec. 
     * 
     * @return - A String value that represents the Object's eyeRec. 
     */
    public String getEyeRec() {
        return eyeRec;
    }

    /**
     * Takes in a parameter and sets the eyeRec object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the eyeCurr value has been updated.
     * 
     * @param eyeRec - An Integer value that represents the Object's eyeRec that will replace the current value. 
     */
    public void setEyeRec(String eyeRec) {
        this.eyeRec = eyeRec;
    }

    /**
     * Returns the eyeSit value of the object. 
     * pre - the Object must have a eyeSit. 
     * 
     * @return - An Integer value that represents the Object's eyeSit. 
     */
    public String getEyeSit() {
        return eyeSit;
    }

    /**
     * Takes in a parameter and sets the eyeSit object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the eyeSit value has been updated.
     * 
     * @param eyeSit - An Integer value that represents the Object's eyeSit that will replace the current value. 
     */
    public void setEyeSit(String eyeSit) {
        this.eyeSit = eyeSit;
    }

    /**
     * Returns the deskCurr value of the object. 
     * pre - the Object must have a deskCurr. 
     * 
     * @return - An Integer value that represents the Object's deskCurr. 
     */
    public String getDeskCurr() {
        return deskCurr;
    }

    /**
     * Takes in a parameter and sets the deskCurr object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the deskCurr value has been updated.
     * 
     * @param deskCurr - An Integer value that represents the Object's deskCurr that will replace the current value. 
     */
    public void setDeskCurr(String deskCurr) {
        this.deskCurr = deskCurr;
    }

    /**
     * Returns the deskRec value of the object. 
     * pre - the Object must have a deskRec. 
     * 
     * @return - An Integer value that represents the Object's deskRec. 
     */
    public String getDeskRec() {
        return deskRec;
    }

    /**
     * Takes in a parameter and sets the deskRec object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the deskRec value has been updated.
     * 
     * @param deskRec - An Integer value that represents the Object's deskRec that will replace the current value. 
     */
    public void setDeskRec(String deskRec) {
        this.deskRec = deskRec;
    }

    /**
     * Returns the deskSit value of the object. 
     * pre - the Object must have a deskSit. 
     * 
     * @return - An Integer value that represents the Object's deskSit. 
     */
    public String getDeskSit() {
        return deskSit;
    }
    
    /**
     * Takes in a parameter and sets the deskSit object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the deskSit value has been updated.
     * 
     * @param deskSit - An Integer value that represents the Object's deskSit that will replace the current value. 
     */
    public void setDeskSit(String deskSit) {
        this.deskSit = deskSit;
    }

    /**
     * Returns the chairNote value of the object. 
     * pre - the Object must have a chairNote. 
     * 
     * @return - An Integer value that represents the Object's chairNote. 
     */
    public String getChairNote() {
        return chairNote;
    }

    /**
     * Takes in a parameter and sets the chairNote object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the chairNote value has been updated.
     * 
     * @param chairNote - An Integer value that represents the Object's chairNote that will replace the current value. 
     */
    public void setChairNote(String chairNote) {
        this.chairNote = chairNote;
    }

    /**
     * Returns the monitorNote value of the object. 
     * pre - the Object must have a monitorNote. 
     * 
     * @return - An Integer value that represents the Object's monitorNote. 
     */
    public String getMonitorNote() {
        return monitorNote;
    }

    /**
     * Takes in a parameter and sets the monitorNote object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the monitorNote value has been updated.
     * 
     * @param monitorNote - An Integer value that represents the Object's monitorNote that will replace the current value. 
     */
    public void setMonitorNote(String monitorNote) {
        this.monitorNote = monitorNote;
    }

    /**
     * Returns the inputNote value of the object. 
     * pre - the Object must have a inputNote. 
     * 
     * @return - An Integer value that represents the Object's inputNote. 
     */
    public String getInputNote() {
        return inputNote;
    }

    /**
     * Takes in a parameter and sets the inputNote object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the inputNote value has been updated.
     * 
     * @param inputNote - An Integer value that represents the Object's inputNote that will replace the current value. 
     */
    public void setInputNote(String inputNote) {
        this.inputNote = inputNote;
    }

    /**
     * Returns the deskNote value of the object. 
     * pre - the Object must have a deskNote. 
     * 
     * @return - An Integer value that represents the Object's deskNote. 
     */
    public String getDeskNote() {
        return deskNote;
    }

    /**
     * Takes in a parameter and sets the deskNote object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the deskNote value has been updated.
     * 
     * @param deskNote - An Integer value that represents the Object's deskNote that will replace the current value. 
     */
    public void setDeskNote(String deskNote) {
        this.deskNote = deskNote;
    }

    /**
     * Returns the accessoriesNote value of the object. 
     * pre - the Object must have a accessoriesNote. 
     * 
     * @return - An Integer value that represents the Object's accessoriesNote. 
     */
    public String getAccessoriesNote() {
        return accessoriesNote;
    }

    /**
     * Takes in a parameter and sets the accessoriesNote object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the deskNote value has been updated.
     * 
     * @param accessoriesNote - An Integer value that represents the Object's deskNote that will replace the current value. 
     */
    public void setAccessoriesNote(String accessoriesNote) {
        this.accessoriesNote = accessoriesNote;
    }

    /**
     * Returns the keyboardCurr value of the object. 
     * pre - the Object must have a keyboardCurr. 
     * 
     * @return - An Integer value that represents the Object's keyboardCurr. 
     */
    public String getKeyboardCurr() {
        return keyboardCurr;
    }

    /**
     * Takes in a parameter and sets the keyboardCurr object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the keyboardCurr value has been updated.
     * 
     * @param keyboardCurr - An Integer value that represents the Object's deskNote that will replace the current value. 
     */
    public void setKeyboardCurr(String keyboardCurr) {
        this.keyboardCurr = keyboardCurr;
    }

    /**
     * Returns the keyboardRec value of the object. 
     * pre - the Object must have a keyboardRec. 
     * 
     * @return - An Integer value that represents the Object's keyboardRec. 
     */
    public String getKeyboardRec() {
        return keyboardRec;
    }

    /**
     * Takes in a parameter and sets the keyboardRec object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the keyboardRec value has been updated.
     * 
     * @param keyboardRec - An Integer value that represents the Object's keyboardRec that will replace the current value. 
     */
    public void setKeyboardRec(String keyboardRec) {
        this.keyboardRec = keyboardRec;
    }

    /**
     * Returns the keyboardSit value of the object. 
     * pre - the Object must have a keyboardSit. 
     * 
     * @return - An Integer value that represents the Object's keyboardSit. 
     */
    public String getKeyboardSit() {
        return keyboardSit;
    }

    /**
     * Takes in a parameter and sets the keyboardSit object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the keyboardSit value has been updated.
     * 
     * @param keyboardSit - An Integer value that represents the Object's keyboardSit that will replace the current value. 
     */
    public void setKeyboardSit(String keyboardSit) {
        this.keyboardSit = keyboardSit;
    }

    /**
     * Returns the siteRecList list of the object. 
     * pre - the object must have a siteRecList list. 
     * 
     * @return - A Java.util.list value that represents the Object's siteRecList list. 
     */
    @XmlTransient
    public List<SiteRec> getSiteRecList() {
        return siteRecList;
    }

    public void setSiteRecList(List<SiteRec> siteRecList) {
        this.siteRecList = siteRecList;
    }

    /**
     * Returns the monitorList list of the object. 
     * pre - the object must have a monitorList list. 
     * 
     * @return - A Java.util.list value that represents the Object's monitorList list. 
     */
    @XmlTransient
    public List<Monitor> getMonitorList() {
        return monitorList;
    }

    /**
     * Takes in a parameter and sets the monitorList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the monitorList has been updated.
     * 
     * @param monitorList - A java.util.list object that is going to replace the current list. 
     */
    public void setMonitorList(List<Monitor> monitorList) {
        this.monitorList = monitorList;
    }

    /**
     * Returns the assessmentList list of the object. 
     * pre - the object must have a assessmentList list. 
     * 
     * @return - A Java.util.list value that represents the Object's assessmentList list. 
     */
    @XmlTransient
    public List<Assessment> getAssessmentList() {
        return assessmentList;
    }

    /**
     * Takes in a parameter and sets the assessmentList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the assessmentList has been updated.
     * 
     * @param assessmentList - A java.util.list object that is going to replace the current list. 
     */
    public void setAssessmentList(List<Assessment> assessmentList) {
        this.assessmentList = assessmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pwaeId != null ? pwaeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pwae)) {
            return false;
        }
        Pwae other = (Pwae) object;
        if ((this.pwaeId == null && other.pwaeId != null) || (this.pwaeId != null && !this.pwaeId.equals(other.pwaeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Pwae[ pwaeId=" + pwaeId + " ]";
    }
    
}
