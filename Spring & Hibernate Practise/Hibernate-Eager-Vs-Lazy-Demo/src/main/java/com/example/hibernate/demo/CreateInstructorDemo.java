package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Instructor instructor = new Instructor("t4e","I2mP","3w701eI@gmail.com");

            InstructorDetail instructorDetail = new InstructorDetail("i6Oz","O2CNu4fM");

            instructor.setInstructorDetail(instructorDetail);

            session.save(instructor);

            System.out.println("Saving Instructor: "+instructor);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
