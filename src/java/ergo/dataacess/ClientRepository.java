/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

import java.util.List;
import javax.persistence.EntityManager;
import ergo.domainmodel.Client;
/**
 *
 * @author Kimberly Oshiro
 * 
 * The actual interface that interacts with the database. adding, editing, or removing any of these methods is something that is I would not recommend, for 
 * tampering with any of these methods may result in  unwanted database corruption. 
 * 
 * @version 1.0 - Changed the name to ClientRepository from ClientDB - It was decided amongst the capstone that it was better to refer to it as a repository. 
 * 
 */
public class ClientRepository {
    
    /**
     * Searches through the client table in the database for a client based on their clientId, and will return a Client object from the database that is created from
     * the JPA query. 
     * 
     * @param clientId - the value that's given to the method that will search through the database that will search for the client based n the ID. 
     * @return a Client Object that is created from the database query that is searching for a client based on the clientID. 
     */
    public Client getClient(int clientId)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Client client = em.find(Client.class, clientId); //this will need to be fixed because the variable type might not be exactly the same. 3
            return client;
        } finally {
            em.close();    
        }
    }
    
    /**
     * Takes a Client object that is sent through from the ClientService, and updates the Client database row that correlates with it. 
     * 
     * @param client - the version of the Client Object that has information that is out of sync with the row in the database - the row in the database has to be
     * updated and the information must be persisted to the row. 
     * @return 1 if the update to the database is successful, if an error is thrown by the database, then there will be an error returned by the database,
     * and the methods further up will be notified, and 1 will not be returned. 
     */
    public int update(Client client) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(client);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    /**
     * Returns an ArrayList of all the clients in the database. 
     * @return - the ArrayList of the Client objects in the database. 
     */
    public List<Client> getAll()  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            List<Client> clients = em.createNamedQuery("Client.findAll", Client.class).
                    getResultList();
            return clients;
        } finally {
            em.close();    
        }
    }
    
    /**
     * Deletes a Client object from the database by referencing a client object. 
     * @param client - the object itself that should be deleted. 
     * @return - a 1 if the deletion from the database is successful, if an error is thrown from the database, the method leaves the try 
     * and goes into the finally, and does not return a 1. 
     */
    public int delete(Client client)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.merge(client));
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
   }
    
    /**
     * Inserts a new Client object to the database by taking the parameter Client object and using the instance variables and inserting them into the rows.
     * @param client - the object that will be referenced when inserting into the row. 
     * @return - a 1 if successful, if unsuccessful, nothing because the database will exit the try and will go into the finally clause and will return nothing. 
     */
    public int insert(Client client)  {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
            return 1;
        } finally {
            em.close();
        }
    }
    
    /**
     * Returns a client object with only the email field filled in from the database by searching by the email. If there is no user in the database with the email, then 
     * the method will return a null object. 
     * @param email - the string variable in which the database will be searching with. 
     * @return - the client object with the only instance variable that is filled will be the email, because the only field is required is the email. 
     */
    public Client getClientEmail(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            Client client = em.createNamedQuery("Client.findByEmail", Client.class).setParameter("email", email).getSingleResult();
            return client;
        } finally {
            em.close();    
        } 
    }
}
