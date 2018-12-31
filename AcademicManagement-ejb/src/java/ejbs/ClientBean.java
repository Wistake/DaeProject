/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.ClientDTO;
import entities.Client;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author lucas
 */
@Stateless
@Path("/clients")
public class ClientBean extends BaseBean<Client, ClientDTO, String>{    
   
}
