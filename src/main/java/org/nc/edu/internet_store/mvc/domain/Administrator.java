package org.nc.edu.internet_store.mvc.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ADMINISTRATOR")
public class Administrator {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    public Integer getId(){
        return id;
    }

    @Column(name = "FIRSTNAME")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }


    @Column(name = "LASTNAME")
    private String lastName;

    public String getLastName() {
        return lastName;
    }


    @Column(name = "PHONE")
    private String phone;

    public String getPhone() {
        return phone;
    }


    @Column(name = "TIN")
    private String tin;

    public String getTin() {
        return tin;
    }


    @Column(name = "HIRINGDATE")
    private Date hiringDate;
    public Date getHiringDate(){
        return hiringDate;
    }


}
