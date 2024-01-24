package Lesson4.Homework;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate1.cfg.xml") // Make sure this file is correctly configured
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();


        createCourse(sessionFactory, "Mathematics", 100);


        List<Course> courses = readAllCourses(sessionFactory);
        for (Course course : courses) {
            System.out.println(course);
        }


        updateCourse(sessionFactory, 1, "Advanced Mathematics", 120);


        deleteCourse(sessionFactory, 2);

        sessionFactory.close();
    }

    private static void createCourse(SessionFactory sessionFactory, String title, int duration) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Course newCourse = new Course(title, duration);
            session.save(newCourse);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    private static List<Course> readAllCourses(SessionFactory sessionFactory) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Course> courses = session.createQuery("from Course", Course.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return courses;
    }

    private static void updateCourse(SessionFactory sessionFactory, int courseId, String newTitle, int newDuration) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                course.setTitle(newTitle);
                course.setDuration(newDuration);
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    private static void deleteCourse(SessionFactory sessionFactory, int courseId) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            Course course = session.get(Course.class, courseId);
            if (course != null) {
                session.delete(course);
            }
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }
}
