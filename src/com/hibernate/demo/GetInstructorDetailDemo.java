package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

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
			
			
			//begin transaction
			session.beginTransaction();
			
			//get InstructorDetail obj
			int pk = 211;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, pk);
			
			//print InstructorDetail obj
			System.out.println("InstructorDetail obj: "+tempInstructorDetail);
			
			//print associated Instructor obj
			System.out.println("Associated Instructor obj: "+tempInstructorDetail.getInstructor());
			
			//commit
			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		}
		finally
		{
			//handle connection leak issue
			session.close();
			
			factory.close();
		}

	}

}
