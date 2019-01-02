/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ModuloDTO;
import entities.Configuration;
import entities.Modulo;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author lucas
 */
@Stateless
@Path("/modulos")
public class ModuloBean extends Bean<Modulo, ModuloDTO, Integer>{
    @EJB
    ConfigurationBean configurationBean;

    @Override
    public ModuloDTO create(ModuloDTO dto) {
        Configuration conf = configurationBean.findOrFail(dto.getConfigurationCode());
        Modulo modulo = toEntity(dto);
        modulo.setConfiguration(conf);
        modulo = create(modulo);
        return toDTO(modulo);
    }
    
    
    
}
