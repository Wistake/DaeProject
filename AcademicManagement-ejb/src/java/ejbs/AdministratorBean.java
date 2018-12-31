package ejbs;

import dtos.AdministratorDTO;
import dtos.StudentDTO;
import entities.Administrator;
import entities.Cargo;
import entities.Course;
import entities.Student;
import entities.UserGroup;
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
import javax.persistence.Query;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import util.Encryptor;

@Stateless
@Path("administrators")
public class AdministratorBean extends Bean<Administrator, AdministratorDTO, String>{

    @Override
    protected Administrator create(Administrator entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Administrator, entity));
        entity.setPassword(Encryptor.hash(entity.getPassword(), "SHA-256"));
        return super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Administrator update(Administrator entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Administrator, entity));
        Query query = createNamedQuery("Administrator.pass").setParameter("username", entity.getUsername());
        String encryptedPassword = (String) query.getSingleResult();
        
        if (! entity.getPassword().equals(encryptedPassword)) {
            encryptPassword(entity);
        }
        
        return super.update(entity);
    }
    
    private void encryptPassword(Administrator adminstrator) {
        adminstrator.setPassword(Encryptor.sha256(adminstrator.getPassword()));
    }
    
    
/*
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
    
    @DELETE
    @Path("/remove/{username}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public void remove(@PathParam("username") String username){
        try {
            Administrator admin = em.find(Administrator.class, username);
            if (admin == null) {
                return;
            }
            em.remove(admin);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }        
    }
    
    @PUT
    @Path("updateREST1/{username}/{password}/{name}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public void updateREST1(
            @PathParam("username") String username,
            @PathParam("password") String password,
            @PathParam("name") String name,
            String email) {
        try {
                        
            Administrator admin = em.find(Administrator.class, username);
            if (admin == null) {
                return;
            }
            admin.setPassword(password);
            admin.setName(name);
            admin.setEmail(email);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @PUT
    @Path("/updateREST2")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateREST2(AdministratorDTO admininDTO)
            throws EntityDoesNotExistException, MyConstraintViolationException {
        try {
            
            Administrator admin = em.find(Administrator.class, admininDTO.getUsername());
            if (admin == null) {
                throw new EntityDoesNotExistException("There is no administrator with that username.");
            }

            admin.setPassword(admininDTO.getPassword());
            admin.setName(admininDTO.getName());
            admin.setEmail(admininDTO.getEmail());

        } catch (EntityDoesNotExistException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));
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
    */
}
