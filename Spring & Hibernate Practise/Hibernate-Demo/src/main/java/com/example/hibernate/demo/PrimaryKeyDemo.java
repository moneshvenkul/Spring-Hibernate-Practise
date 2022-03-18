package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            Student tempStudent1 = new Student("34i1v","9if6X","vux85409@gmail.com");
            Student tempStudent2 = new Student("ul9rnP","HQA2","fnzzz86i@gmail.com");
            Student tempStudent3 = new Student("YPWVoi4K","Q9qX28","RaL58@gmail.com");
            session.beginTransaction();
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }
    }
}
