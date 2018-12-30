package ejbs;

import dtos.CourseDTO;
import entities.Course;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/courses")
public class CourseBean extends Bean<Course, CourseDTO, Integer>{
/*
    @PersistenceContext
    EntityManager em;
    
    //Falta getAll courses para mostrar na dropdown do create/update ???

    public void create(int code, String name) {
        try {
            Course course = new Course(code, name);
            em.persist(course);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("all")        
    public Collection<CourseDTO> getAll() {
        try {
            List<Course> courses
                    = em.createNamedQuery("getAllCourses").getResultList();
            return toDTOs(courses, CourseDTO.class);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void remove(int code){
        try {
            Course course = em.find(Course.class, code);
            if (course == null) {
                return;
            }
            em.remove(course);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }        
    }    */
}
