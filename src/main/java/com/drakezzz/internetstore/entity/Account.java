package com.drakezzz.internetstore.entity;

import com.drakezzz.internetstore.api.dto.ShopClient;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;

    private String role;

    private String email;

    private String address;

    private String firstName;

    private String username;

    private String password;

    private String lastName;

    private String phone;

    private LocalDate hiringDate;

    private LocalDate registerDate;

    @Transient
    private boolean isValid;

    public static Account of(ShopClient client) {
        Account account = new Account();
        account.setAddress(client.getAddress());
        account.setEmail(client.getEmail());
        account.setFirstName(client.getFirstName());
        account.setLastName(client.getLastName());
        account.setUsername(client.getUsername());
        account.setPassword(client.getPassword());
        account.setPhone(client.getPhone());
        return account;
    }

}
