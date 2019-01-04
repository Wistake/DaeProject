/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.UserGroup.GROUP;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;

import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author lucas
 */
@Entity
//@Table(name = "CLIENTS")
@NamedQueries({
@NamedQuery(name = "Client.all", query = "SELECT s FROM Client s ORDER BY s.name"),
@NamedQuery(name = "Client.pass", query = "SELECT c.password FROM Client c WHERE c.username = :username")
})
public class Client extends User {
    
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private @Getter @Setter List<Software> softwares;

    @NotNull(message = "Nome da empresa não pode estar vazio!")
    private @Getter @Setter String empresa;

    @NotNull(message = "Morada não pode estar vazia!")
    private @Getter @Setter String morada;
    
    @NotNull(message = "Pessoa de contacto não pode estar vazio!")
    private @Getter @Setter String pessoaContacto;
    
   /* @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private @Getter @Setter List<Configuration> configs;*/

    protected Client() {
        this.softwares = new LinkedList<>();
      //  this.configs = new LinkedList<>();
        
    }

    public Client(String empresa, String morada, String pessoaContacto, String username, String password, String name, String email) {
        super(username, password, GROUP.Client, name, email);
        this.empresa = empresa;
        this.morada = morada;
        this.pessoaContacto = pessoaContacto;
        this.softwares = new LinkedList<>();
       // this.configs = new LinkedList<>();
    }
    
    public void addSoftware(Software s){
        this.softwares.add(s);
    }  
    
   /* public void addConfiguration(Configuration c){
        this.configs.add(c);
    }*/
        
    
}
