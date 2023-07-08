package com.example.EmployeeAddressManagement.repository;

import com.example.EmployeeAddressManagement.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IEmpRepo extends CrudRepository<Employee,Long> {

    @Modifying
    @Query(value = "update employee set first_name=:firstname  where e_id=:id",nativeQuery = true)
    void updateEmployeeById(Long id,String firstname);
}
