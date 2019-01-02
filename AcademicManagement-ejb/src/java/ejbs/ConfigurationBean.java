/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ConfigurationDTO;
import dtos.TemplateDTO;
import entities.Client;
import entities.Configuration;
import entities.ConfigurationState;
import entities.Software;
import entities.Template;
import exceptions.EntityDoesNotExistException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
        Software soft = softwareBean.findOrFail(dto.getIdSoftware());
        Configuration conf = toEntity(dto);
        conf.setSoftware(soft);
        conf = create(conf);
        return toDTO(conf);
    }
    
    @GET
    @Path("/state/{state}/{username}/")    
    public List<ConfigurationDTO> getClientConfigWithId(@PathParam("username") String username, @PathParam("state") String state) {
        Query query = createNamedQuery("getConfigsWithStateForClient");
        query.setParameter("username", username);
        query.setParameter("state", ConfigurationState.valueOf(state));
        return toDTOs(query.getResultList());
    }
/*
    @Override
    protected Configuration create(Configuration entity) {
        Configuration conf = super.create(entity);
        try {
            sendEmailToClient(conf.getSoftware().getClient().getEmail(), conf.getName(), "Create new configuration");
        } catch (MessagingException ex) {
            Logger.getLogger(ConfigurationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conf; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Configuration update(Configuration entity) {
        Configuration conf =  super.update(entity);
        try {
            sendEmailToClient(entity.getSoftware().getClient().getEmail(), conf.getName(), "Update a configuration");
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
           // System.out.println("-----------------------------> "+ conf.getSofconf.getSoftware().getClient().getEmail(),conf.getName(tware().getClient().getEmail());
            sendEmailToClient(conf.getSoftware().getClient().getEmail(),conf.getName(), "Delete a configuration");
        } catch (MessagingException ex) {
            Logger.getLogger(ConfigurationBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux; //To change body of generated methods, choose Tools | Templates.
    }
    */
    
    
    
    
    private void sendEmailToClient(String email,String confName, String subject) throws MessagingException {
        //Client client = clientBean.findOrFail(username);
        try {

            emailBean.send(email, subject+" "+ confName, "Hello dear client ,\n we "+subject+" '"+confName+"' in your software.\n\n Thank you, from \n DAE_PROJECT " );
        
        } catch (MessagingException  e) {
            throw e;
        }
    }
}
