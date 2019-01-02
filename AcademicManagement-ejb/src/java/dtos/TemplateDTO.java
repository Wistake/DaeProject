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
 * @author lucas
 */
@XmlRootElement(name = "Template")
@NoArgsConstructor
@AllArgsConstructor
public class TemplateDTO implements DTO {
    //Template
    private @Getter @Setter String templateName;
    private @Getter @Setter String descricaoT;
    //Configuracao
    private @Getter @Setter String nameConfig;
    private @Getter @Setter String descricaoConfig;
    private @Getter @Setter Integer storageCapacity;
    private @Getter @Setter ConfigurationState state;

    @Override
    public void clear() {
        //template
        templateName=null;
        descricaoT=null;
        //configuracao
        nameConfig = null;
        descricaoConfig=null;
        storageCapacity=null;
        state=null;
    }
}
