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
}
