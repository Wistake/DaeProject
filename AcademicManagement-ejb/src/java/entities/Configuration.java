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
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.persistence.OneToOne;
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
@Table(name = "CONFIGURATION", uniqueConstraints
        = @UniqueConstraint(columnNames = {"NAME"}))
@NamedQueries({
    @NamedQuery(name = "Configuration.all"/*"getAllConfiguration"*/,
        query = "SELECT s FROM Configuration s ORDER BY s.name")/*,
    @NamedQuery(name = "getConfiguracao",
        query = "SELECT s FROM Configuracao s WHERE s.id = :idConfiguracao ORDER BY s.name")  */  

})

public class Configuration implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter @Setter int code;
    
    //@NotNull
    @ManyToOne 
    @JoinColumn(name = "SOFTWARE_ID")
    private @Getter @Setter Software software;
    
    @NotNull(message = "Descrição não pode estar vazia!")
    private @Getter @Setter String descricao;
    
    @NotNull(message = "A configuracao da privacidade não pode estar vazia!")
    private @Getter @Setter String configuracaoPrivacidade;
    
    @NotNull(message = "A configuracao da segurança não pode estar vazia!")
    private @Getter @Setter String configuracaoSeguranca;
    
    @NotNull(message = "A configuracao da conta não pode estar vazia!")
    private @Getter @Setter String configuracaoConta;
    
    @NotNull(message = "Nome da configuracao não pode estar vazio!")
    private @Getter @Setter String name;
    
    @OneToMany(mappedBy = "configuration", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private @Getter @Setter List<Modulo> modulos;
    
    @NotNull(message = "O estado da configuração não pode estar vazio!")
    @Enumerated(EnumType.STRING)
    private @Getter @Setter ConfigurationState estado;
    
    
    /*
    @OneToMany(mappedBy = "servicos", cascade = CascadeType.REMOVE) // ManyToMany //?????????'
    private List<Servico> servicos;
    
    Linceças 
    parametrizaçoes 
    extensoes
    dados do contrato
    
   */

    public Configuration() {
        this.modulos = new LinkedList<>();
    }

    public Configuration(String descricao, String nome,ConfigurationState estado, Software software) {
        this();
        this.descricao = descricao;
        this.name = nome;
        this.software = software;
        this.estado = estado;
        this.software.addConfiguracao(this);      
    }

    public void addModulos(Modulo m){
        modulos.add(m);
    }
    
    
}
