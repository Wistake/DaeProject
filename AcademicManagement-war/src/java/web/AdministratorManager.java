package web;

import dtos.AdministratorDTO;
import dtos.CourseDTO;
import dtos.DocumentDTO;
import dtos.StudentDTO;
import dtos.SubjectDTO;
import dtos.TemplateDTO;
import ejbs.TemplateBean;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import util.URILookup;

@ManagedBean
@SessionScoped
public class AdministratorManager implements Serializable {

    private static final Logger logger = Logger.getLogger("web.AdministratorManager");
    
    private AdministratorDTO currentAdmin;

    private StudentDTO currentStudent;

    private StudentDTO newStudent;
    
    private DocumentDTO document;

    private String filePath;

    private UIComponent component;

    private Client client;
    
    private TemplateDTO templateDTO;
    
    private TemplateDTO newTemplate;
    
    
    @ManagedProperty("#{userManager}")
    UserManager userManager;

    @ManagedProperty(value = "#{uploadManager}")
    private UploadManager uploadManager;
    
    //private TemplateBean templateBean;
    
    public AdministratorManager() {
        newStudent = new StudentDTO();
        newTemplate = new TemplateDTO();
        client = ClientBuilder.newClient();
    }

    @PostConstruct
    public void init() {
        HttpAuthenticationFeature feature
                = HttpAuthenticationFeature.basic(userManager.getUsername(), userManager.getPassword());

        client.register(feature);
    }

