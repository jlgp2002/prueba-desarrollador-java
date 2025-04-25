package com.jorge.thales;

import com.jorge.thales.business.EmployeeAnnualSalary;
import com.jorge.thales.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeAnnualSalaryTest {

    private EmployeeAnnualSalary employeeAnnualSalary;

    @BeforeEach
    public void setUp() {
        employeeAnnualSalary = new EmployeeAnnualSalary();
    }

    @Test
    public void testCalculateAnnualSalary() {
        Employee employee = new Employee(1, "Juan Gonzalez", 5000, 30, "");
        int annualSalary = employeeAnnualSalary.calculateAnnualSalary(employee);
        assertEquals(60000, annualSalary, "The annual salary should be the salary times 12");
    }

    @Test
    public void testCalculateAnnualSalaryZeroSalary() {
        Employee employee = new Employee(2, "Jose Garcia", 0, 30, "");
        int annualSalary = employeeAnnualSalary.calculateAnnualSalary(employee);
        assertEquals(0, annualSalary, "The annual salary should be 0 when the salary is 0");
    }
}
