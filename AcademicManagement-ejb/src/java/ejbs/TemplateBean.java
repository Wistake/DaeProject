/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.TemplateDTO;
import entities.Template;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.Path;


/**
 *
 * @author sergi
 */
@Stateless
@Path("templates")
public class TemplateBean extends Bean<Template, TemplateDTO, String>{

    @Override
    @RolesAllowed({"Administrator"})
    public TemplateDTO create(TemplateDTO dto) {
        return super.create(dto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RolesAllowed({"Administrator"})
    public TemplateDTO update(String primaryKey, TemplateDTO dto) {
        return super.update(primaryKey, dto); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @RolesAllowed({"Administrator"})
    public boolean delete(String primaryKey) {
        return super.delete(primaryKey); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    @PermitAll
    public List<TemplateDTO> all() {
        return super.all(); 
    }

    @Override
    @PermitAll
    public TemplateDTO retrieve(String primaryKey) {
        return super.retrieve(primaryKey); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
