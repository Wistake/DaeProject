/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "TEMPLATES")
@NamedQuery(name = "Template.all", query = "SELECT t FROM Template t ORDER BY t.templateName")
@NoArgsConstructor
public class Template implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter int codeT;
    
    private @Getter @Setter String templateName;
    @NotNull(message = "A descrição do template não pode estar vazio!")
    private @Getter @Setter String descricaoT;
    private @Getter @Setter String descricaoConfig;
    private @Getter @Setter ConfigurationState state;
    private @Getter @Setter Integer storageCapacity;
    private @Getter @Setter String materiaisMarketing;
    private @Getter @Setter String tutoriais;
    private @Getter @Setter String manualUtilizador;

    public Template(String templateName, String descricaoT, String descricaoConfig, ConfigurationState state, Integer storageCapacity, String materiaisMarketing, String tutoriais, String manualUtilizador) {
        this.templateName = templateName;
        this.descricaoT = descricaoT;
        this.descricaoConfig = descricaoConfig;
        this.state = state;
        this.storageCapacity = storageCapacity;
        this.materiaisMarketing = materiaisMarketing;
        this.tutoriais = tutoriais;
        this.manualUtilizador = manualUtilizador;
    }



}
