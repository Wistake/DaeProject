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

      //  try {        
            administratorBean.create(new AdministratorDTO("a1", "a1", "a1", "a1@ipleiria.pt", "Chefe"));
            administratorBean.create(new AdministratorDTO("a2", "a2", "a2", "a2@ipleiria.pt", "Sub-Chefe"));
            administratorBean.create(new AdministratorDTO("a3", "a3", "a3", "a3@ipleiria.pt", "Diretor"));
            
            //ClientDTO c1 = clientBean.create(new ClientDTO("XPTO", "morada1", "pessoa1", "c1", "c1", "cliente1", "sergiotrindade100@gmail.com"));
              ClientDTO c1 = clientBean.create(new ClientDTO("XPTO", "morada1", "pessoa1", "c1", "c1", "cliente1", "karintech89@gmail.com"));
              ClientDTO c2 = clientBean.create(new ClientDTO("GOOGLE", "morada2", "pessoa2", "c2", "c2", "cliente2", "sergiotrindade100@gmail.com"));
              ClientDTO c3 = clientBean.create(new ClientDTO("APPLE", "morada3", "pessoa3", "c3", "c3", "cliente3", "c3@mail.teste"));
            

            SoftwareDTO s1 = softwareBean.create(new SoftwareDTO("v.1.0", "software1", c1.getUsername()));
            SoftwareDTO s2 = softwareBean.create(new SoftwareDTO("v.2.0", "software2", c1.getUsername()));
            SoftwareDTO s3 = softwareBean.create(new SoftwareDTO("v.1.1", "software3", c2.getUsername()));
            SoftwareDTO s4 = softwareBean.create(new SoftwareDTO("v.1.5", "software4", c3.getUsername()));

            ConfigurationDTO conf1 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(), "configuracao1", "descricaoDaConfiguracao1", ConfigurationState.ACTIVE, 255, "ON TV", "Como programar para totós", "ManualUser1", s1.getClienteUsername()));
            ConfigurationDTO conf2 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(), "configuracao2", "descricaoDaConfiguracao2", ConfigurationState.INACTIVE, 10, "ON YOUTUBE", "Como programar para totós2", "ManualUser2", s1.getClienteUsername()));
            ConfigurationDTO conf3 = configuracaoBean.create(new ConfigurationDTO(s2.getIdSoftware(), "configuracao3", "descricaoDaConfiguracao3", ConfigurationState.ACTIVE, 60, "SUBSCRIBE TO PEWDIEPIE", "Como programar para totós 3", "ManualUser3", s2.getClienteUsername()));
            //ConfigurationDTO conf3 = configuracaoBean.create(new ConfigurationDTO(s4.getIdSoftware(), "configuracao3", "descricao de: "+s4.getClienteUsername(), ConfigurationState.SUSPENCE, 70, c3.getUsername()));
            //ConfigurationDTO conf4 = configuracaoBean.create(new ConfigurationDTO(s2.getIdSoftware(), "configuracao4", "descricao de: "+s2.getClienteUsername(), ConfigurationState.SUSPENCE, 10, c1.getUsername()));
            //ConfigurationDTO conf5 = configuracaoBean.create(new ConfigurationDTO(s3.getIdSoftware(), "configuracao5", "descricao de: "+s3.getClienteUsername(), ConfigurationState.SUSPENCE, 5, c2.getUsername()));

            TemplateDTO temp1 = templateBean.create(new TemplateDTO("Template1", "DescricaoTemplate1", "Descricao da Configuracao Feita no Template", ConfigurationState.INACTIVE, 1000, "GOOGLE ADS", "Como instalar um RAM online", "Manual Utilizador Via Template 1"));
            TemplateDTO temp2 = templateBean.create(new TemplateDTO("Template2", "DescricaoTemplate2", "Descricao da Configuracao Feita no Template2", ConfigurationState.INACTIVE, 50, "GOOGLE ADS 2", "Como instalar um RAM online2", "Manual Utilizador Via Template 2"));
            TemplateDTO temp3 = templateBean.create(new TemplateDTO("Template3", "DescricaoTemplate3", "Descricao da Configuracao Feita no Template3", ConfigurationState.INACTIVE, 10, "GOOGLE ADS 3", "Como instalar um RAM online3", "Manual Utilizador Via Template 3"));
            TemplateDTO temp4 = templateBean.create(new TemplateDTO("Template4", "DescricaoTemplate4", "Descricao da Configuracao Feita no Template4", ConfigurationState.INACTIVE, 1, "GOOGLE ADS 4", "Como instalar um RAM online4", "Manual Utilizador Via Template 4"));
            TemplateDTO temp5 = templateBean.create(new TemplateDTO("Template5", "DescricaoTemplate5", "Descricao da Configuracao Feita no Template5", ConfigurationState.INACTIVE, 69, "GOOGLE ADS 5", "Como instalar um RAM online5", "Manual Utilizador Via Template 5"));


            ModuloDTO mod1 = moduloBean.create(new ModuloDTO("Modulo1", conf1.getCode()));
            ModuloDTO mod2 = moduloBean.create(new ModuloDTO("Modulo2", conf1.getCode()));
            //ModuloDTO mod3 = moduloBean.create(new ModuloDTO("Modulo3", conf2.getCode()));

         
      /* } catch (Exception e) {
            logger.warning(e.getMessage());
        }*/
        
    }

}
