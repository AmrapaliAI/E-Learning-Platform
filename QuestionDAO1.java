package User;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import java.util.Random;

public class QuestionDAO1 {

    private final SessionFactory sessionFactory;
    private final Random rnd = new Random();

    public QuestionDAO1() {
        // Ensure hibernate.cfg.xml includes mapping for Question entity
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void close() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }

    // Fetch a random question by course
    public Question getRandomQuestionByCourse(String courseName) {
        try (Session session = sessionFactory.openSession()) {
            List<Question> questions = session
                .createQuery("FROM Question q WHERE q.courseName = :course")
                .setParameter("course", courseName)
                .list();

            if (questions == null || questions.isEmpty()) {
                return null;
            }
            return questions.get(rnd.nextInt(questions.size()));
        }
    }

    // Save question if unique for course
    public void saveQuestion(Question question) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            Query checkQuery = session.createQuery(
                "SELECT count(q) FROM Question q WHERE q.questionText = :text AND q.courseName = :course"
            );
            checkQuery.setParameter("text", question.getQuestionText());
            checkQuery.setParameter("course", question.getCourseName());

            Long count = (Long) checkQuery.uniqueResult();

            if (count == 0) {
                transaction = session.beginTransaction();
                session.save(question);
                transaction.commit();
                System.out.println("Saved new question: " + question.getQuestionText() +
                                   " for course: " + question.getCourseName());
            } else {
                System.out.println("Question already exists for course " + question.getCourseName() +
                                   ". Skipping: " + question.getQuestionText());
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.err.println("Error saving question: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Get all questions for a course
    public List<Question> getQuestionsByCourse(String courseName) {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Question q WHERE q.courseName = :course");
            query.setParameter("course", courseName);
            return query.list();
        } catch (Exception e) {
            System.err.println("Error fetching questions for course " + courseName + ": " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // ==================== ADDED METHOD ====================
    // Get all questions (used for searching direct answers)
    public List<Question> getAllQuestions() {
        try (Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("FROM Question");
            return query.list();
        } catch (Exception e) {
            System.err.println("Error fetching all questions: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Fetch a question that matches user query (for direct answer)
    public Question getExactOrRelatedQuestion(String query) {
        // Example: simple match by question text containing keywords
        for (Question q : getAllQuestions()) {
            if (q.getQuestionText().toLowerCase().contains(query.toLowerCase())) {
                return q;
            }
        }
        return null; // no match
    }

}
