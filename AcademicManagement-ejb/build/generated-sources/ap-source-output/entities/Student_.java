package entities;

import entities.Course;
import entities.Document;
import entities.Subject;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-10T21:40:41")
@StaticMetamodel(Student.class)
public class Student_ extends User_ {

    public static volatile ListAttribute<Student, Document> documents;
    public static volatile ListAttribute<Student, Subject> subjects;
    public static volatile SingularAttribute<Student, Course> course;

}