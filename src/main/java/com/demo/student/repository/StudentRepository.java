package com.demo.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByStudentName(String studentName);

	Optional<Student> findByLoginIdAndPassword(String loginId, String password);

}
