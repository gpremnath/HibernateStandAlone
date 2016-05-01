package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name="student_address")
public class Address {

	@Id
	@GeneratedValue
	@Column(name="address_id")
	Integer addressId;
	
	@Column(name="street")
	String street;
	
	@Column(name="city")
	String city;

	@Column(name="country")
	String country;

	public Address(){}	

	public Address(String street,String city,String country){
		this.street=street;
		this.city=city;
		this.country=country;
	}	


	public void setAddressId(Integer addressId){
		this.addressId=addressId;
	}	


	public Integer getAddressId(){
		return addressId;
	}

	
	public void setStreet(String street){
		this.street=street;
	}	


	public String getStreet(){
		return street;
	}	

	
	public void setCity(String city){
		this.city=city;
	}	


	public String getCity(){
		return city;
	}	

	
	public void setCountry(String country){
		this.country=country;
	}	


	public String getCountry(){
		return country;
	}	

	
	@Override
    	public String toString() {
    	
		return "Address [id=" + addressId.toString()+ ", street=" + street + ", city=" + city
                	+ ", country=" + country + "]";
    
	}	

}

