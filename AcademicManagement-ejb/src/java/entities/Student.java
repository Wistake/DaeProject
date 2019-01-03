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
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
    @NamedQuery(name = "Student.all",
            query = "SELECT s FROM Student s ORDER BY s.name")})

public class Student extends User {
   /* @ManyToOne
    @JoinColumn(name = "COURSE_CODE")
    @NotNull
    private @Getter @Setter Course course;
    
    @NotNull
    @ManyToMany(mappedBy = "students")
    private @Getter @Setter List<Subject> subjects;

    @OneToMany(mappedBy = "student")
    private @Getter @Setter List<SupportMaterial> documents;
    
    public Student() {
        //subjects = new LinkedList<>();
        documents = new LinkedList<>();
    }

    public Student(
            String username,
            String password,
            String name,
            String email
           /* Course course) {
        super(username, password, GROUP.Student, name, email);
        //this.course = course;
       /* course.addStudent(this);
        subjects = new LinkedList<>();
        documents = new LinkedList<>();
    }*/
    
/*
    @ManyToOne
    @JoinColumn(name = "COURSE_CODE")
    @NotNull
    private Course course;
    @NotNull
    @ManyToMany(mappedBy = "students")
    private List<Subject> subjects;

    @OneToMany(mappedBy = "student")
    public List<Document> documents;

    public Student() {
        subjects = new LinkedList<>();
        documents = new LinkedList<>();
    }

    public Student(
            String username,
            String password,
            String name,
            String email,
            Course course) {
        super(username, password, GROUP.Student, name, email);
        this.course = course;
        course.addStudent(this);
        subjects = new LinkedList<>();
        documents = new LinkedList<>();
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
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

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
    
    public void addDocument(SupportMaterial document) {
        this.documents.add(document);
    }
    
    public void removeDocument(SupportMaterial document) {
        this.documents.remove(document);
    }    
    */
}
