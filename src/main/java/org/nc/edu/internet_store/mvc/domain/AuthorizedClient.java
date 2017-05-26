package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class AuthorizedClient extends Client{

    public static final String ROLE_CLIENT = "CLIENT";

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "USERROLE")
    private String role;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "FIRSTNAME")

    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "ADRESS")
    private String Adress;

    @Column(name = "LOGIN")
    private String login;
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "EMAIL")
    private String eMail;

    @Column(name = "PASSWORD")
    private String password;
    public String getPassword(){return password;}
    public void setPassword(String pass){password = pass;}

    @Column(name = "PHONE")
    private String phone;

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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAdress() {
        return Adress;
    }

    public String geteMail() {
        return eMail;
    }

    public String getPhone() {
        return phone;
    }

}
