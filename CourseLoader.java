
package User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.cfg.Configuration;

import java.util.List;

public class CourseLoader {
    public static void main(String[] args) {
        Session session = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course_Content.class).buildSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        List<Course_Content> allCourses = CourseData.getAllData();
        for(Course_Content c : allCourses) {
            session.save(c);
        }

        tx.commit();
        session.close();
        System.out.println("Course data loaded successfully!");
    }
}
