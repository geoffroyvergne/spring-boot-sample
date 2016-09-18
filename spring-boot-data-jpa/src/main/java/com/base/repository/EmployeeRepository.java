package com.base.repository;

import com.base.model.Employee;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface EmployeeRepository extends Repository<Employee, Long> {
    List<Employee> findAll();
}
