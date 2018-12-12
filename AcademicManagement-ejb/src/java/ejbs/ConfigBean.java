package ejbs;

import dtos.StudentDTO;
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
    private StudentBean studentBean;
    @EJB
    private SubjectBean subjectBean;
    @EJB
    private AdministratorBean administratorBean;
    @EJB
    private TeacherBean teacherBean;

    @PostConstruct
    public void populateDB() {

        try {
            courseBean.create(1, "EI");
            courseBean.create(2, "IS");
            courseBean.create(3, "JDM");
            courseBean.create(4, "SIS");
            courseBean.create(5, "MEI-CM");
            courseBean.create(6, "MGSIM");

            studentBean.create(new StudentDTO("1111111", "Manuel", "Manuel", "dae.ei.ipleiria@gmail.com", 1, null));
            studentBean.create(new StudentDTO("2222222", "Antonio", "António", "dae.ei.ipleiria@gmail.com", 1, null));
            studentBean.create(new StudentDTO("3333333", "Ana", "Ana", "dae.ei.ipleiria@gmail.com", 2, null));
            studentBean.create(new StudentDTO("4444444", "Jose", "José", "dae.ei.ipleiria@gmail.com", 2, null));
            studentBean.create(new StudentDTO("5555555", "Maria", "Maria", "dae.ei.ipleiria@gmail.com", 3, null));
            studentBean.create(new StudentDTO("6666666", "Joaquim", "Joaquim", "dae.ei.ipleiria@gmail.com", 3, null));
            studentBean.create(new StudentDTO("7777777", "Alzira", "Alzira", "dae.ei.ipleiria@gmail.com", 4, null));
            studentBean.create(new StudentDTO("8888888", "Pedro", "Pedro", "dae.ei.ipleiria@gmail.com", 4, null));

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

            administratorBean.create("a1", "a1", "a1", "a1@ipleiria.pt");
            administratorBean.create("a2", "a2", "a2", "a2@ipleiria.pt");
            administratorBean.create("a3", "a3", "a3", "a3@ipleiria.pt");

        } catch (EntityDoesNotExistException
                | EntityExistsException
                | MyConstraintViolationException e) {
            logger.warning(e.getMessage());
        }
    }

}
