package com.example.hibernate.demo;

import com.example.hibernate.demo.entity.Course;
import com.example.hibernate.demo.entity.Instructor;
import com.example.hibernate.demo.entity.InstructorDetail;
import com.example.hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewDemo {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);

            Course course = new Course("Spring Boot");


            Review review = new Review("Good Course");
            Review review1 = new Review("Awesome");
            Review review2 = new Review("Really Loved it!!!");

            course.addReview(review);
            course.addReview(review1);
            course.addReview(review2);

            session.save(course);
//            session.save(review1);
//            session.save(review2);

            System.out.println("Saving Instructor: " + instructor);

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
