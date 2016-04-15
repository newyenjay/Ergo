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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @version 1.0 - Inserting javadoc 14/04/2016
 */
@Entity
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientId", query = "SELECT c FROM Client c WHERE c.clientId = :clientId"),
    @NamedQuery(name = "Client.findByAssessmentId", query = "SELECT c FROM Client c WHERE c.assessmentId = :assessmentId"),
    @NamedQuery(name = "Client.findByFirstName", query = "SELECT c FROM Client c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "Client.findByLastName", query = "SELECT c FROM Client c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "Client.findByEmail", query = "SELECT c FROM Client c WHERE c.email = :email")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clientId")
    private Integer clientId;
    @Size(max = 45)
    @Column(name = "assessmentId")
    private String assessmentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "firstName")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "lastName")
    private String lastName;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @JoinTable(name = "clientemployee", joinColumns = {
        @JoinColumn(name = "clientId", referencedColumnName = "clientId")}, inverseJoinColumns = {
        @JoinColumn(name = "username", referencedColumnName = "username")})
    @ManyToMany
    private List<Employee> employeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private List<Assessment> assessmentList;
    @JoinColumn(name = "companyId", referencedColumnName = "companyId")
    @ManyToOne(optional = false)
    private Company companyId;

    /**
     * The Client Object's default empty constructor. Will construct the Object with default null variables. 
     */
    public Client() {
    }

    /**
     * Object constructor with the constructor parameter being the clientId, will set the clientId Object variable to the parameter, and set the rest of the values
     * to null. 
     * Pre - parameter given must be an Integer. 
     * Post - The object is created. 
     * 
     * @param clientId - An Integer value, the Client will use the parameter to instantiate the Client object. 
     */
    public Client(Integer clientId) {
        this.clientId = clientId;
    }

     /**
     * Full Client constructor, takes parameters and instantiates a client object. 
     * Pre - The parameters given must all be to the Object type that is specified. 
     * 
     * @param clientId - clientId parameter, will be used to set up the Object Variable. Integer.
     * @param firstName - firstName, used to instantiate the first name, Object Variable String variable
     * @param lastName  - lastName, used to instantiate the last name, Object Variable String variable. 
     */
    public Client(Integer clientId, String firstName, String lastName) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Returns the clientId object variable. 
     * Pre - the Object must have a ClientId. 
     * 
     * @return An Integer value that represents the Client's clientId. 
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * Takes in a parameter and sets the clientId local variable to that parameter.
     * pre - the parameter must be an Integer.
     * post - the clientId value has been updated.
     * 
     * @param clientId - An Integer value that is going to replace the current clientId value. 
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

     /**
     * Returns the assessmentId object variable. 
     * Pre - the Object must have a assessmentId. 
     * 
     * @return A String value that represents the Client's assessmentId. 
     */
    public String getAssessmentId() {
        return assessmentId;
    }

    /**
     * Takes in a parameter and sets the assessmentId local variable to that parameter.
     * pre - the parameter must be a String.
     * post - the assessmentId value has been updated.
     * 
     * @param assessmentId - A String value that is going to replace the current assessmentId value. 
     */
    public void setAssessmentId(String assessmentId) {
        this.assessmentId = assessmentId;
    }

    /**
     * Returns the firstName object variable. 
     * Pre - the Object must have a firstName. 
     * 
     * @return A String value that represents the Client's firstName. 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Takes in a parameter and sets the firstName local variable to that parameter.
     * pre - the parameter must be a String.
     * post - the firstName value has been updated.
     * 
     * @param firstName - A String value that is going to replace the current firstName value. 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the lastName object variable. 
     * Pre - the Object must have a lastName. 
     * 
     * @return A String value that represents the Client's lastName. 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Takes in a parameter and sets the lastName local variable to that parameter.
     * pre - the parameter must be a String.
     * post - the lastName value has been updated.
     * 
     * @param lastName - A String value that is going to replace the current lastName value. 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the email object variable. 
     * Pre - the Object must have a email. 
     * 
     * @return A String value that represents the Client's email. 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Takes in a parameter and sets the email local variable to that parameter.
     * pre - the parameter must be a String.
     * post - the email value has been updated.
     * 
     * @param email - A String value that is going to replace the current email value. 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the employeeList list of the object. 
     * pre - the object must have a employeeList list. 
     * 
     * @return - A Java.util.list value that represents the Object's employeeList list. 
     */
    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    /**
     * Takes in a parameter and sets the employeeList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the employeeList has been updated.
     * 
     * @param employeeList - A java.util.list object that is going to replace the current list. 
     */
    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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

    /**
     * Returns the companyId object variable. 
     * Pre - the Object must have a companyId. 
     * 
     * @return A Company Object that represents the Client's companyId. 
     */
    public Company getCompanyId() {
        return companyId;
    }

    /**
     * Takes in a parameter and sets the companyId local variable to that parameter.
     * pre - the parameter must be a Company object.
     * post - the companyId has been updated.
     * 
     * @param companyId - A Company object that is going to replace the current Company object. 
     */
    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientId != null ? clientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.clientId == null && other.clientId != null) || (this.clientId != null && !this.clientId.equals(other.clientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Client[ clientId=" + clientId + " ]";
    }
    
}
