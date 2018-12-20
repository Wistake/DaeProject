package ejbs;

import entities.Teacher;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TeacherBean {

    @PersistenceContext
    EntityManager em;

    public void create(
            String username,
            String password,
            String name,
            String email,
            String office) {

        try {
            Teacher teacher = new Teacher(
                    username, 
                    password, 
                    name, 
                    email,
                    office);
            em.persist(teacher);
        } catch (Exception e) {
            throw new EJBException(e.getMessage());
        }
    }
}
