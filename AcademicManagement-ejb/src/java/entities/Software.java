/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SOFTWARES",
        uniqueConstraints
        = @UniqueConstraint(columnNames = {"NAME"}))
@NamedQueries({
    @NamedQuery(name = "getAllSoftware",
            query = "SELECT s FROM Software s ORDER BY s.name")})
public class Software implements Serializable
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    private String baseVersion;
    
    @NotNull
    private String name;
    
    @ManyToOne
    private Template template;
    
    @NotNull
    @OneToMany(mappedBy = "software", cascade = CascadeType.REMOVE)
    private List<Configuration> configuration;
    
    
    public Software(){
        
    }

    public Software(long id, String baseVersion, String name) {
        this.id = id;
        this.baseVersion = baseVersion;
        this.name = name;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public List<Configuration> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List<Configuration> configuration) {
        this.configuration = configuration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBaseVersion() {
        return baseVersion;
    }

    public void setBaseVersion(String baseVersion) {
        this.baseVersion = baseVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
