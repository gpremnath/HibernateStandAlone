package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
@Table (name="university")
public class University {

    @Id
    @Column(name="university_id")
    private long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy="university",cascade=CascadeType.ALL)
    private List <Student> students;
	 
    public University(){}	

    public University(String name){
    
        this.name=name;
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
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

    public void setStudents(List<Student> students){
        this.students=students;
    }

     @Override
     public String toString() {
         return "University [name=" + name + " ]";
     }
}
