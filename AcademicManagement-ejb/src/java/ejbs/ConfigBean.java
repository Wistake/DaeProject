package ejbs;

import dtos.AdministratorDTO;
import dtos.CargoDTO;
import dtos.ClientDTO;
import dtos.ConfigurationDTO;
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
    private CourseBean courseBean;
    @EJB
    private CargoBean cargoBean;
    @EJB
    private ClientBean clientBean;
    @EJB
    private SubjectBean subjectBean;
    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private TeacherBean teacherBean;
    @EJB
    private TemplateBean templateBean;
    @EJB
    private SoftwareBean softwareBean;
    @EJB
    private ConfigurationBean configuracaoBean;

    @PostConstruct
    public void populateDB() {

        try {
            /*courseBean.create(1, "Google");
            courseBean.create(2, "Twitter");
            courseBean.create(3, "Amazon");
            courseBean.create(4, "Facebook");
            courseBean.create(5, "Alibaba");
            courseBean.create(6, "Ebay");*/
            
            CargoDTO cargo1 = cargoBean.create(new CargoDTO("Chefe"));
            CargoDTO cargo2 = cargoBean.create(new CargoDTO("Sub-Chefe"));
            
            administratorBean.create(new AdministratorDTO("a1", "a1", "a1", "a1@ipleiria.pt", cargo1.getCargoCode(), null));
            administratorBean.create(new AdministratorDTO("a2", "a2", "a2", "a2@ipleiria.pt", cargo2.getCargoCode(), null));
            administratorBean.create(new AdministratorDTO("a3", "a3", "a3", "a3@ipleiria.pt", cargo2.getCargoCode(), null));
            
            
            ClientDTO c1 = clientBean.create(new ClientDTO("empresa1", "morada1", "pessoa1", "c1", "c1", "cliente1", "c1@mail.teste"));


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
            
            SoftwareDTO s1 = softwareBean.create(new SoftwareDTO("v.1.0", "solftware1", c1.getUsername()));
            
            ConfigurationDTO conf1 = configuracaoBean.create(new ConfigurationDTO(s1.getIdSoftware(), "descricao1", "configuracao1", ConfigurationState.INACTIVE));


           /* studentBean.enrollStudentInSubject("1111111", 1);
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
            

        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

}
