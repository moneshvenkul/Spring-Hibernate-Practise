package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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

            Instructor instructor = session.get(Instructor.class, 1);

            Course course = new Course("Full Spring");

            session.save(course);

            System.out.println("Saving Course: "+ course);

            Student student = new Student("Monesh", "Venkul", "abcd@gmail.com");
            Student student1 = new Student("kG8","749ct","Dn1Q1@gmail.com");

            course.addStudent(student);
            course.addStudent(student1);

            session.save(student);
            session.save(student1);

            System.out.println("Saving Students: " + course.getStudents());

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
