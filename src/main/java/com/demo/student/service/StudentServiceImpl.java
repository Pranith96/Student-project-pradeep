package com.demo.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.demo.student.entity.Student;
import com.demo.student.exception.StudentNoContentException;
import com.demo.student.exception.StudentNotFoundException;
import com.demo.student.repository.StudentRepository;

@Service
@Profile(value= {"local","dev","qa","prod"})
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
	public List<Student> getAllStudent() throws StudentNoContentException {
		List<Student> response = studentRepository.findAll();
		if (null == response || response.isEmpty()) {
			throw new StudentNoContentException("data is empty");
		}
		return response;
	}

	@Override
	public Student getStudent(Integer studentId) throws StudentNotFoundException {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student data not found for current Id");
		}
		return response.get();
	}

	@Override
	public List<Student> getStudentbyName(String studentName) throws StudentNoContentException {

		List<Student> response = studentRepository.findByStudentName(studentName);

		if (null == response || response.isEmpty()) {
			throw new StudentNoContentException("data is empty for student record");
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

	@Override
	public List<Student> getStudentDetailsByNameParam(String studentName) throws StudentNoContentException {

		List<Student> response = studentRepository.fetchStudentName(studentName);

		if (null == response || response.isEmpty()) {
			throw new StudentNoContentException("data is empty for student record");
		}
		return response;
	}

	@Override
	public String deleteData(Integer studentId) throws StudentNotFoundException {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student data not found for current Id");
		}
		studentRepository.deleteById(studentId);
		return "Deleted succesfully";
	}

	@Override
	public String updateStudent(Student student) throws StudentNotFoundException {
		Optional<Student> response = studentRepository.findById(student.getStudentId());
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student record not exists for update");
		}

		if (student.getStudentName() != null) {
			response.get().setStudentName(student.getStudentName());
		}
		if (student.getAddress() != null) {
			response.get().setAddress(student.getAddress());
		}
		if (student.getLoginId() != null) {
			response.get().setLoginId(student.getLoginId());
		}
		if (student.getPassword() != null) {
			response.get().setPassword(student.getPassword());
		}
		if (student.getMobileNumber() != null) {
			response.get().setMobileNumber(student.getMobileNumber());
		}

		studentRepository.save(response.get());
		return "Data updated successfully";
	}

	@Override
	public String updateStudentName(Integer studentId, String studentName) {
		studentRepository.updateStudentName(studentId, studentName);
		return "updated Name succesfully";
	}
}
