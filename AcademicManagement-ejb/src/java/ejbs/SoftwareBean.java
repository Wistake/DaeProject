/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.SoftwareDTO;
import entities.Software;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author 
 */
@Stateless
@Path("/software")
public class SoftwareBean extends BaseBean<Software, SoftwareDTO, Integer>{

    
}
