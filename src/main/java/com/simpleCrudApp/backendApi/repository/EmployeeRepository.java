package com.simpleCrudApp.backendApi.repository;

import com.simpleCrudApp.backendApi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //all crud database methods
}
