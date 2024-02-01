package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		//create session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .addAnnotatedClass(Course.class)
									 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		//now use this session to save/retrieve objects
		try
		{
			
			
			//begin transaction
			session.beginTransaction();
			
			//get instructor by pk
			int pk = 1;
			Instructor tempInstructor = session.get(Instructor.class, pk);
			
			//print the instructor
			System.out.println("Instructor: "+tempInstructor);
			
			//print Instructor Courses
			System.out.println("Instructor Courses: "+tempInstructor.getCourses());
			
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
