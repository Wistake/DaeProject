package dtos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "Course")
//@XmlAccessorType(XmlAccessType.FIELD)
public class CourseDTO implements DTO{

    private @Getter @Setter Integer code;
    private @Getter @Setter String name;
    
    public CourseDTO(){
    }
    
    public CourseDTO(Integer code, String name){
        this.code = code;
        this.name = name;
    }
    
    
    @Override
    public void clear() {
        code = null;
        name = null;
    }
/*
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
*/
}
