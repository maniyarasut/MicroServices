package com.student.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.StudentAddress;
@Repository
@Transactional
public interface StudentAddressRepository extends JpaRepository<StudentAddress, Integer> {

}
