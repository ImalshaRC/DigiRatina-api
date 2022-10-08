package com.simpleCrudApp.backendApi.controller;

import com.simpleCrudApp.backendApi.exception.ResourceNotFoundException;
import com.simpleCrudApp.backendApi.model.Employee;
import com.simpleCrudApp.backendApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //build create employee REST API
    @PostMapping
    public ResponseEntity<Employee> creatEmployee(@RequestBody Employee employee){//convert JSON in to java object
        Employee emp = employeeRepository.save(employee);
        return ResponseEntity.ok(emp);
    }

    //get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not exist with id: " + id)
                );
        return ResponseEntity.ok(employee);
    }

    //update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not exists with given data")
                );

        updateEmployee.setFirstName(employee.getFirstName());
        updateEmployee.setLastName(employee.getLastName());
        updateEmployee.setEmailID(employee.getEmailID());

        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee emp = employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee not exists with given data" + id)
                );
        employeeRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
