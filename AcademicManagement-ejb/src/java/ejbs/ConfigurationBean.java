/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ConfigurationDTO;
import entities.Client;
import entities.Configuration;
import entities.Software;
import exceptions.EntityDoesNotExistException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.ws.rs.Path;

/**
 *
 * @author lucas
 */
@Stateless
@Path("/configurations")
public class ConfigurationBean extends Bean<Configuration, ConfigurationDTO, Integer>{
    @EJB
    EmailBean emailBean;   
    
    @EJB 
    ClientBean clientBean;
    
    @EJB
    SoftwareBean softwareBean;
     
    @Override
    public ConfigurationDTO create(ConfigurationDTO dto) {
        Configuration conf = toEntity(dto);
        Software soft = softwareBean.findOrFail(dto.getIdSoftware());
        conf.setSoftware(soft);
        conf = create(conf);
        return toDTO(conf);
    }

    /*@Override
    protected Configuration create(Configuration entity) {
        Configuration conf = super.create(entity);
        try {
            sendEmailToClient(conf.getSoftware().getClient().getEmail(), "Create new configuration");
        } catch (MessagingException ex) {
            Logger.getLogger(ConfigurationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Configuration update(Configuration entity) {
        Configuration conf =  super.update(entity);
        try {
            sendEmailToClient(entity.getSoftware().getClient().getEmail(), "Update a configuration");
        } catch (MessagingException ex) {
            Logger.getLogger(ConfigurationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Integer primaryKey) {
        Configuration conf = this.findOrFail(primaryKey);
        boolean aux = super.delete(primaryKey);
        try {
            sendEmailToClient(conf.getSoftware().getClient().getEmail(), "Delete a configuration");
        } catch (MessagingException ex) {
            Logger.getLogger(ConfigurationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }*/
    
    
    
    
    
    private void sendEmailToClient(String username, String subject) throws MessagingException {
        Client client = clientBean.findOrFail(username);
        try {

            emailBean.send(client.getEmail(), subject, "Hello " + client.getName()+", we "+subject+" your software.\n\n Thank you, from \n DAE_PROJECT " );
        
        } catch (MessagingException  e) {
            throw e;
        }
    }
}
