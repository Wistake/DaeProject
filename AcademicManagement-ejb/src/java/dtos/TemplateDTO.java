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
    private @Getter @Setter Integer codeT;
    private @Getter @Setter String templateName;
    private @Getter @Setter String descricaoT;
    //Configuracao
    private @Getter @Setter String descricaoConfig;
    private @Getter @Setter ConfigurationState state;
    private @Getter @Setter Integer storageCapacity;
    private @Getter @Setter String materiaisMarketing;
    private @Getter @Setter String tutoriais;
    private @Getter @Setter String manualUtilizador;

    public TemplateDTO(String templateName, String descricaoT, String descricaoConfig, ConfigurationState state, Integer storageCapacity, String materiaisMarketing, String tutoriais, String manualUtilizador) {
        this(null, templateName, descricaoT, descricaoConfig, state, storageCapacity, materiaisMarketing, tutoriais, manualUtilizador);
    }

    @Override
    public void clear() {
        //template
        codeT=null;
        templateName=null;
        descricaoT=null;
        //configuracao
        descricaoConfig=null;
        storageCapacity=null;
        state=null;
        materiaisMarketing=null;
        tutoriais=null;
        manualUtilizador=null;
    }
}
