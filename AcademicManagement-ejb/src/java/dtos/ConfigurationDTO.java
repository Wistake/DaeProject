/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.ConfigurationState;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author 
 */
@XmlRootElement(name = "Configuracao")
@NoArgsConstructor
public class ConfigurationDTO implements DTO{
 private @Getter @Setter Integer idSoftware;
    private @Getter @Setter Integer idConfig;
    private @Getter @Setter String descricao;
    private @Getter @Setter String nameTemplate;
    private @Getter @Setter String name;
    private @Getter @Setter ConfigurationState estado;

    public ConfigurationDTO(String descricao, String nameTemplate, String name) {
        this.descricao = descricao;
        this.nameTemplate = nameTemplate;
        this.name = name;
        this.estado = ConfigurationState.INACTIVE;
    }

    public ConfigurationDTO(Integer idSoftware, Integer idConfig, String descricao, String name, ConfigurationState estado) {
        this.idSoftware = idSoftware;
        this.idConfig = idConfig;
        this.descricao = descricao;
        this.name = name;
        this.estado = estado;
    }
    

    public ConfigurationDTO(Integer idSoftware, String descricao, String name, ConfigurationState estado) {
        this(idSoftware, null, descricao, name, estado);
    }

    @Override
    public void clear() {
        descricao= null;
        name= null;
        estado= null;
        idSoftware = null;
        idConfig = null;
        nameTemplate=null;
    }
}
