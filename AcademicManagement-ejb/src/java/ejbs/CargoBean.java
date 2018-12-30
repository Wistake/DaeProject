/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbs;

import dtos.CargoDTO;
import dtos.CourseDTO;
import entities.Cargo;
import entities.Course;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("/cargos")
public class CargoBean extends Bean<Cargo, CargoDTO, Integer>{
    
}
    
    
    /*
    @PersistenceContext
    EntityManager em;
    
    public void create(int code, String name) {
        try {
            Cargo cargo = new Cargo(code, name);
            em.persist(cargo);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("all")        
    public Collection<CargoDTO> getAll() {
        try {
            List<Cargo> cargos
                    = em.createNamedQuery("getAllCargos").getResultList();
            return toDTOs(cargos, CargoDTO.class);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }

    public void remove(int code){
        try {
            Cargo cargo = em.find(Cargo.class, code);
            if (cargo == null) {
                return;
            }
            em.remove(cargo);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }        
    }    
    */

