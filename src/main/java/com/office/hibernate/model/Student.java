
package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.CascadeType;

import com.office.hibernate.model.Address;


@Entity
@Table(name="student")
public class Student  {

	@Id
	@GeneratedValue
	@Column(name="student_id")
	Integer studentId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;

	@Column(name="section")
	String section;

	@OneToOne(cascade ={CascadeType.REMOVE})
	@JoinColumn(name="address_id")
	Address address;



	public Student(){}	

	public Student(String firstName,String lastName,String section){
		this.firstName=firstName;
		this.lastName=lastName;
		this.section=section;
	}	


	public void setAddress(Address address){
		this.address=address;
	}	


	public Address  getAddress(){
		return address;
	}

	
	public void setFirstName(String firstName){
		this.firstName=firstName;
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

	
	@Override
    	public String toString() {
		return "Student [id=" + studentId+ ", First Name=" + firstName + ", Last Name=" + lastName
                	+ ", section=" + section + "]";
    
	}	
	

}

