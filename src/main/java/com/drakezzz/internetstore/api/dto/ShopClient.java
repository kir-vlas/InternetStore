package com.drakezzz.internetstore.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ShopClient {

    @NotBlank
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String firstName;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordConfirm;

    @NotBlank
    private String lastName;

    @NotBlank
    private String phone;



}
