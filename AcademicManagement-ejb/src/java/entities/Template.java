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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
    @NamedQuery(name = "getAllTemplates",
            query = "SELECT t FROM Template t")})
public class Template implements Serializable{
    
    @Id
    private int idName;
    
    //@NotNull
    /*@OneToMany(mappedBy = "template", cascade = CascadeType.REMOVE)
    private List<Software> software; */
    
    @NotNull
    private String descricao;
    
    public Template() {
        //this.software = new LinkedList<>();
    }

    public Template(Integer idName, String descricao) {
        this.idName = idName;
        this.descricao = descricao;
        //this.software = new LinkedList<>();
    }
    
    public void reset() {
        setIdName(0);
        setDescricao(null);
        
    } 

    /*public List<Software> getSoftware() {
        return software;
    }

    public void setSoftware(List<Software> software) {
        this.software = software;
    }*/
    
    public Integer getIdName() {
        return idName;
    }

    public void setIdName(Integer idName) {
        this.idName = idName;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
    
}
