/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "Cargo")
//@XmlAccessorType(XmlAccessType.FIELD)
public class CargoDTO implements DTO{
    private @Getter @Setter Integer code;
    private @Getter @Setter String name;

    public CargoDTO() {
    }
    
    public CargoDTO(Integer code, String name) {
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
