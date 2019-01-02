package ejbs;

import dtos.AdministratorDTO;
import dtos.ClientDTO;
import dtos.ConfigurationDTO;
import dtos.ModuloDTO;
import dtos.SoftwareDTO;
import dtos.StudentDTO;
import dtos.TemplateDTO;
import entities.ConfigurationState;
import exceptions.EntityDoesNotExistException;
import exceptions.EntityExistsException;
import exceptions.MyConstraintViolationException;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class ConfigBean {

    private static final Logger logger = Logger.getLogger("ejbs.ConfigBean");
    @EJB
    private ClientBean clientBean;
    @EJB
    private StudentBean studentBean;
    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private TemplateBean templateBean;
    @EJB
    private SoftwareBean softwareBean;
    @EJB
    private ConfigurationBean configuracaoBean;
    @EJB
    private ModuloBean moduloBean;

    @PostConstruct
    public void populateDB() {

        try {          
            administratorBean.create(new AdministratorDTO("a1", "a1", "a1", "a1@ipleiria.pt", "Chefe"));
            administratorBean.create(new AdministratorDTO("a2", "a2", "a2", "a2@ipleiria.pt", "Sub-Chefe"));
            administratorBean.create(new AdministratorDTO("a3", "a3", "a3", "a3@ipleiria.pt", "Diretor"));
            
            //ClientDTO c1 = clientBean.create(new ClientDTO("XPTO", "morada1", "pessoa1", "c1", "c1", "cliente1", "sergiotrindade100@gmail.com"));
              ClientDTO c1 = clientBean.create(new ClientDTO("XPTO", "morada1", "pessoa1", "c1", "c1", "cliente1", "c1@mail.teste"));
              ClientDTO c2 = clientBean.create(new ClientDTO("GOOGLE", "morada2", "pessoa2", "c2", "c2", "cliente2", "c2@mail.teste"));
              ClientDTO c3 = clientBean.create(new ClientDTO("APPLE", "morada3", "pessoa3", "c3", "c3", "cliente3", "c3@mail.teste"));
            

            SoftwareDTO s1 = softwareBean.create(new SoftwareDTO("v.1.0", "solftware1", c1.getUsername()));
            SoftwareDTO s2 = softwareBean.create(new SoftwareDTO("v.2.0", "solftware2", c1.getUsername()));
            SoftwareDTO s3 = softwareBean.create(new SoftwareDTO("v.1.1", "solftware3", c2.getUsername()));
            SoftwareDTO s4 = softwareBean.create(new SoftwareDTO("v.1.5", "solftware4", c2.getUsername()));

            ConfigurationDTO conf1 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(), "configuracao1", "descricao1", ConfigurationState.ACTIVE, 22));
            ConfigurationDTO conf2 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(), "configuracao2", "descricao2", ConfigurationState.INACTIVE, 55));
            ConfigurationDTO conf3 = configuracaoBean.create(new ConfigurationDTO(s2.getIdSoftware(), "configuracao3", "descricao3", ConfigurationState.SUSPENCE, 70));
            ConfigurationDTO conf4 = configuracaoBean.create(new ConfigurationDTO(s2.getIdSoftware(), "configuracao4", "descricao4", ConfigurationState.SUSPENCE, 10));
            ConfigurationDTO conf5 = configuracaoBean.create(new ConfigurationDTO(s3.getIdSoftware(), "configuracao5", "descricao5", ConfigurationState.SUSPENCE, 5));

            TemplateDTO temp1 = templateBean.create(new TemplateDTO("Template1", "DescricaoTemplate1", "Config1", "descricaoConfig1", 11, ConfigurationState.ACTIVE));
            TemplateDTO temp2 = templateBean.create(new TemplateDTO("Template2", "DescricaoTemplate2", "Config2", "descricaoConfig2", 22, ConfigurationState.ACTIVE));
            TemplateDTO temp3 = templateBean.create(new TemplateDTO("Template3", "DescricaoTemplate3", "Config3", "descricaoConfig3", 33, ConfigurationState.INACTIVE));
            TemplateDTO temp4 = templateBean.create(new TemplateDTO("Template4", "DescricaoTemplate4", "Config4", "descricaoConfig4", 44, ConfigurationState.SUSPENCE));
            TemplateDTO temp5 = templateBean.create(new TemplateDTO("Template5", "DescricaoTemplate5", "Config5", "descricaoConfig5", 55, ConfigurationState.SUSPENCE));
            
            ModuloDTO mod1 = moduloBean.create(new ModuloDTO("Modulo1", conf1.getCode()));
            ModuloDTO mod2 = moduloBean.create(new ModuloDTO("Modulo2", conf1.getCode()));
            ModuloDTO mod3 = moduloBean.create(new ModuloDTO("Modulo3", conf2.getCode()));

           
       } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

}
