package com.leandrodev.springbootmongomapping.controller;

import com.leandrodev.springbootmongomapping.model.Address;
import com.leandrodev.springbootmongomapping.model.School;
import com.leandrodev.springbootmongomapping.repository.AddressRepository;
import com.leandrodev.springbootmongomapping.repository.SchoolRepository;
import com.leandrodev.springbootmongomapping.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/one-to-one")
@Slf4j
public class OneToOneController {

    public static final String NEW_SCHOOL = "New School";
    public static final String OLD_NUMBER = "10";
    public static final String NEW_NUMBER = "20";

    private final AddressRepository addressRepository;
    private final SchoolRepository schoolRepository;
    private final StudentRepository studentRepository;

    @GetMapping("/save")
    public ResponseEntity<School> school() {
        var address = Address.builder().street("ABC Avenue").number(OLD_NUMBER).build();
        addressRepository.save(address);
        var school = schoolRepository.save(School.builder().name(NEW_SCHOOL).address(address).build());
        return ResponseEntity.ok(school);
    }

    @GetMapping("/search")
    public ResponseEntity<Address> search(){
        var school = schoolRepository.findByName(NEW_SCHOOL).get(0);
        log.info("school: {}", school);
        return ResponseEntity.ok(school.getAddress());
    }

    @GetMapping("/update-not-work")
    public ResponseEntity<Address> updateNotWork(){
        var school = schoolRepository.findByName(NEW_SCHOOL).get(0);
        school.getAddress().setNumber(NEW_NUMBER);
        schoolRepository.save(school);
        school = schoolRepository.findByName(NEW_SCHOOL).get(0);
        return ResponseEntity.ok(school.getAddress());
    }

    @GetMapping("/update-work")
    public ResponseEntity<Address> updateWork(){
        var school = schoolRepository.findByName(NEW_SCHOOL).get(0);
        school.getAddress().setNumber(NEW_NUMBER);
        addressRepository.save(school.getAddress());
        school = schoolRepository.findByName(NEW_SCHOOL).get(0);
        return ResponseEntity.ok(school.getAddress());
    }
}
