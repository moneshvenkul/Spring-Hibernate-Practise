package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            Student tempStudent = new Student("monesh","venkul","mvvenkul@gmail.com");
            session.beginTransaction();
            session.save(tempStudent);
            System.out.println(tempStudent);
            session.getTransaction().commit();

            session= sessionFactory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = session.get(Student.class, tempStudent.getId());
            session.getTransaction().commit();
            System.out.println("Student: "+myStudent);
        }
        finally {
            sessionFactory.close();
        }
    }
}
