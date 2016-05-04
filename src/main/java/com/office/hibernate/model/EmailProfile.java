package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.office.hibernate.model.Student;

@Entity
@Table (name="student_email_details")
public class EmailProfile {

    @Id  
    @Column(name="mail_id")  
    @GeneratedValue(generator="gen")  
    @GenericGenerator(name="gen", strategy="foreign",   
    parameters=@Parameter(name="property", value="student"))  
    private long id;

    @Column(name="mail_username")
    private String userId;

    
    @Column(name="mail_password")
    private String password;
    
    
    @Column(name="mail_account")
    private String account;

    
    @OneToOne
    @PrimaryKeyJoinColumn
    private Student student;

    public EmailProfile(){
    }

    public EmailProfile(String userId, String password, String account){
    
        this.userId=userId;
        this.password=password;
        this.account=account;    
    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id=id;
    }
    
    public String getUserId(){
        return userId;
    }

    public void setUserId(String userId){
        this.userId=userId;
    }
    
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password=password;
    }

   
    public String getAccount(){
        return account;
    }

    public void setAccount(String account){
        this.account=account;
    }

    public Student getStudent(){
        return student;
    }

    public void setStudent(Student student){
        this.student=student;
    }
     @Override
     public String toString() {
         return "EmailProfile [id=" + id + ", username=" + userId + ", password=" + password
          + ", account=" + account + "]";
     }

}
