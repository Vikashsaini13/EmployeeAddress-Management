package com.example.EmployeeAddressManagement.service;

import com.example.EmployeeAddressManagement.model.Employee;
import com.example.EmployeeAddressManagement.repository.IEmpRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    IEmpRepo iEmpRepo;


    public Iterable<Employee> getAllEmployee() {
       return iEmpRepo.findAll();
    }
    public String addEmployee(Employee employee) {

        iEmpRepo.save(employee);
        return "Added";
    }


    public Employee getEmployeeById(Long id) {

        Optional<Employee> employee= iEmpRepo.findById(id);
        return employee.get();
    }

    public String deleteEmployeeById(Long id) {
        iEmpRepo.deleteById(id);
        return "deleted";
    }

    @Transactional
    public String updateEmployeeById(Long id,String firstname) {
        iEmpRepo.updateEmployeeById(id,firstname);
        return "updated";
    }
}
