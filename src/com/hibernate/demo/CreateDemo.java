package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		//create session Factory
		SessionFactory factory = new Configuration()
									 .configure("hibernate.cfg.xml")
									 .addAnnotatedClass(Instructor.class)
									 .addAnnotatedClass(InstructorDetail.class)
									 .buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		//now use this session to save/retrieve objects
		try
		{
			//creating the objects
			//Instructor tempInstructor = new Instructor("micheal","scott","scott@gmail.com");
			//InstructorDetail tempInstructorDetail = new InstructorDetail("scott/youtube","timepass");
			
			Instructor tempInstructor = new Instructor("Dwight","schrute","Dwight@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("dwight/youtube","security threat");
			
			//associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			//begin transaction
			session.beginTransaction();
			
			//save the instructor
			System.out.println("saving instructor "+tempInstructor);
			session.save(tempInstructor);
			//it will also save details obj bcoz of cascade as it ia a associated obj
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally
		{
			factory.close();
		}

	}

}
