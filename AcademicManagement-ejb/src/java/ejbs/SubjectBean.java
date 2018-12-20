package ejbs;

import dtos.SubjectDTO;
import entities.Course;
import entities.Student;
import entities.Subject;
import exceptions.EntityDoesNotExistException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/subjects")
public class SubjectBean extends Bean<Student> {

    @PersistenceContext
    EntityManager em;

    public void create(
            int code,
            String name,
            int courseCode,
            int courseYear,
            String scholarYear) {

        try {
            Course course = em.find(Course.class, courseCode);
            if (course == null) {
                return;
            }            
            Subject subject = new Subject(
                    code, 
                    name, 
                    course, 
                    courseYear,
                    scholarYear);
            em.persist(subject);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public List<Subject> getAll() {
        try {
            List<Subject> subjects
                    = em.createNamedQuery("getAllSubjects").getResultList();
            return subjects;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/student_subjects/{username}")        
    public Collection<SubjectDTO> getStudentSubjects(
            @PathParam("username") String username) throws EntityDoesNotExistException{
        try{
            Student student = em.find(Student.class, username);
            if(student == null){
                throw new EntityDoesNotExistException("Student does not exist");
            }
            
            return toDTOs(student.getSubjects(), SubjectDTO.class);
            
        }catch (EntityDoesNotExistException e) {
            throw e;
        }catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    List<SubjectDTO> subjectsToDTOs(List<Subject> subjects) {
        List<SubjectDTO> dtos = new ArrayList<>();
        for(Subject subject : subjects) {
            dtos.add(new SubjectDTO(
                    subject.getCode(),
                    subject.getName(),
                    subject.getCourse().getCode(),
                    subject.getCourse().getName(),
                    subject.getCourseYear(),
                    subject.getScholarYear()));
        }
        return dtos;
    }    
    
}
