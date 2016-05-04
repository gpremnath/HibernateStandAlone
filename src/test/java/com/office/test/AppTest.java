package com.office.test;

import org.hibernate.Session;
import org.hibernate.Query;
import org.junit.Test;
import com.office.hibernate.model.Address;
import com.office.hibernate.model.FBProfile;
import com.office.hibernate.model.EmailProfile;
import com.office.hibernate.model.Student;
import com.office.hibernate.model.ClassRoom;
import com.office.hibernate.util.HibernateUtil;
import java.util.List;
import java.util.Optional;

public class  AppTest {

@Test
public void InsertTest() {
		Student student= new Student("Sam","Disilva","Maths");
		Address address= new Address("10 Silver street","NYC","USA");
		FBProfile profile= new FBProfile("gpremnath","password","http://facebook.com");
		EmailProfile emailprofile= new EmailProfile("gnath","password","gmail.com");
		ClassRoom classRoom=new ClassRoom("A","South Block");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Query classRoomQuery = session.createQuery(" from ClassRoom as C where C.division=:division");
		classRoomQuery.setParameter("division","A");					

		List <ClassRoom> classRoomList = (List <ClassRoom>)classRoomQuery.list();
		Optional<ClassRoom> classRoomDb = classRoomList.stream().findFirst();
		session.persist(address);
		
		if(classRoomDb.isPresent()){
			student.setClassRoom(classRoomDb.get());
		}	
		else{
			session.save(classRoom);
			student.setClassRoom(classRoom);
		    }	
		
		student.setAddress(address);
                emailprofile.setStudent(student);
		student.setEmailProfile(emailprofile);
                
		session.persist(student);
	        profile.setId(student.getId());
        	student.setFbProfile(profile);
		session.persist(student);
		session.getTransaction().commit();

		List <Student> students = (List <Student> )session.createQuery(" from Student").list();
		for ( Student s: students){
			System.out.println("Details "+s);
//			System.out.println("Address "+s.getAddress());
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
