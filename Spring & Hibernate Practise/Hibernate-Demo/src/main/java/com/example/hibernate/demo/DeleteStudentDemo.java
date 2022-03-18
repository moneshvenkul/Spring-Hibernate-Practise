package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{

            session= sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Student student = (Student) session.createQuery("from Student s where s.id=7").uniqueResult();
//            session.delete(student);
            session.createQuery("delete from Student where id=8").executeUpdate();
            session.getTransaction().commit();
//            System.out.println("Student: "+student);
        }
        finally {
            sessionFactory.close();
        }
    }
}
