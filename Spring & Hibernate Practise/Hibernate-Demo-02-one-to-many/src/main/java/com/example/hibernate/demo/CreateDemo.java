package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Instructor instructor = new Instructor("5v2","8gMe1","1HDq1@mail.com");

            InstructorDetail instructorDetail = new InstructorDetail("ke95zivz1","0sR3N1");

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
