package org.nc.edu.internet_store.mvc.domain;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "accounts")
public class Account {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_CLIENT = "CLIENT";

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "USERROLE")
    private String role;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId(){
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "FIRSTNAME")
    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String name){firstName = name;}


    @Column(name = "LOGIN")
    private String login;
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "PASSWORD")
    private String password;
    public String getPassword(){return password;}
    public void setPassword(String pass){password = pass;}



    @Column(name = "LASTNAME")
    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String name){lastName = name;}

    @Column(name = "PHONE")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name = "TIN")
    private String tin;

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    @Column(name = "HIRINGDATE")
    private Date hiringDate;
    public Date getHiringDate(){
        return hiringDate;
    }
    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

}