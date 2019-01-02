package dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements DTO{
    protected @Getter @Setter String username;
    protected @Getter @Setter String password;    
    protected @Getter @Setter String name;
    protected @Getter @Setter String email;
        
    @Override
    public void clear() {
        username = null;
        password = null;
        name = null;
        email = null;
    }
}
