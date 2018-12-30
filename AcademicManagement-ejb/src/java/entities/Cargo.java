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
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CARGOS",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"NAME"}))
@NamedQueries({
    @NamedQuery(name = "Cargo.all",
            query = "SELECT c FROM Cargo c ORDER BY c.name")})
public class Cargo implements Serializable {
    //@PersistenceContext
    //EntityManager em;// preciso???
    
    @Id
    private @Getter @Setter Integer code;
    
    @NotNull
    private @Getter @Setter String name;
    
    @OneToMany(mappedBy = "cargo", cascade = CascadeType.PERSIST)
    private @Getter @Setter List<Administrator> administrators;
    
    public Cargo(){
        administrators = new LinkedList<>();
    }

    public Cargo(int code, String name) {
        this.code = code;
        this.name = name;
        administrators = new LinkedList<>();
    }
    
    public void addAdministrator(Administrator a){
        administrators.add(a);
    }
    
    public List<Administrator> getadministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }
    
    public void removeAdministrator(Administrator a){
        administrators.remove(a);
    }
    /*
    @Id
    private int code;
    @NotNull
    private String name;
    
    @OneToMany(mappedBy = "cargo", cascade = CascadeType.REMOVE)
    private List<Administrator> administrators;
    
    public Cargo(){
        administrators = new LinkedList<>();
    }

    public Cargo(int code, String name) {
        this.code = code;
        this.name = name;
        administrators = new LinkedList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Administrator> getadministrators() {
        return administrators;
    }

    public void setAdministrators(List<Administrator> administrators) {
        this.administrators = administrators;
    }
    
    public void addAdministrator(Administrator a){
        administrators.add(a);
    }
    
    public void removeAdministrator(Administrator a){
        administrators.remove(a);
    }
    */
}
