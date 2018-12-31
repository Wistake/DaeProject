/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@XmlRootElement(name = "Software")
@NoArgsConstructor
@AllArgsConstructor
public class SoftwareDTO implements DTO{        
    private @Getter @Setter Integer idSoftware;
    private @Getter @Setter String baseVersion;
    private @Getter @Setter String name;
    private @Getter @Setter String clienteUsername;

    public SoftwareDTO(String baseVersion, String name, String clienteUsername) {
        this(null, baseVersion, name, clienteUsername);
    }
    
    @Override
    public void clear() {
        idSoftware = null;
        baseVersion= null;
        name= null;
        clienteUsername= null;
    }
    
          
}
