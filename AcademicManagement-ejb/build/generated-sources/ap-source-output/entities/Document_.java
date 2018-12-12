package entities;

import entities.Student;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-12-12T23:22:03")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, String> filepath;
    public static volatile SingularAttribute<Document, Student> student;
    public static volatile SingularAttribute<Document, Integer> id;
    public static volatile SingularAttribute<Document, String> desiredName;
    public static volatile SingularAttribute<Document, String> mimeType;

}