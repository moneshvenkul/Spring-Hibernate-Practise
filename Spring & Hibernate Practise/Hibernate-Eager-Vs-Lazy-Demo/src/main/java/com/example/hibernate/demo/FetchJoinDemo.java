 package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


 public class FetchJoinDemo {
     public static void main(String[] args) {
         SessionFactory sessionFactory = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(Instructor.class)
                 .addAnnotatedClass(InstructorDetail.class)
                 .addAnnotatedClass(Course.class)
                 .buildSessionFactory();

         Session session = sessionFactory.getCurrentSession();

         try {
             session.beginTransaction();


             Query<Instructor> query = session.createQuery("select i from Instructor i "
                     +"JOIN FETCH i.courses "
                     +"where i.id=:theInstructorId"
                     ,Instructor.class);

             query.setParameter("theInstructorId",1);

             Instructor instructor = query.getSingleResult();

             System.out.println("instructor: "+instructor);


             session.getTransaction().commit();
         } finally {
             sessionFactory.close();
         }
     }
 }
