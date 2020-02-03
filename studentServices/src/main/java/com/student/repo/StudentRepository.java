package com.student.repo;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.Student;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
