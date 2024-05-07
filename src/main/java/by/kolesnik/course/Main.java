package by.kolesnik.course;

import by.kolesnik.course.entity.Course;
import by.kolesnik.course.entity.Group;
import by.kolesnik.course.entity.RecordBook;
import by.kolesnik.course.entity.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


import java.util.List;

public class Main {

    public static SessionFactory sessionFactory = null;

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().build();
        sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(RecordBook.class)
                .addAnnotatedClass(Group.class)
                .addAnnotatedClass(Course.class)
                .buildMetadata()
                .buildSessionFactory();

        selectStudents();

        sessionFactory.close();
    }

    private static void selectStudents() {
        final List<Student> students = sessionFactory.fromSession(session -> {
            final Query<Student> query = session.createQuery("from Student", Student.class);
            return query.list();
        });

        for(Student student : students) {
            final Double rating = student.getRecordBook().getRating();
            System.out.printf("Студент: %s %s: %f\n", student.getName(), student.getLastName(), rating);
        }
    }
}
















