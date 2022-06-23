package com.rdacompany.sportsdesktop.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private int employeeId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Boolean active;

    @Override
    public String toString() {
        return employeeId + " " + name;
    }
}
