package web;

import dtos.TemplateDTO;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import lombok.Getter;
import lombok.Setter;

@ManagedBean
@SessionScoped
public class UserManager implements Serializable {

    private String username;
    private String password;
    
    private final String baseUri = "http://localhost:8080/AcademicManagement-war/api";
     
     private Client client;

    private boolean loginFlag = true;
    private static final Logger logger = Logger.getLogger("web.UserManager");

    public UserManager() {
    }
    
    public List<TemplateDTO> getAllTemplates(){
         try {
            
           return client.target(baseUri)
                    .path("/templates")
                    .request(MediaType.APPLICATION_XML)
                    .get(new GenericType<List<TemplateDTO>>() {});
        } catch (Exception e) {
            logger.warning("Problem getting all templates in method getAllTemplates."+e.getMessage());
            return null;
        }
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request
                = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(this.username, this.password);
        } catch (ServletException e) {
            logger.log(Level.WARNING, e.getMessage());
            return "login_error?faces-redirect=true";
        }
        if (isUserInRole("Administrator")) {
            return "/faces/admin/admin_index?faces-redirect=true";
        }
        if (isUserInRole("Client")) {
            return "/faces/client/client_index?faces-redirect=true";
        }
        if (isUserInRole("Student")) {
            return "/faces/student/student_list_subjects?faces-redirect=true";
        }
        if (isUserInRole("Teacher")) {
            return "/faces/teacher/teacher_list_subjects?faces-redirect=true";
        }
        return "login_error?faces-redirect=true";
    }

    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        // remove data from beans:
        for (String bean : context.getExternalContext().getSessionMap().keySet()) {
            context.getExternalContext().getSessionMap().remove(bean);
        }
        // destroy session:
        HttpSession session
                = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        // using faces-redirect to initiate a new request:
        return "/index_login.xhtml?faces-redirect=true";
    }

    public String clearLogin() {
        if (isSomeUserAuthenticated()) {
            logout();
        }
        return "index_login.xhtml?faces-redirect=true";
    }

    public boolean isUserInRole(String role) {
        return (isSomeUserAuthenticated()
                && FacesContext.getCurrentInstance().getExternalContext().isUserInRole(role));
    }

    public boolean isSomeUserAuthenticated() {
        return FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal() != null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

}
