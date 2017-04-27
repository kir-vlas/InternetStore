package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CLIENTS")
public class AuthorizedClient {

    private enum Credit{HIGH,MEDIUM,LOW}

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;


    @Column(name = "FIRSTNAME")
    private String firstName;


    @Column(name = "LASTNAME")
    private String lastName;


    @Column(name = "ADRESS")
    private String Adress;

    @Column(name = "EMAIL")
    private String eMail;


    @Column(name = "PHONE")
    private String phone;


    @Column(name = "CREDIT")
    private Credit credit;

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

    public String getCredit() {
        return credit.toString();
    }
}
