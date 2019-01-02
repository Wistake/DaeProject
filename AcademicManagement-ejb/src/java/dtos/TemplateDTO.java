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
@XmlRootElement(name = "Template")
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDTO implements DTO {
    private @Getter @Setter String templateName;
    private @Getter @Setter String descricaoT;
    private @Getter @Setter String configuracaoPrivacidade;
    private @Getter @Setter String configuracaoSeguranca;
    private @Getter @Setter String configuracaoConta;

    @Override
    public void clear() {
        templateName=null;
        descricaoT=null;
    }
    
}
