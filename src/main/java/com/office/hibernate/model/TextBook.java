package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

import java.util.List;
import java.util.ArrayList;

import com.office.hibernate.model.Student;

@Entity
@Table (name="textbook")
public class TextBook {

    @Id
    @GeneratedValue
    @Column (name ="textbook_id")
    private long id;

    @Column(name="author",unique=true)
    private String  author;

    @Column (name ="name")
    private String name;

    @ManyToMany (mappedBy ="textBooks")
    private List <Student> students= new ArrayList <Student> ();


    public TextBook(){}	

    public TextBook(String author,String name){
    
	this.author=author;
	this.name=name;
    
    }	

    public long getId(){
        return id;
    }

    public void setId(long id){
            this.id=id;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }
   
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List <Student> students){
        this.students=students;
    }
    public String toString(){
       return "ClassRoom [ author = "+ author +" , name = "+name+" ]";  	
   }	
}


