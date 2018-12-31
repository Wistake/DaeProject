package dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Student")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class StudentDTO extends UserDTO{
    
    private @Getter @Setter String courseName;
    private @Getter @Setter int courseCode;

    public StudentDTO(String username, String password, String name, String email, int courseCode, String courseName){
        super(username, password, name, email);
        this.courseCode = courseCode;
        this.courseName = courseName;
    }


    @Override
    public void clear() {
        super.clear(); 
        courseName = null;
        courseCode = 0;
    }
}
