/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucas
 */


@Entity
@Table(name = "SOFTWARES",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"NAME"}))
@NamedQueries({
    @NamedQuery(name = "Software.all"/*"getAllSoftware"*/,
            query = "SELECT s FROM Software s ORDER BY s.name")})

public class Software implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private @Getter @Setter int id;
    
    @NotNull
    private @Getter @Setter String baseVersion;
    
    @NotNull
    private @Getter @Setter String name;
    
    //@NotNull
    @ManyToOne
    //@JoinColumn(name = "CLIENTE_USERNAME")
    private @Getter @Setter Client client;
    
    //@NotNull
    @OneToMany(mappedBy = "software", cascade = CascadeType.REMOVE)
    private @Getter @Setter List<Configuration> configuracoes;
    
    /*@OneToMany(mappedBy = "software", cascade = CascadeType.REMOVE)
    private @Getter @Setter List<Contract> contratos;*/

    public Software() {
        this.configuracoes = new LinkedList<>();
       // this.contratos = new LinkedList<>();
    }

    public Software(String baseVersion, String name, Client cliente) {
        this();
        this.baseVersion = baseVersion;
        this.name = name;
        this.client = cliente;
        cliente.addSoftware(this);
    }
    
    public void addConfiguracao(Configuration c ){
        configuracoes.add(c);
    }
    
    /*public void addContrato(Contrato c){
        contratos.add(c);
    }*/

    
}
