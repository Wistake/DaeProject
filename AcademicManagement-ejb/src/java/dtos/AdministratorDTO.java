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
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Administrator")
//@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class AdministratorDTO extends UserDTO{
    
    private @Getter @Setter int cargoCode;
    private @Getter @Setter String cargoName;
    
    public AdministratorDTO(String username,
            String password,
            String name,
            String email,
            int cargoCode,
            String cargoName) {
        super(username, password, name, email);
        this.cargoCode = cargoCode;
        this.cargoName = cargoName;
    }
    
    @Override
    public void clear() {
        super.clear(); //To change body of generated methods, choose Tools | Templates.
        cargoCode = 0;
        cargoName = null;
    }
    
    
}
