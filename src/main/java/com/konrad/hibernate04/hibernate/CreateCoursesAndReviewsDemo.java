package com.konrad.hibernate04.hibernate;


import com.konrad.hibernate04.entity.Course;
import com.konrad.hibernate04.entity.Instructor;
import com.konrad.hibernate04.entity.InstructorDetail;
import com.konrad.hibernate04.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviewsDemo {

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
            Course course = new Course("Jumping school level 2!!!");
            course.addReview(new Review("What a dumb course"));
            course.addReview(new Review("Whaaaaat !!!"));
            session.save(course);
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            session.close();
            factory.close();
        }
    }

}
