/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ConfigurationDTO;
import entities.Configuration;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author lucas
 */
@Stateless
@Path("/configuration")
public class ConfigurationBean extends BaseBean<Configuration, ConfigurationDTO, Integer>{

}
