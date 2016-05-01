package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="student_fb")
public class FBProfile {

    @Id
    @Column(name="fb_id")
    private long id;

    @Column(name="fb_user_id")
    private String userId;

    
    @Column(name="fb_password")
    private String password;
    
    
    @Column(name="fb_profile_page")
    private String url;


/*    public FBProfile(){
    }*/

    public FBProfile(String userId, String password, String url){
    
        this.userId=userId;
        this.password=password;
        this.url=url;    
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

     @Override
     public String toString() {
         return "FBProfile [id=" + id + ", username=" + userId + ", password=" + password
          + ", url=" + url + "]";
     }

}
