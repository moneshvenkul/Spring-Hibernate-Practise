package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class,4);

            System.out.println("Instructor Detail: "+instructorDetail);

            System.out.println("Instructor: "+instructorDetail.getInstructor());

            // remove the associated object reference
            // break bidirectional link
            instructorDetail.getInstructor().setInstructorDetail(null);

            System.out.println("Deleting instructor Detail");

            session.delete(instructorDetail);

            session.getTransaction().commit();
        }
        catch (Exception exc){
            exc.printStackTrace();
            System.out.println("Inside Catch");
        }
        finally {
            sessionFactory.close();
        }
    }
}
