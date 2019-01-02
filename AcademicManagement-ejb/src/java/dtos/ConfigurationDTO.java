/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import helpers.ConfigurationState;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 
 */
@XmlRootElement(name = "Configuration")
@NoArgsConstructor
@AllArgsConstructor
public class ConfigurationDTO implements DTO{
    private @Getter @Setter Integer code;
    private @Getter @Setter Integer idSoftware;
    private @Getter @Setter String name;
    private @Getter @Setter String descricao;
    private @Getter @Setter ConfigurationState estado;
    private @Getter @Setter Integer storageCapacity;

    public ConfigurationDTO(Integer idSoftware, String name, String descricao, ConfigurationState estado, Integer storageCapacity) {
        this(null, idSoftware, name, descricao, estado, storageCapacity);
    }

    @Override
    public void clear() {
        code = null;
        idSoftware = null;
        name= null;
        descricao= null;
        estado= null;
        storageCapacity = null;
    }
}
