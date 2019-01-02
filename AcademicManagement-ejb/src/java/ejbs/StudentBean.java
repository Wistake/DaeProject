package ejbs;

import dtos.DocumentDTO;
import dtos.StudentDTO;
import entities.Course;
import entities.Document;
import entities.Student;
import entities.Subject;
import entities.UserGroup;
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
@Path("/students")
public class StudentBean extends Bean<Student, StudentDTO, String>{
    
    @Override
    protected Student create(Student entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Student, entity));
        entity.setPassword(Encryptor.hash(entity.getPassword(), "SHA-256"));
        return super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected Student update(Student entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Student, entity));
        Query query = createNamedQuery("Student.pass").setParameter("username", entity.getUsername());
        String encryptedPassword = (String) query.getSingleResult();
        
        if (! entity.getPassword().equals(encryptedPassword)) {
            encryptPassword(entity);
        }
        
        return super.update(entity);
    }
    
    private void encryptPassword(Student student) {
        student.setPassword(Encryptor.sha256(student.getPassword()));
    }
/*
    @POST
    @Path("/create")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StudentDTO studentDTO) 
            throws
            EntityExistsException, 
            EntityDoesNotExistException,
            MyConstraintViolationException{
        try {
            Student student = em.find(Student.class, studentDTO.getUsername());
            if (student != null) {
                throw new EntityExistsException("A user with that username already exists.");
            }
            
            Course course = em.find(Course.class, studentDTO.getCourseCode());
            if (course == null) {
                throw new EntityDoesNotExistException("There is no course with that code.");
            }            
            student = new Student(
                    studentDTO.getUsername(), 
                    studentDTO.getPassword(), 
                    studentDTO.getName(), 
                    studentDTO.getEmail(),
                    course);
            em.persist(student);
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
    public List<StudentDTO> getAll() {
        try {
            List<Student> students = (List<Student>) em.createNamedQuery("getAllStudents").getResultList();
            return studentsToDTOs(students);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("student/{username}")        
    public StudentDTO getStudent(@PathParam("username") String username) {
        try {
            Student student = em.find(Student.class, username);
            return studentToDTO(student);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
    
    StudentDTO studentToDTO(Student student) {
        return new StudentDTO(
                student.getUsername(),
                null,
                student.getName(),
                student.getEmail(),
                student.getCourse().getCode(),
                student.getCourse().getName());
    }

    List<StudentDTO> studentsToDTOs(List<Student> students) {
        List<StudentDTO> dtos = new ArrayList<>();
        for (Student s : students) {
            dtos.add(studentToDTO(s));
        }
        return dtos;
    }   
    
    public void update(
            String username,
            String password,
            String name,
            String email) {
        try {
            Student student = em.find(Student.class, username);
            if (student == null) {
                return;
            }
            student.setPassword(password);
            student.setName(name);
            student.setEmail(email);
            //em.merge(student);
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
                        
            Student student = em.find(Student.class, username);
            if (student == null) {
                return;
            }
            student.setPassword(password);
            student.setName(name);
            student.setEmail(email);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @PUT
    @Path("/updateREST2")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void updateREST2(StudentDTO studentDTO)
            throws EntityDoesNotExistException, MyConstraintViolationException {
        try {
            
            Student student = em.find(Student.class, studentDTO.getUsername());
            if (student == null) {
                throw new EntityDoesNotExistException("There is no student with that username.");
            }

            student.setPassword(studentDTO.getPassword());
            student.setName(studentDTO.getName());
            student.setEmail(studentDTO.getEmail());

        } catch (EntityDoesNotExistException e) {
            throw e;
        } catch (ConstraintViolationException e) {
            throw new MyConstraintViolationException(Utils.getConstraintViolationMessages(e));
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @PUT
    @Path("/addDocument/{username}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addDocument(
            @PathParam("username") String username,
            DocumentDTO doc)
            throws EntityDoesNotExistException {
        try {
            Student student = em.find(Student.class, username);
            if (student == null) {
                throw new EntityDoesNotExistException("There is no student with such username.");
            }

            Document document = new Document(doc.getFilepath(), doc.getDesiredName(), doc.getMimeType(), student);
            em.persist(document);
            student.addDocument(document);

        } catch (EntityDoesNotExistException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }


    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/document/{id}")        
    public DocumentDTO getDocument(@PathParam("id") int id) throws EntityDoesNotExistException {
        Document doc = em.find(Document.class, id);
            
        if (doc == null)
            throw new EntityDoesNotExistException();

        return toDTO(doc, DocumentDTO.class);
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/documents/{username}")            
    public Collection<DocumentDTO> getDocuments(@PathParam("username") String username) throws EntityDoesNotExistException {
        try {
            List<Document> docs = em.createNamedQuery("getDocumentsOfStudent", Document.class).setParameter("username", username).getResultList();
            return toDTOs(docs, DocumentDTO.class);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public boolean hasDocuments(String username)
            throws EntityDoesNotExistException {
        try {
            Student student = em.find(Student.class, username);
            if (student == null) {
                throw new EntityDoesNotExistException("There is no user with such username.");
            }
            return !student.getDocuments().isEmpty();
        } catch (EntityDoesNotExistException e) {
            throw e;
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @DELETE
    @Path("/remove/{username}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})    
    public void remove(@PathParam("username") String username){
        try {
            Student student = em.find(Student.class, username);
            if (student == null) {
                return;
            }
            em.remove(student);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }        
    }
    
    public void enrollStudentInSubject(
            String username, 
            int subjectCode){
        try {
            Student student = em.find(Student.class, username);
            if (student == null) {
                return;
            }
            Subject subject = em.find(Subject.class, subjectCode);
            if (subject == null) {
                return;
            }
            
            if(!student.getCourse().getSubjects().contains(subject)){
                return;
            }

            if(subject.getStudents().contains(student)){
                return;
            }
            student.addSubject(subject);
            subject.addStudent(student);
            em.merge(student);
            em.merge(subject);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }                
    }
    */
     
}
