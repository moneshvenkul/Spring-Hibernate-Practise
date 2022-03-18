package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMoneshDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Student student = session.get(Student.class,1);

            System.out.println("Loaded Student: "+student);

            System.out.println("Courses: "+student.getCourses());

            Course course = new Course("Virtual Development");
            Course course1 = new Course("Python Development");

            course.addStudent(student);
            course1.addStudent(student);

            session.save(course);
            session.save(course1);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