    public String createStudent() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/students/create")
                    .request(MediaType.APPLICATION_XML)
                    .post(Entity.xml(newStudent));
            clearNewStudent();
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", component, logger);
        }
        return null;
    }
    
    public String createTemplate() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/templates/create")
                    .request(MediaType.APPLICATION_XML)
                    .post(Entity.xml(newTemplate));
            clearNewTemplate();
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "UUnexpected error! Try again latter!", component, logger);
        }
        return null;
    }
    
    public List<AdministratorDTO> getAllAdministrators() {
        List<AdministratorDTO> administrators = null;
        try {
            administrators = client.target(URILookup.getBaseAPI())
                    .path("/administrators/all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<AdministratorDTO>>() {
                    });
        } catch (Exception e) {
            logger.warning("Problem getting all admins in method getAllAdministrators.");
        }
        return administrators;
    }
    
    public List<TemplateDTO> getAllTemplates() {
        List<TemplateDTO> templates = null;
        try {
            templates = client.target(URILookup.getBaseAPI())
                    .path("/templates/all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<TemplateDTO>>() {
                    });
        } catch (Exception e) {
            logger.warning("Problem getting all templates in method getAllTemplates."+e.getMessage());
        }
        return templates;
    }
    
    public Collection<CourseDTO> getAllCourses() {
        Collection<CourseDTO> courses = null;
        try {
            courses = client.target(URILookup.getBaseAPI())
                    .path("/courses/all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<Collection<CourseDTO>>() {
                    });
        } catch (Exception e) {
            logger.warning("Problem getting all courses in method getAllCourses.");
        }
        return courses;
    }

    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> students = null;
        try {
            students = client.target(URILookup.getBaseAPI())
                    .path("/students/all")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<StudentDTO>>() {
                    });
        } catch (Exception e) {
            logger.warning("Problem getting all students in method getAllStudents.");
        }
        return students;
    }

    public String updateStudentREST1() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/students/updateREST1")
                    .path(currentStudent.getUsername())
                    .path(currentStudent.getPassword())
                    .path(currentStudent.getName())
                    .request(MediaType.APPLICATION_XML)
                    .put(Entity.xml(currentStudent.getEmail()));
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
        }
        return null;
    }
    
    public String updateAdminREST1() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/administrators/updateREST1")
                    .path(currentAdmin.getUsername())
                    .path(currentAdmin.getPassword())
                    .path(currentAdmin.getName())
                    .request(MediaType.APPLICATION_XML)
                    .put(Entity.xml(currentAdmin.getEmail()));
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
        }
        return null;
    }
    
    public String updateTemplateREST1() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/templates/updateREST1")
                    .path(templateDTO.getDescricao())
                    .request(MediaType.APPLICATION_XML)
                    .put(Entity.xml(templateDTO.getIdName()));
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
        }
        return null;
    }
    
    public String updateTemplateREST2() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/templates/updateREST2")
                    .request(MediaType.APPLICATION_XML)
                    .put(Entity.xml(templateDTO));
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
        }
        return null;
    }
    

    public String updateStudentREST2() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/students/updateREST2")
                    .request(MediaType.APPLICATION_XML)
                    .put(Entity.xml(currentStudent));
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
        }
        return null;
    }
    
    public String updateAdminREST2() {
        try {
            client.target(URILookup.getBaseAPI())
                    .path("/administrators/updateREST2")
                    .request(MediaType.APPLICATION_XML)
                    .put(Entity.xml(currentAdmin));
            return "admin_index?faces-redirect=true";
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
        }
        return null;
    }

    public void removeStudent(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteStudentId");
            String id = param.getValue().toString();

            client.target(URILookup.getBaseAPI())
                    .path("/students/remove")
                    .path(id)
                    .request(MediaType.APPLICATION_XML)
                    .delete();
        } catch (Exception e) {
            logger.warning("Problem removing a student in method removeStudent.");
        }
    }
    
    public void removeAdmin(ActionEvent event) {
        try {
            UIParameter param = (UIParameter) event.getComponent().findComponent("deleteAdminId");
            String id = param.getValue().toString();

            client.target(URILookup.getBaseAPI())
                    .path("/administrators/remove")
                    .path(id)
                    .request(MediaType.APPLICATION_XML)
                    .delete();
        } catch (Exception e) {
            logger.warning("Problem removing a admin in method removeAdmin.");
        }
    }


    public Collection<SubjectDTO> getCurrentStudentSubjects() {
        Collection<SubjectDTO> subjects = null;
        try {
            subjects = client.target(URILookup.getBaseAPI())
                    .path("/subjects/student_subjects")
                    .path(currentStudent.getUsername())
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<Collection<SubjectDTO>>() {
                    });
        } catch (Exception e) {
            logger.warning("Problem getting student's subjects.");
        }
        return subjects;
    }

    public String uploadDocument() {
        try {
            document = new DocumentDTO(uploadManager.getCompletePathFile(), uploadManager.getFilename(), uploadManager.getFile().getContentType());

            client.target(URILookup.getBaseAPI())
                    .path("/students/addDocument")
                    .path(currentStudent.getUsername())
                    .request(MediaType.APPLICATION_XML)
                    .put(Entity.xml(document));

        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
            return null;
        }

        return "admin_students_details?faces-redirect=true";
    }

    public Collection<DocumentDTO> getDocuments() {
        Collection<DocumentDTO> documents = null;
        try {
            documents = client.target(URILookup.getBaseAPI())
                    .path("/students/documents")
                    .path(currentStudent.getUsername())
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<Collection<DocumentDTO>>() {
                    });
        } catch (Exception e) {
            FacesExceptionHandler.handleException(e, "Unexpected error! Try again latter!", logger);
        }
        return documents;
    }

    private void clearNewStudent() {
        newStudent.setUsername(null);
        newStudent.setPassword(null);
        newStudent.setName(null);
        newStudent.setEmail(null);
        newStudent.setCourseCode(0);
    }
    
    private void clearNewTemplate() {
        newTemplate.setIdName(0);
        newTemplate.setDescricao(null);
    }

    public StudentDTO getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(StudentDTO currentStudent) {
        this.currentStudent = currentStudent;
    }
    
    public AdministratorDTO getCurrentAdmin() {
        return currentAdmin;
    }

    public void setCurrentAdmin(AdministratorDTO currentAdmin) {
        this.currentAdmin = currentAdmin;
    }

    public StudentDTO getNewStudent() {
        return newStudent;
    }
    
    public TemplateDTO getNewTemplate() {
        return newTemplate;
    }

    public void setNewStudent(StudentDTO newStudent) {
        this.newStudent = newStudent;
    }

    public TemplateDTO getTemplateDTO() {
        return templateDTO;
    }

    public void setTemplateDTO(TemplateDTO templateDTO) {
        this.templateDTO = templateDTO;
    }
    
    
    
    

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

    public UploadManager getUploadManager() {
        return uploadManager;
    }

    public void setUploadManager(UploadManager uploadManager) {
        this.uploadManager = uploadManager;
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public void setDocument(DocumentDTO document) {
        this.document = document;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
