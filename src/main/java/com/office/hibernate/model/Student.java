
package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import org.hibernate.annotations.Type;

import com.office.hibernate.model.Address;
import com.office.hibernate.model.FBProfile;
import com.office.hibernate.model.EmailProfile;
import com.office.hibernate.model.ClassRoom;
import com.office.hibernate.model.University;
import com.office.hibernate.model.TextBook;
import com.office.hibernate.type.GenderType;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="student")
public class Student  {

	@Id
	@GeneratedValue
	@Column(name="student_id")
	long studentId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;

	@Column(name="section")
	String section;
	
	@Column(name="gender")
	@Type(type = "com.office.hibernate.type.PGEnumUserType" ,
    parameters ={@org.hibernate.annotations.Parameter(name = "enumClassName",value = "com.office.hibernate.type.GenderType")} )
	GenderType gender= GenderType.MALE;

	/*Uni-directional*/
	@OneToOne(cascade ={CascadeType.REMOVE})
	@JoinColumn(name="address_id")
	Address address;
	
	/*Uni-directional PK join column*/
	@OneToOne(cascade ={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	FBProfile fbProfile;

	/*Bi-directional PK join column*/
    @OneToOne(mappedBy="student", cascade = CascadeType.ALL)
    EmailProfile emailProfile;
	
	/*Uni-directional*/
	@ManyToOne(optional=false)
	@JoinColumn(name="classroom_id")
	ClassRoom classRoom;


	/*Bi-directional*/
	@ManyToOne(optional=false)
	@JoinColumn(name="university_id")
	University university;

	/*Bi-directional*/
	@ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="student_textbook",
       joinColumns={ @JoinColumn(name="student_id")},
       inverseJoinColumns={@JoinColumn(name="textbook_id")})
	private List <TextBook> textBooks = new ArrayList<TextBook>();


	public Student(){}	

	public Student(String firstName,String lastName,String section){
		this.firstName=firstName;
		this.lastName=lastName;
		this.section=section;
	}	


	public long  getId() {

		return studentId;
	}
	
    	public void setAddress(Address address){
		this.address=address;
	}	


	public Address  getAddress(){
		return address;
	}


	public void setFbProfile(FBProfile fbProfile){
		this.fbProfile = fbProfile;
	}	


	public FBProfile  getFbProfile(){
		return fbProfile;
	}

	
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}	


	public void setEmailProfile(EmailProfile emailProfile){
		this.emailProfile = emailProfile;
	}	


	public EmailProfile  getEmailProfile(){
		return emailProfile;
	}
		
	public String getFirstName(){
		return firstName;
	}	

	
	public void setLastName(String lastName){
		this.lastName=lastName;
	}	


	public String getLastName(){
		return lastName;
	}	

	
	public void setSection(String section){
		this.section=section;
	}	


	public String getSection(){
		return section;
	}	
	
	public void setGender(GenderType gender){
		this.gender=gender;		
	}	


	public GenderType getGender(){
		return gender;
	}	

	public void setClassRoom(ClassRoom classRoom){
		this.classRoom=classRoom;
	}	


	public ClassRoom getClassRoom(){
		return classRoom;
	}	

	public void setUniversity(University university){
		this.university=university;
	}	


	public University getUniversity(){
		return university;
	}	

	public void setTextBooks(List<TextBook> textBooks){
		this.textBooks=textBooks;
	}	


	public List<TextBook> getTextBooks(){
		return textBooks;
	}	

	
	@Override
    	public String toString() {
		return "Student [id=" + studentId+ ", First Name=" + firstName + ", Last Name=" + lastName
                		+ ", section =" + section + ""
						+ ", gender = " + gender + ""
                		+ ", " + classRoom + ""
                		+ ", " +  emailProfile+ " "
                		+ ", " +  university+ " "
            + ", profile=" + fbProfile + "]";
    
	}	
	

}

