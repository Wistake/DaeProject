package ejbs;

import dtos.AdministratorDTO;
import dtos.StudentDTO;
import dtos.TemplateDTO;
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
    private StudentBean studentBean;
    @EJB
    private SubjectBean subjectBean;
    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private TeacherBean teacherBean;
    @EJB
    private TemplateBean templateBean;

    @PostConstruct
    public void populateDB() {

        try {
            courseBean.create(1, "Google");
            courseBean.create(2, "Twitter");
            courseBean.create(3, "Amazon");
            courseBean.create(4, "Facebook");
            courseBean.create(5, "Alibaba");
            courseBean.create(6, "Ebay");
            
            cargoBean.create(1, "Chefe");
            cargoBean.create(2, "Sub-Chefe");

            studentBean.create(new StudentDTO("1111111", "111", "Travessa das Cenas", "987654321", 1, null));
            studentBean.create(new StudentDTO("2222222", "111", "Buraca", "900000000", 2, null));
            studentBean.create(new StudentDTO("3333333", "111", "Debaixo da Ponte", "911111111", 3, null));

            subjectBean.create(1, "P1", 1, 1, "2015/2016");
            subjectBean.create(2, "PA", 1, 2, "2015/2016");
            subjectBean.create(3, "IA", 1, 2, "2015/2016");
            subjectBean.create(4, "DAE", 1, 3, "2015/2016");
            subjectBean.create(5, "ComputProg", 2, 1, "2015/2016");
            subjectBean.create(6, "ComplProg", 2, 1, "2015/2016");
            subjectBean.create(7, "PA", 2, 2, "2015/2016");

            studentBean.enrollStudentInSubject("1111111", 1);
            studentBean.enrollStudentInSubject("1111111", 2);
            studentBean.enrollStudentInSubject("2222222", 3);
            studentBean.enrollStudentInSubject("2222222", 4);
            studentBean.enrollStudentInSubject("3333333", 5);
            studentBean.enrollStudentInSubject("3333333", 6);
            studentBean.enrollStudentInSubject("4444444", 6);
            studentBean.enrollStudentInSubject("4444444", 7);

            teacherBean.create("t1", "t1", "t1", "t1@ipleiria.pt", "O1");
            teacherBean.create("t2", "t2", "t2", "t2@ipleiria.pt", "O2");
            teacherBean.create("t3", "t3", "t3", "t3@ipleiria.pt", "O3");
            
            administratorBean.create(new AdministratorDTO("a1", "a1", "a1", "a1@ipleiria.pt", 1, null));
            administratorBean.create(new AdministratorDTO("a2", "a2", "a2", "a2@ipleiria.pt", 2, null));
            administratorBean.create(new AdministratorDTO("a3", "a3", "a3", "a3@ipleiria.pt", 2, null));
            
            //falta dar add do software
            templateBean.create(new TemplateDTO(1, "Primeiro Template"));
            

        } catch (EntityDoesNotExistException
                | EntityExistsException
                | MyConstraintViolationException e) {
            logger.warning(e.getMessage());
        }
    }

}
