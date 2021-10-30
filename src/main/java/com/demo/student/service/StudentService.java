package com.demo.student.service;

import java.util.List;

import com.demo.student.entity.Student;

public interface StudentService {

	String create(Student student) throws Exception;

	List<Student> getAllStudent() throws Exception;

	Student getStudent(Integer studentId) throws Exception;

	List<Student> getStudentbyName(String studentName) throws Exception;

	Student getLoginDetails(String loginId, String password) throws Exception;

}
