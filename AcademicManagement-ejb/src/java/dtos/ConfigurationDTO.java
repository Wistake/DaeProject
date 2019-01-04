/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.ConfigurationState;
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
    private @Getter @Setter String materiaisMarketing;
    private @Getter @Setter String tutoriais;
    private @Getter @Setter String manualUtilizador;
    private @Getter @Setter String clientUsername;

    public ConfigurationDTO(Integer idSoftware, String name, String descricao, ConfigurationState estado, Integer storageCapacity, String materiaisMarketing, String tutoriais, String manualUtilizador, String clientUsername) {
        this(null, idSoftware, name, descricao, estado, storageCapacity, materiaisMarketing, tutoriais, manualUtilizador, clientUsername);
    }


    @Override
    public void clear() {
        code = null;
        idSoftware = null;
        name= null;
        descricao= null;
        estado= null;
        storageCapacity = null;
        clientUsername = null;
        tutoriais= null;
        manualUtilizador= null;
        materiaisMarketing= null;
    }
}
