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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
    private @Getter @Setter int idSoftware;
    
    @NotNull(message = "Versão do software não pode estar vazio!")
    private @Getter @Setter String baseVersion;
    
    @NotNull(message = "Nome do software não pode estar vazio!")
    private @Getter @Setter String name;
    
    @ManyToOne
    private @Getter @Setter Client client;  
    
    @OneToMany(mappedBy = "software", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private @Getter @Setter List<Configuration> configuracoes;
    
    @ManyToMany
    protected @Getter @Setter List<License> licenses;

    public Software() {
        this.configuracoes = new LinkedList<>();
        this.licenses = new LinkedList<>();
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
    
    public void addLicense(License c ){
        licenses.add(c);
    }
    
    /*public void addContrato(Contrato c){
        contratos.add(c);
    }*/

    
}
