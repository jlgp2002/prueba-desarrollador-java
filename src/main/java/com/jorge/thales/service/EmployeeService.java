package com.jorge.thales.service;

import com.jorge.thales.exception.TooManyRequestsException;
import com.jorge.thales.model.Employee;
import com.jorge.thales.model.EmployeeListResponse;
import com.jorge.thales.model.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {
    private final RestTemplate restTemplate;

    @Autowired
    public EmployeeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Employee> getAllEmployees() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        try {
            EmployeeListResponse response = restTemplate.getForObject(url, EmployeeListResponse.class);
            return response.getData();
        } catch (HttpClientErrorException.TooManyRequests ex) {
            throw new TooManyRequestsException("HTTP 429: Too many requests");
        } catch (HttpClientErrorException ex) {
            throw new RuntimeException("Client error: HTTP " + ex.getStatusCode());
        }
    }

    public Employee getEmployeeById(int id) {
        String url = "http://dummy.restapiexample.com/api/v1/employee/" + id;
        try {
            EmployeeResponse response = restTemplate.getForObject(url, EmployeeResponse.class);
            return response.getData();
        } catch (HttpClientErrorException.TooManyRequests ex) {
            throw new TooManyRequestsException("HTTP 429: Too many requests");
        } catch (HttpClientErrorException ex) {
            throw new RuntimeException("Client error: HTTP " + ex.getStatusCode());
        }
    }
}
