package entities;

import entities.UserGroup.GROUP;
import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Administrator extends User implements Serializable {

    public Administrator() {
    }

    public Administrator(String username, String password, String name, String email) {
        super(username, password, GROUP.Administrator, name, email);
    }

}
