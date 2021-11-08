package com.demo.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByStudentName(String studentName);

	Optional<Student> findByLoginIdAndPassword(String loginId, String password);

	@Query("select s from Student s where s.studentName=:studentName")
	List<Student> fetchStudentName(String studentName);

	//@Query(value = "select * from student_table where student_name=:studentName", nativeQuery = true)
	//List<Student> fetchStudentName(String studentName);

}
