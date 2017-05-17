package org.nc.edu.internet_store.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;

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

    @Column(name = "PASSWORD")
    private String password;
    public String getPassword(){return password;}
    public void setPassword(String pass){password = pass;}


    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "ORDER_LIST")
    private int orderList;

    @Column(name = "ADRESS")
    private String Adress;


    @Column(name = "EMAIL")
    private String eMail;


    @Column(name = "PHONE")
    private String phone;


    @Column(name = "CREDIT")
    private Credit credit;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setOrderList(int orderList) {
        this.orderList = orderList;
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

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public int getOrderList() {
        return orderList;
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

    public String getCredit() {
        return credit.toString();
    }
}
