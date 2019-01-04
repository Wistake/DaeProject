/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import dtos.ConfigurationDTO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import lombok.Getter;
import lombok.Setter;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

@ManagedBean
@SessionScoped
@Named
public class ClientManager implements Serializable{
    private final Logger logger = Logger.getLogger("web.AdministratorManager");
    private final String baseUri = "http://localhost:8080/AcademicManagement-war/api";
    
    private Client client;
    
    private @Getter @Setter UIComponent component;
    private @Getter @Setter ConfigurationDTO currentConfig;
    
    //private @Getter @Setter ConfigurationDTO currentConfig;nao é preciso pq n é preciso editar, só ler

    public ClientManager() {
        client = ClientBuilder.newClient();
        currentConfig = new ConfigurationDTO();
    }
    
    @PostConstruct
    private void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        UserManager userManager = app.evaluateExpressionGet(context, "#{userManager}", UserManager.class);
        
        String username = userManager.getUsername();
        String password = userManager.getPassword();
        
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(username, password);
        client.register(feature);
    }
    
    public List<ConfigurationDTO> getAllConfigurations() {     
        try {
            //para ir buscar o user logado
           String username = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
            
           return client.target(baseUri)
                    .path("configurations/client/" + username)
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<ConfigurationDTO>>() {});
        } catch (Exception e) {
            logger.warning("Problem getting all templates in method getAllConfigurations."+e.getMessage());
            return null;
        }
    }
    
    
}
