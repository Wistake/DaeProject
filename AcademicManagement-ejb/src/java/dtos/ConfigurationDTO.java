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
    private @Getter @Setter Integer idSoftware;
    private @Getter @Setter Integer idConfig;
    private @Getter @Setter String descricao;
    private @Getter @Setter String name;
    private @Getter @Setter ConfigurationState estado;
    private @Getter @Setter String configuracaoPrivacidade;
    private @Getter @Setter String configuracaoSeguranca;
    private @Getter @Setter String configuracaoConta;

    public ConfigurationDTO(Integer idSoftware, String descricao, String name, ConfigurationState estado, String configuracaoPrivacidade, String configuracaoSeguranca, String configuracaoConta) {
        this(idSoftware, null, descricao, name, estado, configuracaoPrivacidade, configuracaoSeguranca, configuracaoConta);
    }

    @Override
    public void clear() {
        descricao= null;
        name= null;
        estado= null;
        idSoftware = null;
        idConfig = null;
    }
}
