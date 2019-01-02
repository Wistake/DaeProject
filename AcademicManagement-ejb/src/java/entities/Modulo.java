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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MODULOS")
@NamedQuery(name = "Modulo.all", query = "SELECT t FROM Modulo t ORDER BY t.nameM")
@NoArgsConstructor
public class Modulo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter int idModulo;
    
    @NotNull(message = "Nome da empresa não pode estar vazio!")
    private @Getter @Setter String nameM;

    @ManyToOne
    //@JoinColumn(name="CONFIGURATION_CODE")
    private @Getter @Setter Configuration configuration;

    public Modulo(String nameM, Configuration configuration) {
        this.nameM = nameM;
        this.configuration = configuration;
        this.configuration.addModulos(this);
    }

}
