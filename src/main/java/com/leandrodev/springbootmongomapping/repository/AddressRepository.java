package com.leandrodev.springbootmongomapping.repository;

import com.leandrodev.springbootmongomapping.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, String> {
    List<Address> findByStreet(String street);
}
