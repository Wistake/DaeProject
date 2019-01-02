/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "Administrator")
//@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
public class AdministratorDTO extends UserDTO{
    
    private @Getter @Setter String cargo;
    
    public AdministratorDTO(String username,
            String password,
            String name,
            String email,
            String cargo) {
        super(username, password, name, email);
        this.cargo = cargo;
        
    }
    
    @Override
    public void clear() {
        super.clear(); 
        cargo = null;
    }
    
    
}
