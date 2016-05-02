package com.office.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
@Table (name="classroom")
public class ClassRoom {

    @Id
    @GeneratedValue
    @Column (name ="room_id")
    private long id;

    @Column(name="alphabet_id",unique=true)
    private String  division;

    @Column (name ="building_name")
    private String block;

    public long getId(){
        return id;
    }

    public void setId(long id){
            this.id=id
    }

    public String getDivision(){
        return division;
    }

    public void setDivision(String division){
        this.division=division;
    }
   
    public String getBlock(){
        return block;
    }

    public void setBlock(String block){
        this.block=block;
    }
}


