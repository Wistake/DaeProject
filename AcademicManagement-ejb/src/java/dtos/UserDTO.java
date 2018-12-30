package dtos;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class UserDTO implements DTO{
    protected @Getter @Setter String username;
    protected @Getter @Setter String password;    
    protected @Getter @Setter String name;
    protected @Getter @Setter String email;
    
    public UserDTO() {
    }    
    
    public UserDTO(String username, String password, String name, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }
    
    @Override
    public void clear() {
        username = null;
        password = null;
        name = null;
        email = null;
    }

    /*
    protected String username;
    protected String password;    
    protected String name;
    protected String email;

    
    
    
    
    public void reset() {
        setUsername(null);
        setPassword(null);
        setName(null);
        setEmail(null);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    */
}
