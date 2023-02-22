package com.vladimirpandurov.managerApp7B.repository;

import com.vladimirpandurov.managerApp7B.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {



}
