/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.dataacess;

/**
 *
 * @author Kimberly Oshiro
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DBUtil {
    private final static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("ErgoPU"); // This will have to be changed later. remember. 
    //The DBUtil isn't going to work when we first set up the database unless you set it up here. Remember. 
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
    
    public static void closeEmFactory() {
        emf.close();
    }
    
}