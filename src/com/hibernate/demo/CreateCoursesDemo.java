package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			
			//create courses for instructor
			Course tempCourse1 = new Course("Batting");
			Course tempCourse2 = new Course("Fielding");
			
			//add courses in instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			//save courses to db
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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
