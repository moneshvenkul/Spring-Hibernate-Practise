package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session= sessionFactory.getCurrentSession();
            session.beginTransaction();
//
//            Student myStudent = session.get(Student.class, 7);
//            myStudent.setLastName("vommi");

//            session.createQuery("update Student set email='test@gmail.com'").executeUpdate();

            Student student = (Student) session.createQuery("from Student s where s.id=9").uniqueResult();

            session.getTransaction().commit();
            System.out.println("Student: "+student);
        }
        finally {
            sessionFactory.close();
        }
    }
}
