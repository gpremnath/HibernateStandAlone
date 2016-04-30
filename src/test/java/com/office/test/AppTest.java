package com.office.test;

import org.hibernate.Session;
import org.junit.Test;
import com.office.hibernate.model.Address;
import com.office.hibernate.model.Student;
import com.office.hibernate.util.HibernateUtil;
import java.util.List;

public class  AppTest {

@Test
public void InsertTest() {
		Student student= new Student("Sam","Disilva","Maths");
		Address address= new Address("10 Silver street","NYC","USA");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(address);
		student.setAddress(address);
		session.persist(student);
		session.getTransaction().commit();

		List <Student> students = (List <Student> )session.createQuery(" from Student").list();
		for ( Student s: students){
			System.out.println("Details "+s.getAddress());
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
