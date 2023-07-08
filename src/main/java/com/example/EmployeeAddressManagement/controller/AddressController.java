package com.example.EmployeeAddressManagement.controller;


import com.example.EmployeeAddressManagement.model.Address;
import com.example.EmployeeAddressManagement.service.AddressService;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageTranscoder;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;


    //add address
    @PostMapping("address")
    public String addAddress(@RequestBody Address address){
        addressService.addAddress(address);
        return "added";
    }

    //get all address
    @GetMapping("addresses")
    public Iterable<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    //get address by id
    @GetMapping("address/id/{id}")
    public Address getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    //Delete address by id

    @DeleteMapping("address/id/{id}")
    public String deleteAddressById(@PathVariable Long id){
        return addressService.deleteAddressById(id);
    }

//    update address by id
    @PutMapping("address/id/{id}/state/{state}")
    public String updateAddressById(@PathVariable Long id,@PathVariable String state){
        return addressService.updateAddressById(id,state);
    }

}
