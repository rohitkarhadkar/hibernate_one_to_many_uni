package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class DeleteDemo {

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
			
			//get obj by PK 
			int pk = 1;
			Instructor tempInstructor = session.get(Instructor.class, pk);
			System.out.println("Instructor to be deleted "+tempInstructor);
			
			//delete the obj
			if(tempInstructor != null)
			{
				System.out.println("Deleting");
				session.delete(tempInstructor);
				//Instructor detail will also be deleted bcoz of cascade
			}
			
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
