package com.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.StudentAddress;

public interface StudentAddressRepository extends JpaRepository<StudentAddress, Integer> {

}
