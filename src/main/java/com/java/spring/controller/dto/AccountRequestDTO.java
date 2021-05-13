package com.java.spring.controller.dto;

import com.java.spring.entity.Account;

public class AccountRequestDTO {
    private String name, email;
    private Integer bill;

    public AccountRequestDTO(){}
    public AccountRequestDTO(String name, String email, Integer bill) {
        this.name = name;
        this.email = email;
        this.bill = bill;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }
}
