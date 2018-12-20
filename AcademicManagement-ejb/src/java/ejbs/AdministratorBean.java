package ejbs;

import dtos.AdministratorDTO;
import dtos.StudentDTO;
import entities.Administrator;
import entities.Cargo;
import entities.Course;
import entities.Student;
import exceptions.EntityDoesNotExistException;
import exceptions.EntityExistsException;
import exceptions.MyConstraintViolationException;
import exceptions.Utils;
import java.util.ArrayList;
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
@Path("/administrators")
public class AdministratorBean extends Bean<Administrator>{

    @PersistenceContext
    EntityManager em;
    
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AdministratorDTO adminDTO) 
            throws
            EntityExistsException, 
            EntityDoesNotExistException,
            MyConstraintViolationException{
        try {
            Administrator administrator = em.find(Administrator.class, adminDTO.getUsername());
            if (administrator != null) {
                throw new EntityExistsException("A user with that username already exists.");
            }
            
            Cargo cargo = em.find(Cargo.class, adminDTO.getCargoCode());
            if (cargo == null) {
                throw new EntityDoesNotExistException("There is no cargo with that code.");
            }            
            administrator = new Administrator(
                    adminDTO.getUsername(), 
                    adminDTO.getPassword(), 
                    adminDTO.getName(), 
                    adminDTO.getEmail(),
                    cargo);
            em.persist(administrator);
        }catch (EntityExistsException | EntityDoesNotExistException e) {
            throw e;
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
    public List<AdministratorDTO> getAll() {
        try {
            List<Administrator> administrators = (List<Administrator>) em.createNamedQuery("getAllAdministrators").getResultList();
            return administratorsToDTOs(administrators);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("administrator/{username}")        
    public AdministratorDTO getAdmin(@PathParam("username") String username) {
        try {
            Administrator admin = em.find(Administrator.class, username);
            return administratorsToDTOs(admin);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    List<AdministratorDTO> administratorsToDTOs(List<Administrator> administrators) {
        List<AdministratorDTO> dtos = new ArrayList<>();
        for (Administrator a : administrators) {
            dtos.add(administratorsToDTOs(a));
        }
        return dtos;
    } 

    AdministratorDTO administratorsToDTOs(Administrator administrator) {
        return new AdministratorDTO(
                administrator.getUsername(),
                null,
                administrator.getName(),
                administrator.getEmail(),
                administrator.getCargo().getCode(),
                administrator.getCargo().getName());
    }
    
}
