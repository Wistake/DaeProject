package entities;

import entities.UserGroup.GROUP;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NamedQueries({
    @NamedQuery(name = "Administrator.all",
            query = "SELECT a FROM Administrator a ORDER BY a.name"),
    @NamedQuery(name = "Administrator.pass", query = "SELECT a.password FROM Administrator a WHERE a.username = :username"),
            })
@NoArgsConstructor
public class Administrator extends User{
    @NotNull(message = "Cargo não pode estar vazio!")
    private @Getter @Setter String cargo;
    
    public Administrator(String username, String password, String name,String email, String cargo) {
        super(username, password, GROUP.Administrator, name, email);
        this.cargo = cargo;
        
    }

}
