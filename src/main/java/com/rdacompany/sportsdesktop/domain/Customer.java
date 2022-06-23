package com.rdacompany.sportsdesktop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private int customerId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String birthDate;

    @Override
    public String toString() {
        return customerId + " " + name;
    }
}
