/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.SoftwareDTO;
import entities.Client;
import entities.Software;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 
 */
@Stateless
@Path("/softwares")
public class SoftwareBean extends Bean<Software, SoftwareDTO, Integer>{

    @EJB
    private ClientBean clientBean;
    @Override
    public SoftwareDTO create(SoftwareDTO dto) {
        Client client = clientBean.findOrFail(dto.getClienteUsername());
        Software soft = toEntity(dto);
        soft.setClient(client);
        soft = create(soft);
        
        return toDTO(soft);
    }   
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    @Path("/clients/{username}")
    public List<SoftwareDTO> getSoftwaresOfClients(@PathParam("username") String username){
        Query query = createNamedQuery("Software.client");
        query.setParameter("username", username);
        
        return toDTOs(query.getResultList());
    }
}

