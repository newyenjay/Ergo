/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.domainmodel;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @version 1.0 - Inserting Javadoc - 04/14/2016
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByUsername", query = "SELECT e FROM Employee e WHERE e.username = :username"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByPhoneNumber", query = "SELECT e FROM Employee e WHERE e.phoneNumber = :phoneNumber")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "username")
    private String username;
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private Integer phoneNumber;
    @ManyToMany(mappedBy = "employeeList")
    private List<Privilege> privilegeList;
    @ManyToMany(mappedBy = "employeeList")
    private List<Client> clientList;

    /**
     * The default Employee constructor, sets up the object with all default nulls. 
     * Pre - none
     */
    public Employee() {
    }

    /**
     * Instantiates the Company Object with one Parameter, that being the username. 
     * @param username - the parameter that the constructor will take in and will set the username to.
     */
    public Employee(String username) {
        this.username = username;
    }

    /**
     * Instantiates the Company Object with five parameters. Those being username, firstName, lastName, password, and email.
     * 
     * @param username
     * @param firstName
     * @param lastName
     * @param password
     * @param email 
     */
    public Employee(String username, String firstName, String lastName, String password, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }

    /**
     * Returns the username value of the object. 
     * pre - the Object must have a username. 
     * 
     * @return - A String value that represents the Object's username. 
     */
    public String getUsername() {
        return username;
    }

    /**
     * Takes in a parameter and sets the username object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the username value has been updated.
     * 
     * @param username - A String value that represents the Object's username that will replace the current value. 
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the firstName value of the object. 
     * pre - the Object must have a firstName. 
     * 
     * @return - A String value that represents the Object's firstName. 
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Takes in a parameter and sets the firstName object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the firstName value has been updated.
     * 
     * @param firstName - A String value that represents the Object's firstName that will replace the current value. 
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the lastName value of the object. 
     * pre - the Object must have a lastName. 
     * 
     * @return - A String value that represents the Object's lastName. 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Takes in a parameter and sets the lastName object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the lastName value has been updated.
     * 
     * @param lastName - A String value that represents the Object's lastName that will replace the current value. 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the password value of the object. 
     * pre - the Object must have a password. 
     * 
     * @return - A String value that represents the Object's password. 
     */
    public String getPassword() {
        return password;
    }

    /**
     * Takes in a parameter and sets the password object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the password value has been updated.
     * 
     * @param password - A String value that represents the Object's password that will replace the current value. 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the email value of the object. 
     * pre - the Object must have a email. 
     * 
     * @return - A String value that represents the Object's email. 
     */
    public String getEmail() {
        return email;
    }

    /**
     * Takes in a parameter and sets the email object variable to that parameters. 
     * Pre - the Parameter must be a String.
     * post - the email value has been updated.
     * 
     * @param email - A String value that represents the Object's email that will replace the current value. 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the phoneNumber value of the object. 
     * pre - the Object must have a phoneNumber. 
     * 
     * @return - An Integer value that represents the Object's phoneNumber. 
     */
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Takes in a parameter and sets the phoneNumber object variable to that parameters. 
     * Pre - the Parameter must be an Integer.
     * post - the phoneNumber value has been updated.
     * 
     * @param phoneNumber - An Integer value that represents the Object's phoneNumber that will replace the current value. 
     */
    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the privilegeList list of the object. 
     * pre - the object must have a privilegeList list. 
     * 
     * @return - A Java.util.list value that represents the Object's privilegeList list. 
     */
    @XmlTransient
    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    /**
     * Takes in a parameter and sets the privilegeList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the privilegeList has been updated.
     * 
     * @param privilegeList - A java.util.list object that is going to replace the current list. 
     */
    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    /**
     * Returns the privilegeList list of the object. 
     * pre - the object must have a privilegeList list. 
     * 
     * @return - A Java.util.list value that represents the Object's privilegeList list. 
     */
    @XmlTransient
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * Takes in a parameter and sets the clientList local variable to that parameter.
     * pre - the parameter must be a java.util.list.
     * post - the clientList has been updated.
     * 
     * @param clientList - A java.util.list object that is going to replace the current list. 
     */
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ergo.domainmodel.Employee[ username=" + username + " ]";
    }
    
}
