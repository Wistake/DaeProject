/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "CONFIGURATIONS")
@NamedQueries({
    @NamedQuery(name = "getAllConfiguration",
            query = "SELECT c FROM Configuration c ORDER BY c.id")})
public class Configuration implements Serializable{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    private Student student;
    
    @Column(name = "CONFIGURATION_NAME")
    private ConfigurationState confState;
    
    @NotNull
    @ManyToOne
    private Software software;
    
    public Configuration(){
        //listar modulos com lista
    }
    
    @NotNull
    private String contractInfo;

    public Configuration(long id, Student student, ConfigurationState confState, Software software, String contractInfo) {
        this();
        this.id = id;
        this.student = student;
        this.confState = confState;
        this.software = software;
        this.contractInfo = contractInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ConfigurationState getConfState() {
        return confState;
    }

    public void setConfState(ConfigurationState confState) {
        this.confState = confState;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public String getContractInfo() {
        return contractInfo;
    }

    public void setContractInfo(String contractInfo) {
        this.contractInfo = contractInfo;
    }
 
}
