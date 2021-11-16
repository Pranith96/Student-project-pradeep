package com.demo.student.service;

import java.util.List;

import com.demo.student.entity.Student;
import com.demo.student.exception.StudentNotFoundException;

public interface StudentService {

	String create(Student student) throws Exception;

	List<Student> getAllStudent() throws Exception;

	Student getStudent(Integer studentId) throws StudentNotFoundException;

	List<Student> getStudentbyName(String studentName) throws Exception;

	Student getLoginDetails(String loginId, String password) throws Exception;

	List<Student> getStudentDetailsByNameParam(String studentName) throws Exception;

	String deleteData(Integer studentId) throws Exception;

	String updateStudent(Student student) throws Exception;

	String updateStudentName(Integer studentId, String studentName);

}
