/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.LicenseDTO;
import entities.License;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author lucas
 */
@Stateless
@Path("/licenses")
public class LicenseBean extends Bean<License, LicenseDTO, Integer>{


}
