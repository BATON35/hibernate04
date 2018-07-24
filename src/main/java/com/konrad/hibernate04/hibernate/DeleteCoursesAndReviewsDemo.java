package com.konrad.hibernate04.hibernate;


import com.konrad.hibernate04.entity.Course;
import com.konrad.hibernate04.entity.Instructor;
import com.konrad.hibernate04.entity.InstructorDetail;
import com.konrad.hibernate04.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCoursesAndReviewsDemo {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int id = 10;
            Course course = session.get(Course.class, id);
            //print course
            System.out.println(course);
            System.out.println(course.getReviews());
            //delete course
            session.delete(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }

}
