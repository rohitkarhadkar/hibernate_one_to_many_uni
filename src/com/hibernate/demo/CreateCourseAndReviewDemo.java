package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		//create session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .addAnnotatedClass(Review.class)
									 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		//now use this session to save/retrieve objects
		try
		{
			
			
			//begin transaction
			session.beginTransaction();
			
			//create a course
			Course tempCourse = new Course("Processor Architecture Interfacing");
			
			//create reviews for the course
			Review tempReview1 = new Review("Was a tuff course i scored 41");
			Review tempReview2 = new Review("Was a tuff course i falied!!");
			Review tempReview3 = new Review("Wasnt that tuff i got 89");
			
			//Add reviews in course
			tempCourse.addReview(tempReview1);
			tempCourse.addReview(tempReview2);
			tempCourse.addReview(tempReview3);

			//save reviews to db
			System.out.println("Reviews will be auto saved by course bcoz of cascade ALL!!");
			session.save(tempCourse);
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally
		{
			//to avoid leakage
			session.close();
			factory.close();
		}

	}

}
