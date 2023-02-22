package com.vladimirpandurov.managerApp7B.service;

import com.vladimirpandurov.managerApp7B.exception.EmployeeNotFoundException;
import com.vladimirpandurov.managerApp7B.model.Employee;
import com.vladimirpandurov.managerApp7B.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee getEmployee(Long employeeId){
        return this.employeeRepository.findById(employeeId).orElseThrow(()-> new EmployeeNotFoundException("Employee with id " + employeeId + " not found!"));
    }

    public List<Employee> getAllEmployees(){
        Iterable<Employee> iterable = this.employeeRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).toList();
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return this.employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId){
        this.employeeRepository.deleteById(employeeId);
    }



}
