/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 671402
 */
@Entity
@Table(name = "spm")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spm.findAll", query = "SELECT s FROM Spm s"),
    @NamedQuery(name = "Spm.findBySpmId", query = "SELECT s FROM Spm s WHERE s.spmId = :spmId"),
    @NamedQuery(name = "Spm.findByBaseBeBool", query = "SELECT s FROM Spm s WHERE s.baseBeBool = :baseBeBool"),
    @NamedQuery(name = "Spm.findByBaseAfBool", query = "SELECT s FROM Spm s WHERE s.baseAfBool = :baseAfBool"),
    @NamedQuery(name = "Spm.findByShoulderBeBool", query = "SELECT s FROM Spm s WHERE s.shoulderBeBool = :shoulderBeBool"),
    @NamedQuery(name = "Spm.findByShoulderAfBool", query = "SELECT s FROM Spm s WHERE s.shoulderAfBool = :shoulderAfBool"),
    @NamedQuery(name = "Spm.findByArmBeBool", query = "SELECT s FROM Spm s WHERE s.armBeBool = :armBeBool"),
    @NamedQuery(name = "Spm.findByArmAfBool", query = "SELECT s FROM Spm s WHERE s.armAfBool = :armAfBool"),
    @NamedQuery(name = "Spm.findByBaseBeNotes", query = "SELECT s FROM Spm s WHERE s.baseBeNotes = :baseBeNotes"),
    @NamedQuery(name = "Spm.findByBaseAfNotes", query = "SELECT s FROM Spm s WHERE s.baseAfNotes = :baseAfNotes"),
    @NamedQuery(name = "Spm.findByShoulderBeNotes", query = "SELECT s FROM Spm s WHERE s.shoulderBeNotes = :shoulderBeNotes"),
    @NamedQuery(name = "Spm.findByShoulderAfNotes", query = "SELECT s FROM Spm s WHERE s.shoulderAfNotes = :shoulderAfNotes"),
    @NamedQuery(name = "Spm.findByArmBeNotes", query = "SELECT s FROM Spm s WHERE s.armBeNotes = :armBeNotes"),
    @NamedQuery(name = "Spm.findByArmAfNotes", query = "SELECT s FROM Spm s WHERE s.armAfNotes = :armAfNotes")})
