package entities;

import entities.UserGroup.GROUP;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllAdministrators",
            query = "SELECT a FROM Administrator a ORDER BY a.name")})
public class Administrator extends User implements Serializable {

    @ManyToOne
    @JoinColumn(name = "CARGO_CODE")
    @NotNull
    private Cargo cargo;
    
    public Administrator() {
    }

    public Administrator(
            String username,
            String password,
            String name,
            String email,
            Cargo cargo) {
        super(username, password, GROUP.Administrator, name, email);
        this.cargo = cargo;
        cargo.addAdministrator(this);
    }


    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
