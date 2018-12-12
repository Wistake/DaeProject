package entities;

import entities.UserGroup.GROUP;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Teacher extends User implements Serializable {

    private String office;
    @NotNull
    @ManyToMany(mappedBy = "teachers")
    private List<Subject> subjects;
    
    public Teacher() {
        subjects = new LinkedList<>();
    }

    public Teacher(
            String username, 
            String password, 
            String name, 
            String email,
            String office) {
        super(username, password, GROUP.Teacher, name, email);
        this.office = office;
        subjects = new LinkedList<>();
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void addSubject(Subject s) {
        subjects.add(s);
    }

    public void removeSubject(Subject s) {
        subjects.remove(s);
    }
    
}
