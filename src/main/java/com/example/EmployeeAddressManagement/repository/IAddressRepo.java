package com.example.EmployeeAddressManagement.repository;

import com.example.EmployeeAddressManagement.model.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address, Long> {

    @Modifying
    @Query(value = "update address set state=:state  where add_id=:id",nativeQuery = true)
    void updateAddressById(Long id, String state);
}
