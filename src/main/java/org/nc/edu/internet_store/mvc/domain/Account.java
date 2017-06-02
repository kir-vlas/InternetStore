package org.nc.edu.internet_store.mvc.domain;

import com.sun.istack.internal.NotNull;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "accounts")
public class Account {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_CLIENT = "CLIENT";

    @NotNull
    @Column(name = "ACTIVE")
    private boolean active;

    @NotNull
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


    @Column(name = "EMAIL")
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "ADRESS")
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @NotNull
    @Column(name = "FIRSTNAME")
    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String name){firstName = name;}

    @Column(name = "LOGIN")
    @NotNull
    private String login;
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "PASSWORD")
    @NotNull
    private String password;
    public String getPassword(){return password;}
    public void setPassword(String pass){password = pass;}

    @Transient
    private String passwordConfirm;
    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @NotNull
    @Column(name = "LASTNAME")
    private String lastName;
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String name){lastName = name;}


    @NotNull
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

    @Transient
    private boolean isValid;
    public boolean isValid() {
        return isValid;
    }
    public void setValid(boolean valid) {
        isValid = valid;
    }
}
