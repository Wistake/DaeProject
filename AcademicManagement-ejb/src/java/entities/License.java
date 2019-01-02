/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import helpers.LicenseState;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author Lucas
 */
@Entity
@Table(name="LICENSES", uniqueConstraints = @UniqueConstraint(columnNames = {"NAME"}))
@NamedQuery(name = "License.all", query = "SELECT a FROM License a ORDER BY a.name")
public class License implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter int id;
    
    @NotNull(message = "O Nome da licença não pode estar vazio!")
    private @Getter @Setter String name;
    @NotNull(message = "A data que a licença expira não pode estar vazio!")
    private @Getter @Setter String endDate;
    @NotNull(message = "A data de inicio da licença não pode estar vazio!")
    private @Getter @Setter String initDate;
    
    private @Getter @Setter LicenseState state;
    
    @ManyToMany(mappedBy = "licenses", cascade = CascadeType.ALL)
    private @Getter @Setter List<Software> softwares;

    public License() {
        softwares = new LinkedList<>();
    }
    
    public License(String name, String endDate) {
        this();
        this.name = name;
        this.endDate = endDate;
    }
    
    public void addSoftware(Software s){
        softwares.add(s);
    }
}
