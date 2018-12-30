/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Software;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Template")
@XmlAccessorType(XmlAccessType.FIELD)
public class TemplateDTO implements DTO{
    private Integer idName;
    private String descricao;
    //private List<Software> software;
    
    public TemplateDTO(){
        //software = new LinkedList<>();
    }

    public TemplateDTO(Integer idName, String descricao) {
        this.idName = idName;
        this.descricao = descricao;
        //software = new LinkedList<>();
    }

    @Override
    public void clear() {
        idName = null;
        descricao = null;
    }

    /*public List<Software> getSoftware() {
    //    return software;
    }

    public void setSoftware(List<Software> software) {
        //this.software = software;
    }*/
    
    
    public void reset(){
        idName = 0;
        descricao = null;
    }

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