public class Spm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "spmId")
    private Integer spmId;
    @Column(name = "baseBeBool")
    private Boolean baseBeBool;
    @Column(name = "baseAfBool")
    private Boolean baseAfBool;
    @Column(name = "shoulderBeBool")
    private Boolean shoulderBeBool;
    @Column(name = "shoulderAfBool")
    private Boolean shoulderAfBool;
    @Column(name = "armBeBool")
    private Boolean armBeBool;
    @Column(name = "armAfBool")
    private Boolean armAfBool;
    @Size(max = 250)
    @Column(name = "baseBeNotes")
    private String baseBeNotes;
    @Size(max = 250)
    @Column(name = "baseAfNotes")
    private String baseAfNotes;
    @Size(max = 250)
    @Column(name = "shoulderBeNotes")
    private String shoulderBeNotes;
    @Size(max = 250)
    @Column(name = "shoulderAfNotes")
    private String shoulderAfNotes;
    @Size(max = 250)
    @Column(name = "armBeNotes")
    private String armBeNotes;
    @Size(max = 250)
    @Column(name = "armAfNotes")
    private String armAfNotes;

    /**
     * The default Spm constructor, sets up the object with all default nulls. 
     */
    public Spm() {
    }

    /**
     * Instantiates the Location Object with one Parameter, that being the spmId. 
     * @param spmId 
     */
    public Spm(Integer spmId) {
        this.spmId = spmId;
    }

    /**
     * Returns the spmId value of the object. 
     * pre - the Object must have a spmId. 
     * 
     * @return - A boolean value that represents the Object's spmId. 
     */
    public Integer getSpmId() {
        return spmId;
    }

    /**
     * Takes in a parameter and sets the spmId object variable to that parameters. 
     * Pre - the Parameter must be A boolean.
     * post - the spmId value has been updated.
     * 
     * @param spmId - A boolean value that represents the Object's spmId that will replace the current value. 
     */
    public void setSpmId(Integer spmId) {
        this.spmId = spmId;
    }

    /**
     * Returns the baseBeBool value of the object. 
     * pre - the Object must have a baseBeBool. 
     * 
     * @return - A boolean value that represents the Object's baseBeBool. 
     */
    public Boolean getBaseBeBool() {
        return baseBeBool;
    }

    /**
     * Takes in a parameter and sets the baseBeBool object variable to that parameters. 
     * Pre - the Parameter must be a boolean.
     * post - the baseBeBool value has been updated.
     * 
     * @param baseBeBool - A boolean value that represents the Object's baseBeBool that will replace the current value. 
     */
    public void setBaseBeBool(Boolean baseBeBool) {
        this.baseBeBool = baseBeBool;
    }

     /**
     * Returns the baseAfBool value of the object. 
     * pre - the Object must have a baseAfBool. 
     * 
     * @return - A boolean value that represents the Object's baseAfBool. 
     */
    public Boolean getBaseAfBool() {
        return baseAfBool;
    }

    /**
     * Takes in a parameter and sets the baseAfBool object variable to that parameters. 
     * Pre - the Parameter must be a boolean.
     * post - the baseAfBool value has been updated.
     * 
     * @param baseAfBool - A boolean value that represents the Object's baseAfBool that will replace the current value. 
     */
    public void setBaseAfBool(Boolean baseAfBool) {
        this.baseAfBool = baseAfBool;
    }

    /**
     * Returns the shoulderBeBool value of the object. 
     * pre - the Object must have a shoulderBeBool. 
     * 
     * @return - A boolean value that represents the Object's shoulderBeBool. 
     */
    public Boolean getShoulderBeBool() {
        return shoulderBeBool;
    }

    /**
     * Takes in a parameter and sets the shoulderBeBool object variable to that parameters. 
     * Pre - the Parameter must be A boolean.
     * post - the shoulderBeBool value has been updated.
     * 
     * @param shoulderBeBool -A boolean value that represents the Object's shoulderBeBool that will replace the current value. 
     */
    public void setShoulderBeBool(Boolean shoulderBeBool) {
        this.shoulderBeBool = shoulderBeBool;
    }

    /**
     * Returns the shoulderAfBool value of the object. 
     * pre - the Object must have a shoulderAfBool. 
     * 
     * @return - A boolean value that represents the Object's shoulderAfBool. 
     */
    public Boolean getShoulderAfBool() {
        return shoulderAfBool;
    }

    /**
     * Takes in a parameter and sets the shoulderAfBool object variable to that parameters. 
     * Pre - the Parameter must be A boolean.
     * post - the shoulderAfBool value has been updated.
     * 
     * @param shoulderAfBool - A boolean value that represents the Object's shoulderAfBool that will replace the current value. 
     */
    public void setShoulderAfBool(Boolean shoulderAfBool) {
        this.shoulderAfBool = shoulderAfBool;
    }

    /**
     * Returns the armBeBool value of the object. 
     * pre - the Object must have a armBeBool. 
     * 
     * @return - An Integer value that represents the Object's armBeBool. 
     */
    public Boolean getArmBeBool() {
        return armBeBool;
    }

    /**
     * Takes in a parameter and sets the armBeBool object variable to that parameters. 
     * Pre - the Parameter must be A boolean.
     * post - the armBeBool value has been updated.
     * 
     * @param armBeBool - An Integer value that represents the Object's armBeBool that will replace the current value. 
     */
    public void setArmBeBool(Boolean armBeBool) {
        this.armBeBool = armBeBool;
    }

    /**
     * Returns the armAfBool value of the object. 
     * pre - the Object must have a armAfBool. 
     * 
     * @return - An Integer value that represents the Object's armAfBool. 
     */
    public Boolean getArmAfBool() {
        return armAfBool;
    }

    /**
     * Takes in a parameter and sets the armAfBool object variable to that parameters. 
     * Pre - the Parameter must be A boolean.
     * post - the armAfBool value has been updated.
     * 
     * @param armAfBool - A boolean value that represents the Object's armAfBool that will replace the current value. 
     */
    public void setArmAfBool(Boolean armAfBool) {
        this.armAfBool = armAfBool;
    }

    /**
     * Returns the baseBeNotes value of the object. 
     * pre - the Object must have a baseBeNotes. 
     * 
     * @return - A String value that represents the Object's baseBeNotes. 
     */
    public String getBaseBeNotes() {
        return baseBeNotes;
    }

     /**
     * Takes in a parameter and sets the baseBeNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the baseBeNotes value has been updated.
     * 
     * @param baseBeNotes - A String value that represents the Object's baseBeNotes that will replace the current value. 
     */
    public void setBaseBeNotes(String baseBeNotes) {
        this.baseBeNotes = baseBeNotes;
    }

    /**
     * Returns the baseAfNotes value of the object. 
     * pre - the Object must have a baseAfNotes. 
     * 
     * @return - A String value that represents the Object's baseAfNotes. 
     */
    public String getBaseAfNotes() {
        return baseAfNotes;
    }

     /**
     * Takes in a parameter and sets the baseAfNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the baseAfNotes value has been updated.
     * 
     * @param baseAfNotes - A String value that represents the Object's baseAfNotes that will replace the current value. 
     */
    public void setBaseAfNotes(String baseAfNotes) {
        this.baseAfNotes = baseAfNotes;
    }

    /**
     * Returns the shoulderBeNotes value of the object. 
     * pre - the Object must have a shoulderBeNotes. 
     * 
     * @return - A String value that represents the Object's shoulderBeNotes. 
     */
    public String getShoulderBeNotes() {
        return shoulderBeNotes;
    }

    /**
     * Takes in a parameter and sets the shoulderBeNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the shoulderBeNotes value has been updated.
     * 
     * @param shoulderBeNotes - A String value that represents the Object's shoulderBeNotes that will replace the current value. 
     */
    public void setShoulderBeNotes(String shoulderBeNotes) {
        this.shoulderBeNotes = shoulderBeNotes;
    }

    /**
     * Returns the shoulderAfNotes value of the object. 
     * pre - the Object must have a shoulderAfNotes. 
     * 
     * @return - A String value that represents the Object's shoulderAfNotes. 
     */
    public String getShoulderAfNotes() {
        return shoulderAfNotes;
    }

    /**
     * Takes in a parameter and sets the shoulderAfNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the shoulderAfNotes value has been updated.
     * 
     * @param shoulderAfNotes - A String value that represents the Object's shoulderAfNotes that will replace the current value. 
     */
    public void setShoulderAfNotes(String shoulderAfNotes) {
        this.shoulderAfNotes = shoulderAfNotes;
    }

    /**
     * Returns the armBeNotes value of the object. 
     * pre - the Object must have a armBeNotes. 
     * 
     * @return - An Integer value that represents the Object's armBeNotes. 
     */
    public String getArmBeNotes() {
        return armBeNotes;
    }

    /**
     * Takes in a parameter and sets the armBeNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the armBeNotes value has been updated.
     * 
     * @param armBeNotes - A String value that represents the Object's armBeNotes that will replace the current value. 
     */
    public void setArmBeNotes(String armBeNotes) {
        this.armBeNotes = armBeNotes;
    }

     /**
     * Returns the armAfNotes value of the object. 
     * pre - the Object must have a armAfNotes. 
     * 
     * @return - A String value that represents the Object's armAfNotes. 
     */
    public String getArmAfNotes() {
        return armAfNotes;
    }

    /**
     * Takes in a parameter and sets the armAfNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the armAfNotes value has been updated.
     * 
     * @param armAfNotes - A Strings value that represents the Object's armAfNotes that will replace the current value. 
     */
    public void setArmAfNotes(String armAfNotes) {
        this.armAfNotes = armAfNotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (spmId != null ? spmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Spm)) {
            return false;
        }
        Spm other = (Spm) object;
        if ((this.spmId == null && other.spmId != null) || (this.spmId != null && !this.spmId.equals(other.spmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Spm[ spmId=" + spmId + " ]";
    }
    
}
