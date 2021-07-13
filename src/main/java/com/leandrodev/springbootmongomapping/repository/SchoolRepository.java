package com.leandrodev.springbootmongomapping.repository;

import com.leandrodev.springbootmongomapping.model.School;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SchoolRepository extends MongoRepository<School, String> {

    List<School> findByName(String name);
}
