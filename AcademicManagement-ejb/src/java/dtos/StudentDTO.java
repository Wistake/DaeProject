package dtos;

import java.io.Serializable;
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
    /*
    private int courseCode;
    private String courseName;
   
    public StudentDTO(){
    }

    public StudentDTO(
            String username,
            String password,
            String name,
            String email,            
            int courseCode,
            String courseName) {
        super(username, password, name, email);
        this.courseCode = courseCode;
        this.courseName = courseName;
    }
    
    @Override
    public void clear() {
        super.clear();
        setCourseCode(0);
        setCourseName(null);
    }
    
    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
*/
}
