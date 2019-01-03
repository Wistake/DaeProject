/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lucas
 */

@XmlRootElement(name = "Client")
@NoArgsConstructor
public class ClientDTO extends UserDTO{        
    private @Getter @Setter String empresa;
    private @Getter @Setter String morada;
    private @Getter @Setter String pessoaContacto;
    private @Getter @Setter List<ConfigurationDTO> configs;

    public ClientDTO(String empresa, String morada, String pessoaContacto, String username, String password, String name, String email) {
        super(username, password, name, email);
        this.empresa = empresa;
        this.morada = morada;
        this.pessoaContacto = pessoaContacto;
        this.configs = new LinkedList<>();
    }
    
    @Override
    public void clear() {
        super.clear(); 
        empresa = null;
        morada = null;
        pessoaContacto = null;
        configs = null;
    }
    
    
}
