package com.demo.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.student.entity.Student;
import com.demo.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public String create(Student student) throws Exception {

		Student response = studentRepository.save(student);
		if (response == null) {
			throw new Exception("Data not saved correctly");
		}
		return "Student Data saved successfully";
	}

	@Override
	public List<Student> getAllStudent() throws Exception {
		List<Student> response = studentRepository.findAll();
		if (null == response || response.isEmpty()) {
			throw new Exception("data is empty");
		}
		return response;
	}

	@Override
	public Student getStudent(Integer studentId) throws Exception {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new Exception("Student data not found for current Id");
		}
		return response.get();
	}

	@Override
	public List<Student> getStudentbyName(String studentName) throws Exception {

		List<Student> response = studentRepository.findByStudentName(studentName);

		if (null == response || response.isEmpty()) {
			throw new Exception("data is empty");
		}
		return response;
	}

	@Override
	public Student getLoginDetails(String loginId, String password) throws Exception {
		Optional<Student> response = studentRepository.findByLoginIdAndPassword(loginId, password);
		if (!response.isPresent()) {
			throw new Exception("login Id or password is incorrect");
		}
		return response.get();
	}

}
