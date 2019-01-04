/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.TemplateDTO;
import entities.Template;
import javax.ejb.Stateless;
import javax.ws.rs.Path;


/**
 *
 * @author sergi
 */
@Stateless
@Path("templates")
public class TemplateBean extends Bean<Template, TemplateDTO, Integer>{
    
}
