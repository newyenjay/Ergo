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
@Table(name = "pmb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pmb.findAll", query = "SELECT p FROM Pmb p"),
    @NamedQuery(name = "Pmb.findByPmbId", query = "SELECT p FROM Pmb p WHERE p.pmbId = :pmbId"),
    @NamedQuery(name = "Pmb.findByGoalMetBool", query = "SELECT p FROM Pmb p WHERE p.goalMetBool = :goalMetBool"),
    @NamedQuery(name = "Pmb.findByGoalMetNotes", query = "SELECT p FROM Pmb p WHERE p.goalMetNotes = :goalMetNotes"),
    @NamedQuery(name = "Pmb.findByEducBool", query = "SELECT p FROM Pmb p WHERE p.educBool = :educBool"),
    @NamedQuery(name = "Pmb.findByEducNotes", query = "SELECT p FROM Pmb p WHERE p.educNotes = :educNotes"),
    @NamedQuery(name = "Pmb.findByMicroBeBool", query = "SELECT p FROM Pmb p WHERE p.microBeBool = :microBeBool"),
    @NamedQuery(name = "Pmb.findByMicroBeNotes", query = "SELECT p FROM Pmb p WHERE p.microBeNotes = :microBeNotes"),
    @NamedQuery(name = "Pmb.findByMicroAfBool", query = "SELECT p FROM Pmb p WHERE p.microAfBool = :microAfBool"),
    @NamedQuery(name = "Pmb.findByMicroAfNotes", query = "SELECT p FROM Pmb p WHERE p.microAfNotes = :microAfNotes")})
