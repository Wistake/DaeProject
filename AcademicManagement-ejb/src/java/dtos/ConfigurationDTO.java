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
    private @Getter @Setter String descricao;
    private @Getter @Setter String configuracaoPrivacidade;
    private @Getter @Setter String configuracaoSeguranca;
    private @Getter @Setter String configuracaoConta;
    private @Getter @Setter String name;
    private @Getter @Setter ConfigurationState estado;

    public ConfigurationDTO(Integer idSoftware, String descricao, String configuracaoPrivacidade, String configuracaoSeguranca, String configuracaoConta, String name, ConfigurationState estado) {
        this(null, idSoftware, descricao, configuracaoPrivacidade, configuracaoSeguranca, configuracaoConta, name, estado);
    }

    @Override
    public void clear() {
        code= null;
        idSoftware= null;
        descricao= null;
        configuracaoPrivacidade= null;
        configuracaoSeguranca= null;
        configuracaoConta= null;
        name= null;
        estado= null;
    }
}
