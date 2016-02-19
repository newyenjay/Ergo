/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ergo.businesslogic;

import ergo.dataacess.ClientRepository;
import ergo.domainmodel.Client;
import java.util.List;
/**
 *
 * @author Kimberly Oshiro WOWIE LOOKIT THIS SHIT
 * this'll be the service that will handle the calls for the Employee repository. I'm looking forward for what can be done here, no editing calls will probably be
 * actually need to be implemented in the interface I don't think, but It's going to be here in the class. Just in case. You never know what could happen, you know? 
 * 
 * @version 1.0 Adding stuff, Wowie rick. I have rick and morty on in the background, and I don't know what's happening. 
 */
public class ClientService {
    private static ClientRepository cr; //I figured it'd be easier just to have a variable instantiated already instead of having to create a new one every time.
    
    //add
    public int add(Client client)throws Exception{
       cr = new ClientRepository();
       return cr.insert(client);
    }
    
    //remove
    public int remove(Client client)throws Exception{
        cr = new ClientRepository();
        return cr.delete(client);
    }
    
    //update
    public int update(Client client) throws Exception{
        cr = new ClientRepository();
        return cr.update(client);
    } //I'm not sure if it's a new client object or not but it's something similar. I'll have to figure it out earlier. 
    
    //get
    public Client getUserId(int clientId)throws Exception{
        cr = new ClientRepository();
        return cr.getUserId(clientId);
    }
    
    public Client getUserEmail(String email)throws Exception{
        cr = new ClientRepository();
        return cr.getUserEmail(email);
    }
    //getall
    public List<Client> getAll()throws Exception{
        cr = new ClientRepository();
        return cr.getAll();
    }
    
}
