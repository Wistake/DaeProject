/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import helpers.ConfigurationState;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
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
public class Template implements Serializable {
    
    @Id
    private @Getter @Setter String templateName;
    @NotNull(message = "A descrição do template não pode estar vazio!")
    private @Getter @Setter String descricaoT;
    private @Getter @Setter String nameConfig;
    private @Getter @Setter String descricaoConfig;
    private @Getter @Setter ConfigurationState state;
    private @Getter @Setter Integer storageCapacity;
    
    @OneToMany(mappedBy = "template")
    public @Getter @Setter List<SupportMaterial> supportMaterials;

    public Template() {
        this.supportMaterials = new LinkedList<>();
    }

    public Template(String templateName, String descricaoT, String nameConfig, String descricaoConfig, ConfigurationState state, Integer storageCapacity) {
        this();
        this.templateName = templateName;
        this.descricaoT = descricaoT;
        this.nameConfig = nameConfig;
        this.descricaoConfig = descricaoConfig;
        this.state = state;
        this.storageCapacity = storageCapacity;
    }
    
    public void addSupportMaterials(SupportMaterial s){
        this.supportMaterials.add(s);
    }
}
