/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ClientDTO;
import entities.Administrator;
import entities.Client;
import entities.UserGroup;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.Path;
import util.Encryptor;

/**
 *
 * @author lucas
 */
@Stateless
@Path("clients")
public class ClientBean extends Bean<Client, ClientDTO, String>{    
    @Override
    protected Client create(Client entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Client, entity));
        entity.setPassword(Encryptor.hash(entity.getPassword(), "SHA-256"));
        return super.create(entity);
    }
    
    @Override
    protected Client update(Client entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Client, entity));
        Query query = createNamedQuery("Client.pass").setParameter("username", entity.getUsername());
        String encryptedPassword = (String) query.getSingleResult();
        
        if (! entity.getPassword().equals(encryptedPassword)) {
            encryptPassword(entity);
        }
        
        return super.update(entity);
    }
    
    private void encryptPassword(Client client) {
        client.setPassword(Encryptor.sha256(client.getPassword()));
    }
}
