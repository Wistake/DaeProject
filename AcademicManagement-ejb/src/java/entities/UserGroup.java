package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS_GROUPS")
public class UserGroup implements Serializable {

    public static enum GROUP {
        Administrator, Teacher, Student
    }

    @Id
    @Enumerated(EnumType.STRING)
    private GROUP group_Name;

    @Id
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;

    public UserGroup() {
    }

    public UserGroup(GROUP group_Name, User user) {
        this.group_Name = group_Name;
        this.user = user;
    }

    public GROUP getGroup_Name() {
        return group_Name;
    }

    public void setGroup_Name(GROUP group_Name) {
        this.group_Name = group_Name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
