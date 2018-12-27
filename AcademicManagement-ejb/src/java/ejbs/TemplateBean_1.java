/*package ejbs;

import dtos.AdministratorDTO;
import dtos.CargoDTO;
import dtos.TemplateDTO;
import entities.Administrator;
import entities.Cargo;
import entities.Template;
import exceptions.EntityDoesNotExistException;
import exceptions.EntityExistsException;
import exceptions.MyConstraintViolationException;
import exceptions.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/templates")
public class TemplateBean_1 extends Bean<Template>{
    @PersistenceContext
    EntityManager em;
    
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
    
    @GET
    @RolesAllowed({"Administrator"})
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
    
 
    /*
    @GET
    @RolesAllowed({"Administrator"})
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("all")        
    public Collection<TemplateDTO> getAllTemplates() {
        try {
            List<Template> templates
                    = em.createNamedQuery("getAllTemplates").getResultList();
            return toDTOs(templates, TemplateDTO.class);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("template/{idName}")        
    public TemplateDTO getTemplate(@PathParam("idName") int idName) {
        try {
            Template template = em.find(Template.class, idName);
            return templateToDTO(template);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    TemplateDTO templateToDTO(Template template) {
        return new TemplateDTO(
                template.getIdName(),
                template.getDescricao());
    }

    List<TemplateDTO> templatesToDTO(List<Template> templates) {
        List<TemplateDTO> dtos = new ArrayList<>();
        for (Template t : templates) {
            dtos.add(templateToDTO(t));
        }
        return dtos;
    } 
}*/
