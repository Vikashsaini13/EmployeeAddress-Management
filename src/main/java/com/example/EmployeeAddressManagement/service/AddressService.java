package com.example.EmployeeAddressManagement.service;

import com.example.EmployeeAddressManagement.model.Address;
import com.example.EmployeeAddressManagement.repository.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    IAddressRepo iAddressRepo;

    public void addAddress(Address address) {
        iAddressRepo.save(address);
    }

    public Iterable<Address> getAllAddresses() {
        return iAddressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        Optional<Address> address=iAddressRepo.findById(id);

        return address.get();
    }

    public String deleteAddressById(Long id) {
        iAddressRepo.deleteById(id);
        return "deleted";
    }


    @Transactional
    public String updateAddressById(Long id,String state) {
        iAddressRepo.updateAddressById(id,state);
        return "updated";
    }
}
