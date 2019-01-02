/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.SoftwareDTO;
import entities.Client;
import entities.License;
import entities.Software;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 *
 * @author 
 */
@Stateless
@Path("/softwares")
public class SoftwareBean extends Bean<Software, SoftwareDTO, Integer>{

    @EJB
    private ClientBean clientBean;
    @EJB
    private LicenseBean licenseBean;
    
    
    @Override
    public SoftwareDTO create(SoftwareDTO dto) {
        Client client = clientBean.findOrFail(dto.getClienteUsername());
        Software soft = toEntity(dto);
        soft.setClient(client);
        soft = create(soft);
        return toDTO(soft);
    }
    
    public void enrollLicenseInSoftware(Integer sofId, Integer licenseID){
        Software software = this.findOrFail(sofId);
        License license = licenseBean.findOrFail(licenseID);
        if(software.getLicenses().contains(license) || license.getSoftwares().contains(software)){
            return;
        }
        
        software.addLicense(license);
        license.addSoftware(software);
        em.merge(software);
        em.merge(license);
    }
    
}
