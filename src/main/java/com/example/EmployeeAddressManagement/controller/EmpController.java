package com.example.EmployeeAddressManagement.controller;

import com.example.EmployeeAddressManagement.model.Employee;
import com.example.EmployeeAddressManagement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    //get all employee
    @GetMapping("employees")
    public Iterable<Employee> getAllEmployee(){
       return empService.getAllEmployee();
    }

    //get an employee by id
    @GetMapping("employee/id/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return empService.getEmployeeById(id);
    }

    //add employee
    @PostMapping("employee")
    public String addEmployee(@RequestBody Employee employee){
       return empService.addEmployee(employee);

    }

    //delete employee by id
    @DeleteMapping("employee/id/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return empService.deleteEmployeeById(id);
    }

    //update employee by id
    @PutMapping("employee/id/{id}/firstname/{firstname}")
    public String updateEmployeeById(@PathVariable Long id,@PathVariable String firstname){
        return empService.updateEmployeeById(id,firstname);
    }
}
