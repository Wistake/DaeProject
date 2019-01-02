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
 * @author Lucas
 */
@Entity
@Table(name="LICENSES")
@NamedQuery(name = "License.all", query = "SELECT a FROM License a ORDER BY a.name")
@NoArgsConstructor
public class License implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter int id;
    
    @NotNull(message = "O Nome da licença não pode estar vazio!")
    private @Getter @Setter String name;
    @NotNull(message = "A data que a licença expira não pode estar vazio!")
    private @Getter @Setter String endDate;
    
    



    
}
