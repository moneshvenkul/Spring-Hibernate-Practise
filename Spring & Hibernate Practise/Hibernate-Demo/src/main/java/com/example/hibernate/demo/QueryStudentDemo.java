package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();
//
//            List<Student> students = session.createQuery("from Student ").getResultList();

//            List<Student> students = session.createQuery("from Student s where s.lastName='venkul'").getResultList();

//            List<Student> students = session.createQuery("from Student s where s.firstName = 'venkul' or s.lastName='Q9qX28'").getResultList();

            List<Student> students = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();

            displayStudents(students);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }

    private static void displayStudents(List<Student> students) {
        for(Student student : students){
            System.out.println(student);
        }
    }
}
