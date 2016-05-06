package com.office.test;

import org.hibernate.Session;
import org.hibernate.Query;
import org.junit.Test;
import com.office.hibernate.model.Address;
import com.office.hibernate.model.FBProfile;
import com.office.hibernate.model.EmailProfile;
import com.office.hibernate.model.Student;
import com.office.hibernate.model.ClassRoom;
import com.office.hibernate.model.University;
import com.office.hibernate.util.HibernateUtil;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class  AppTest {

	@Test
	public void InsertTest() {
        List <Student> universityStudents = new ArrayList<Student>();
        Student samStudent = new Student("Sam","Disilva","Maths");
		Student einstenStudent = new Student("Albert","Einsten","Physics");
        
		Address address= new Address("10 Silver street","NYC","USA");
		FBProfile fbprofile= new FBProfile("gpremnath","password","http://facebook.com");
		EmailProfile emailprofile= new EmailProfile("gnath","password","gmail.com");
		ClassRoom classRoom=new ClassRoom("A","South Block");
		University university=new University("Berkley");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(address);
//        session.persist(university);		
        
		Query classRoomQuery = session.createQuery(" from ClassRoom as C where C.division=:division");
		classRoomQuery.setParameter("division","A");					
        List <ClassRoom> classRoomList = (List <ClassRoom>)classRoomQuery.list();
		Optional<ClassRoom> classRoomDb = classRoomList.stream().findFirst();
		if(classRoomDb.isPresent()){
			samStudent.setClassRoom(classRoomDb.get());
            einstenStudent.setClassRoom(classRoomDb.get()); 
		}else{
			session.save(classRoom);
			samStudent.setClassRoom(classRoom);
            einstenStudent.setClassRoom(classRoom);

		}	
		
        Query universityQuery = session.createQuery(" from University as U where U.name=:name");
		universityQuery.setParameter("name","Berkley");					
        List <University> universityList = (List <University>)universityQuery.list();
		Optional<University> universityDb = universityList.stream().findFirst();
		if(universityDb.isPresent()){
			samStudent.setUniversity(universityDb.get());
            einstenStudent.setUniversity(universityDb.get()); 
		}else{
			session.save(university);
			samStudent.setUniversity(university);
            einstenStudent.setUniversity(university);
        }

        universityStudents.add(samStudent);
        universityStudents.add(einstenStudent);
        university.setStudents(universityStudents);
		samStudent.setAddress(address);
        einstenStudent.setAddress(address);
		samStudent.setEmailProfile(emailprofile);
        einstenStudent.setEmailProfile(emailprofile); 
        emailprofile.setStudent(samStudent);
        emailprofile.setStudent(einstenStudent); 
		session.save(samStudent);
        session.save(einstenStudent); 
		session.save(university);
	        
		fbprofile.setId(samStudent.getId());
		fbprofile.setId(einstenStudent.getId());
       	samStudent.setFbProfile(fbprofile);
       	einstenStudent.setFbProfile(fbprofile);
		session.persist(samStudent);
		session.persist(einstenStudent);
		session.getTransaction().commit();

		List <Student> students = (List <Student> )session.createQuery(" from Student").list();
		for ( Student s: students){
			System.out.println(" "+s);
//			System.out.println("Address "+s.getAddress());
		}
       
        	session.beginTransaction();
        /* 
		for ( Student s: students){
            if(session.contains(s))
			    session.delete(s);
		}*/
        session.delete(university);    
       	session.getTransaction().commit();
		session.close();

	}


}
