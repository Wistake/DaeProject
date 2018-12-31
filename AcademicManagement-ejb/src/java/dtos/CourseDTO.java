package dtos;


import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Course")
//@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class CourseDTO implements DTO{

    private @Getter @Setter Integer code;
    private @Getter @Setter String name;
   
    public CourseDTO(Integer code, String name){
        this.code = code;
        this.name = name;
    }
    
    
    @Override
    public void clear() {
        code = null;
        name = null;
    }

}
