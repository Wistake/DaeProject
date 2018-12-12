package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SUBJECTS",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"NAME", "COURSE_CODE", "SCHOLARYEAR"}))
@NamedQuery(name = "getAllSubjects",
        query = "SELECT s FROM Subject s ORDER BY s.course.name, s.courseYear DESC, s.scholarYear, s.name")
public class Subject implements Serializable {

    @Id
    private int code;
    @NotNull
    private String name;
    @ManyToOne
    @JoinColumn(name = "COURSE_CODE")
    @NotNull
    private Course course;
    private int courseYear;
    @NotNull
    private String scholarYear;
    @NotNull
    @ManyToMany
    @JoinTable(name = "SUBJECTS_STUDENTS",
            joinColumns = @JoinColumn(
                    name = "SUBJECT_CODE",
                    referencedColumnName = "CODE"),
            inverseJoinColumns = @JoinColumn(
                    name = "STUDENT_USERNAME",
                    referencedColumnName = "USERNAME"))
    private List<Student> students;
    @NotNull
    @ManyToMany
    @JoinTable(name = "SUBJECTS_TEACHERS",
            joinColumns = @JoinColumn(
                    name = "SUBJECT_CODE",
                    referencedColumnName = "CODE"),
            inverseJoinColumns = @JoinColumn(
                    name = "TEACHER_USERNAME",
                    referencedColumnName = "USERNAME"))
    private List<Teacher> teachers;

    public Subject() {
        this.students = new LinkedList<>();
        this.teachers = new LinkedList<>();
    }

    public Subject(
            int code,
            String name,
            Course course,
            int courseYear,
            String scholarYear) {
        this.code = code;
        this.name = name;
        this.course = course;
        this.course.addSubject(this);
        this.courseYear = courseYear;
        this.scholarYear = scholarYear;
        this.students = new LinkedList<>();
        this.teachers = new LinkedList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public String getScholarYear() {
        return scholarYear;
    }

    public void setScholarYear(String scholarYear) {
        this.scholarYear = scholarYear;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    public void removeTeacher(Teacher t) {
        teachers.remove(t);
    }

}
