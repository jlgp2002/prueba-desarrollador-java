package com.jorge.thales.model;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeListResponse {
    private List<Employee> data;
}
