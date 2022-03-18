package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            Student tempStudent = new Student("monesh","venkul","mvvenkul@gmail.com");
            session.beginTransaction();
            session.save(tempStudent);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