public class Pmb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pmbId")
    private Integer pmbId;
    @Column(name = "goalMetBool")
    private Boolean goalMetBool;
    @Size(max = 250)
    @Column(name = "goalMetNotes")
    private String goalMetNotes;
    @Column(name = "educBool")
    private Boolean educBool;
    @Size(max = 250)
    @Column(name = "educNotes")
    private String educNotes;
    @Column(name = "microBeBool")
    private Boolean microBeBool;
    @Size(max = 250)
    @Column(name = "microBeNotes")
    private String microBeNotes;
    @Column(name = "microAfBool")
    private Boolean microAfBool;
    @Size(max = 250)
    @Column(name = "microAfNotes")
    private String microAfNotes;

    /**
     * The default Pmb constructor, sets up the object with all default nulls. 
     */
    public Pmb() {
    }

    /**
     * Instantiates the Location Object with one Parameter, that being the pmbId. 
     * @param pmbId 
     */
    public Pmb(Integer pmbId) {
        this.pmbId = pmbId;
    }

    /**
     * Returns the pmbId value of the object. 
     * pre - the Object must have a pmbId. 
     * 
     * @return - An Integer value that represents the Object's pmbId. 
     */
    public Integer getPmbId() {
        return pmbId;
    }

    /**
     * Takes in a parameter and sets the pmbId object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the pmbId value has been updated.
     * 
     * @param pmbId - An Integer value that represents the Object's pmbId that will replace the current value. 
     */
    public void setPmbId(Integer pmbId) {
        this.pmbId = pmbId;
    }

    /**
     * Returns the goalMetBool value of the object. 
     * pre - the Object must have a goalMetBool. 
     * 
     * @return - A boolean value that represents the Object's goalMetBool. 
     */
    public Boolean getGoalMetBool() {
        return goalMetBool;
    }

    /**
     * Takes in a parameter and sets the goalMetBool object variable to that parameters. 
     * Pre - the Parameter must be a boolean.
     * post - the goalMetBool value has been updated.
     * 
     * @param goalMetBool - A boolean value that represents the Object's goalMetBool that will replace the current value. 
     */
    public void setGoalMetBool(Boolean goalMetBool) {
        this.goalMetBool = goalMetBool;
    }

    /**
     * Returns the goalMetNotes value of the object. 
     * pre - the Object must have a goalMetNotes. 
     * 
     * @return - An Integer value that represents the Object's goalMetNotes. 
     */
    public String getGoalMetNotes() {
        return goalMetNotes;
    }

    /**
     * Takes in a parameter and sets the goalMetNotes object variable to that parameters. 
     * Pre - the Parameter must be a String .
     * post - the goalMetNotes value has been updated.
     * 
     * @param goalMetNotes - A String value that represents the Object's goalMetNotes that will replace the current value. 
     */
    public void setGoalMetNotes(String goalMetNotes) {
        this.goalMetNotes = goalMetNotes;
    }

    /**
     * Returns the educBool value of the object. 
     * pre - the Object must have a educBool. 
     * 
     * @return - An Integer value that represents the Object's educBool. 
     */
    public Boolean getEducBool() {
        return educBool;
    }

    /**
     * Takes in a parameter and sets the educBool object variable to that parameters. 
     * Pre - the Parameter must be a boolean.
     * post - the educBool value has been updated.
     * 
     * @param educBool - A boolean value that represents the Object's educBool that will replace the current value. 
     */
    public void setEducBool(Boolean educBool) {
        this.educBool = educBool;
    }

    /**
     * Returns the educNotes value of the object. 
     * pre - the Object must have a educNotes. 
     * 
     * @return - A String value that represents the Object's educNotes. 
     */
    public String getEducNotes() {
        return educNotes;
    }

    /**
     * Takes in a parameter and sets the educNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the educNotes value has been updated.
     * 
     * @param educNotes - A String value that represents the Object's educNotes that will replace the current value. 
     */
    public void setEducNotes(String educNotes) {
        this.educNotes = educNotes;
    }

    /**
     * Returns the microBeBool value of the object. 
     * pre - the Object must have a microBeBool. 
     * 
     * @return - A boolean value that represents the Object's microBeBool. 
     */
    public Boolean getMicroBeBool() {
        return microBeBool;
    }

    /**
     * Takes in a parameter and sets the microBeBool object variable to that parameters. 
     * Pre - the Parameter must be a boolean .
     * post - the microBeBool value has been updated.
     * 
     * @param microBeBool - A boolean value that represents the Object's microBeBool that will replace the current value. 
     */
    public void setMicroBeBool(Boolean microBeBool) {
        this.microBeBool = microBeBool;
    }

    /**
     * Returns the microBeNotes value of the object. 
     * pre - the Object must have a microBeNotes. 
     * 
     * @return - A String value that represents the Object's microBeNotes. 
     */
    public String getMicroBeNotes() {
        return microBeNotes;
    }

    /**
     * Takes in a parameter and sets the microBeNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the microBeNotes value has been updated.
     * 
     * @param microBeNotes - A String value that represents the Object's microBeNotes that will replace the current value. 
     */
    public void setMicroBeNotes(String microBeNotes) {
        this.microBeNotes = microBeNotes;
    }

    /**
     * Returns the microAfBool value of the object. 
     * pre - the Object must have a microAfBool. 
     * 
     * @return - A boolean value that represents the Object's microAfBool. 
     */
    public Boolean getMicroAfBool() {
        return microAfBool;
    }

    /**
     * Takes in a parameter and sets the microAfBool object variable to that parameters. 
     * Pre - the Parameter must be a boolean.
     * post - the microAfBool value has been updated.
     * 
     * @param microAfBool - A boolean value that represents the Object's microAfBool that will replace the current value. 
     */
    public void setMicroAfBool(Boolean microAfBool) {
        this.microAfBool = microAfBool;
    }

     /**
     * Returns the microAfNotes value of the object. 
     * pre - the Object must have a microAfNotes. 
     * 
     * @return - A String value that represents the Object's microAfNotes. 
     */
    public String getMicroAfNotes() {
        return microAfNotes;
    }

    /**
     * Takes in a parameter and sets the microAfNotes object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the microAfNotes value has been updated.
     * 
     * @param microAfNotes - A String value that represents the Object's microAfNotes that will replace the current value. 
     */
    public void setMicroAfNotes(String microAfNotes) {
        this.microAfNotes = microAfNotes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pmbId != null ? pmbId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pmb)) {
            return false;
        }
        Pmb other = (Pmb) object;
        if ((this.pmbId == null && other.pmbId != null) || (this.pmbId != null && !this.pmbId.equals(other.pmbId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Pmb[ pmbId=" + pmbId + " ]";
    }
    
}
