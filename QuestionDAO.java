package User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class QuestionDAO {
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void saveQuestion(Question question) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();

            Query checkQuery = session.createQuery(
                "SELECT count(q) FROM Question q WHERE q.questionText = :text AND q.courseName = :course");
            checkQuery.setParameter("text", question.getQuestionText());
            checkQuery.setParameter("course", question.getCourseName());

            Long count = (Long) checkQuery.uniqueResult();

            if (count == 0) {
                session.save(question);
                System.out.println("Saved new question: " + question.getQuestionText());
            } else {
                System.out.println("Duplicate question skipped: " + question.getQuestionText());
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Question> getQuestionsByCourse(String courseName) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Question q WHERE q.courseName = :course");
            query.setParameter("course", courseName);
            return query.list();
        }
    }
}
