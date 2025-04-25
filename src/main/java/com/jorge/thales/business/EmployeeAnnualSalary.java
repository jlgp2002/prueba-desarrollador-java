package com.jorge.thales.business;

import com.jorge.thales.model.Employee;

public class EmployeeAnnualSalary {
    public int calculateAnnualSalary(Employee employee) {
        return employee.getEmployee_salary() * 12;
    }
}
