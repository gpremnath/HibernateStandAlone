package com.office.test;

import org.hibernate.Session;
import org.junit.Test;
import com.office.hibernate.model.Address;
import com.office.hibernate.model.FBProfile;
import com.office.hibernate.model.Student;
import com.office.hibernate.util.HibernateUtil;
import java.util.List;

public class  AppTest {

@Test
public void InsertTest() {
		Student student= new Student("Sam","Disilva","Maths");
		Address address= new Address("10 Silver street","NYC","USA");
		FBProfile profile= new FBProfile("gpremnath","password","http://facebook.com");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(address);
		student.setAddress(address);
		session.persist(student);
        profile.setId(student.getId());
        student.setFbProfile(profile);
        session.persist(student);
		session.getTransaction().commit();

		List <Student> students = (List <Student> )session.createQuery(" from Student").list();
		for ( Student s: students){
			System.out.println("Details "+s);
			System.out.println("Address "+s.getAddress());
		}
       
        session.beginTransaction();
         
		for ( Student s: students){
            if(session.contains(s))
			    session.delete(s);
		}
        session.getTransaction().commit();
		session.close();

	}




}
