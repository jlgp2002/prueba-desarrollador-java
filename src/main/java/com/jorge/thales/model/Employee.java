package com.jorge.thales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String employee_name;
    private int employee_salary;
    private int employee_age;
    private String profile_image;
}
