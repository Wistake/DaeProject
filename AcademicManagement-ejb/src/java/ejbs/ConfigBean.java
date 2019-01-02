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

       // try {          
            administratorBean.create(new AdministratorDTO("a1", "a1", "a1", "a1@ipleiria.pt", "Chefe"));
            administratorBean.create(new AdministratorDTO("a2", "a2", "a2", "a2@ipleiria.pt", "Sub-Chefe"));
            administratorBean.create(new AdministratorDTO("a3", "a3", "a3", "a3@ipleiria.pt", "Diretor"));
            
            
            ClientDTO c1 = clientBean.create(new ClientDTO("XPTO", "morada1", "pessoa1", "c1", "c1", "cliente1", "c1@mail.teste"));
            ClientDTO c2 = clientBean.create(new ClientDTO("GOOGLE", "morada2", "pessoa2", "c2", "c2", "cliente2", "c2@mail.teste"));
            ClientDTO c3 = clientBean.create(new ClientDTO("APPLE", "morada3", "pessoa3", "c3", "c3", "cliente3", "c3@mail.teste"));

            SoftwareDTO s1 = softwareBean.create(new SoftwareDTO("v.1.0", "solftware1", c1.getUsername()));
            SoftwareDTO s2 = softwareBean.create(new SoftwareDTO("v.2.0", "solftware2", c1.getUsername()));
            SoftwareDTO s3 = softwareBean.create(new SoftwareDTO("v.1.1", "solftware3", c2.getUsername()));
            SoftwareDTO s4 = softwareBean.create(new SoftwareDTO("v.1.5", "solftware4", c2.getUsername()));

            ConfigurationDTO conf1 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(),  "descricao1", "Don't share my information", "Allow all my employees", "Basic", "configuracao1", ConfigurationState.ACTIVE));
            ConfigurationDTO conf2 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(),  "descricao2",  "Can use my data to improve the system", "Allow all my employees", "Gold", "configuracao2", ConfigurationState.INACTIVE));
            ConfigurationDTO conf3 = configuracaoBean.create(new ConfigurationDTO(s2.getIdSoftware(),  "descricao3", "All bock", "Specific people that i choose can see it", "Premium", "configuracao3", ConfigurationState.ACTIVE));
            ConfigurationDTO conf4 = configuracaoBean.create(new ConfigurationDTO(s2.getIdSoftware(),  "descricao4", "Don't share my information", "All bock only the user can acess", "Basic", "configuracao4", ConfigurationState.SUSPENCE));
            ConfigurationDTO conf5 = configuracaoBean.create(new ConfigurationDTO(s3.getIdSoftware(),  "descricao5", "Can use my data to improve the system", "All bock, only the user can acess", "Basic", "configuracao5", ConfigurationState.ACTIVE));


            TemplateDTO temp1 = templateBean.create(new TemplateDTO("Template1", "DescricaoTemplate1", "All bock", "Only the client can see it", "Max security accont"));
            TemplateDTO temp2 = templateBean.create(new TemplateDTO("Template2", "DescricaoTemplate2", "Can use my data to improve the system", "Allow all my employees", "Gold"));
            TemplateDTO temp3 = templateBean.create(new TemplateDTO("Template3", "DescricaoTemplate3", "All bock", "Specific people that i choose can see it", "Premium"));
            TemplateDTO temp4 = templateBean.create(new TemplateDTO("Template4", "DescricaoTemplate4", "Don't share my information", "All bock only the user can acess", "Basic"));
            TemplateDTO temp5 = templateBean.create(new TemplateDTO("Template5", "DescricaoTemplate5", "Can use my data to improve the system", "All bock, only the user can acess", "Basic"));
           
            ModuloDTO mod1 = moduloBean.create(new ModuloDTO("Modulo1", conf1.getCode()));
            ModuloDTO mod2 = moduloBean.create(new ModuloDTO("Modulo2", conf1.getCode()));
            ModuloDTO mod3 = moduloBean.create(new ModuloDTO("Modulo3", conf1.getCode()));
            ModuloDTO mod4 = moduloBean.create(new ModuloDTO("Modulo4", conf2.getCode()));
            

            //TemplateDTO temp5 = templateBean.create(new TemplateDTO("Template5", "DescricaoTemplate5"));
            
           /* ConfigurationDTO confT1 = configuracaoBean.create(new ConfigurationDTO("configuracaoTemplate1", temp1.getTemplateName(), "configuracaoT1"));
            ConfigurationDTO confT2 = configuracaoBean.create(new ConfigurationDTO("configuracaoTemplate2", temp2.getTemplateName(), "configuracaoT2"));
            ConfigurationDTO confT3 = configuracaoBean.create(new ConfigurationDTO("configuracaoTemplate3", temp3.getTemplateName(), "configuracaoT3"));
            ConfigurationDTO confT4 = configuracaoBean.create(new ConfigurationDTO("configuracaoTemplate4", temp4.getTemplateName(), "configuracaoT4"));*/
            
            
           // studentBean.create(new ClientDTO("1111111", "111", "Travessa das Cenas", "987654321", 1, null));
            /*studentBean.create(new StudentDTO("2222222", "111", "Buraca", "900000000", 2, null));
            studentBean.create(new StudentDTO("3333333", "111", "Debaixo da Ponte", "911111111", 3, null));*/

           /* subjectBean.create(1, "P1", 1, 1, "2015/2016");
            subjectBean.create(2, "PA", 1, 2, "2015/2016");
            subjectBean.create(3, "IA", 1, 2, "2015/2016");
            subjectBean.create(4, "DAE", 1, 3, "2015/2016");
            subjectBean.create(5, "ComputProg", 2, 1, "2015/2016");
            subjectBean.create(6, "ComplProg", 2, 1, "2015/2016");
            subjectBean.create(7, "PA", 2, 2, "2015/2016");*/
         /*  
            SoftwareDTO s1 = softwareBean.create(new SoftwareDTO("v.1.0", "solftware1", c1.getUsername()));
            
            ConfigurationDTO conf1 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(), "descricao1", "configuracao1", ConfigurationState.INACTIVE));

*/
            /*studentBean.enrollStudentInSubject("1111111", 1);
            studentBean.enrollStudentInSubject("1111111", 2);
            studentBean.enrollStudentInSubject("2222222", 3);
            studentBean.enrollStudentInSubject("2222222", 4);
            studentBean.enrollStudentInSubject("3333333", 5);
            studentBean.enrollStudentInSubject("3333333", 6);
            studentBean.enrollStudentInSubject("4444444", 6);
            studentBean.enrollStudentInSubject("4444444", 7);*/

            /*teacherBean.create("t1", "t1", "t1", "t1@ipleiria.pt", "O1");
            teacherBean.create("t2", "t2", "t2", "t2@ipleiria.pt", "O2");
            teacherBean.create("t3", "t3", "t3", "t3@ipleiria.pt", "O3");*/
            
            

            
            //falta dar add do software
            //templateBean.create(new TemplateDTO(1, "Primeiro Template"));
            

      /* } catch (Exception e) {
            logger.warning(e.getMessage());
        }*/
    }

}
