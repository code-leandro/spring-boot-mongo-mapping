package com.leandrodev.springbootmongomapping.repository;

import com.leandrodev.springbootmongomapping.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
