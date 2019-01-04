package ejbs;

import dtos.AdministratorDTO;
import entities.Administrator;
import entities.UserGroup;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.Path;
import util.Encryptor;

@Stateless
@Path("administrators")
public class AdministratorBean extends Bean<Administrator, AdministratorDTO, String>{

    @Override
    protected Administrator create(Administrator entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Administrator, entity));
        entity.setPassword(Encryptor.hash(entity.getPassword(), "SHA-256"));
        return super.create(entity);
    }
/*
    @Override
    public AdministratorDTO create(AdministratorDTO dto) {
        Cargo cargo = cargoBean.findOrFail(dto.getCargoCode());
        Administrator admin = toEntity(dto);
        admin.setCargo(cargo);
        admin = create(admin);        
        return toDTO(admin);
    }*/
    
    @Override
    protected Administrator update(Administrator entity) {
        entity.setGroup(new UserGroup(UserGroup.GROUP.Administrator, entity));
        Query query = createNamedQuery("Administrator.pass").setParameter("username", entity.getUsername());
        String encryptedPassword = (String) query.getSingleResult();
        
        if (! entity.getPassword().equals(encryptedPassword)) {
            encryptPassword(entity);
        }
        
        return super.update(entity);
    }
    
    private void encryptPassword(Administrator adminstrator) {
        adminstrator.setPassword(Encryptor.sha256(adminstrator.getPassword()));
    }
}
