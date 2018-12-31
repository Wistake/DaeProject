/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.TemplateDTO;
import entities.Template;
import exceptions.EntityDoesNotExistException;
import exceptions.EntityExistsException;
import exceptions.MyConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolationException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import exceptions.Utils;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;

/**
 *
 * @author sergi
 */
@Stateless
@Path("/templates")
public class TemplateBean extends Bean<Template, TemplateDTO, Integer>{
    
    
    /*
    @PersistenceContext
    EntityManager em;
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("all")    
    public List<TemplateDTO> getAll() {
        try {
            List<Template> templates = (List<Template>) em.createNamedQuery("getAllTemplates").getResultList();
            return templatesToDTO(templates);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(TemplateDTO templateDTO) 
            throws
            EntityExistsException, 
            EntityDoesNotExistException,
            MyConstraintViolationException{
        try {
            Template template = em.find(Template.class, templateDTO.getIdName());
            if (template != null) {
                throw new EntityExistsException("A user with that template already exists.");
            }
                       
            template = new Template(
                    templateDTO.getIdName(), 
                    templateDTO.getDescricao());
            em.persist(template);
        }catch (ConstraintViolationException e){
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));
        }catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    
    @PUT
    @Path("updateREST1/{idName}/{descricao}/")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public void updateREST1(
            @PathParam("idName") Integer idName,
            @PathParam("descricao") String descricao) {
        try {
                        
            Template template = em.find(Template.class, idName);
            if (template == null) {
                return;
            }
            template.setIdName(idName);
            template.setDescricao(descricao);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @PUT
    @Path("/updateREST2")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateREST2(TemplateDTO templateDTO)
            throws EntityDoesNotExistException, MyConstraintViolationException {
        try {
            
            Template template = em.find(Template.class, templateDTO.getIdName());
            if (template == null) {
                throw new EntityDoesNotExistException("There is no template with that nameID.");
            }

            template.setIdName(templateDTO.getIdName());
            template.setDescricao(templateDTO.getDescricao());

        } catch (EntityDoesNotExistException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    @DELETE
    @Path("/remove/{idName}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public void remove(@PathParam("idName") Integer idName){
        try {
            Template template = em.find(Template.class, idName);
            if (template == null) {
                return;
            }
            em.remove(template);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }        
    }
    
    List<TemplateDTO> templatesToDTO(List<Template> templates) {
        List<TemplateDTO> dtos = new ArrayList<>();
        for (Template t : templates) {
            dtos.add(templateToDTO(t));
        }
        return dtos;
    }
    
    TemplateDTO templateToDTO(Template template) {
        return new TemplateDTO(
                template.getIdName(),
                template.getDescricao());
    }
*/
}
