package com.demo.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.student.entity.Student;
import com.demo.student.service.StudentService;

@RestController
@RequestMapping(value = "/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student student) throws Exception {
		String response = studentService.create(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/all")
	public ResponseEntity<List<Student>> getAllStudent() throws Exception {
		List<Student> response = studentService.getAllStudent();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/{studentId}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable("studentId") Integer studentId) throws Exception {
		Student response = studentService.getStudent(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/name/{studentName}")
	public ResponseEntity<List<Student>> getStudentDetailsByName(@PathVariable("studentName") String studentName)
			throws Exception {
		List<Student> response = studentService.getStudentbyName(studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/login/{loginId}/{password}")
	public ResponseEntity<Student> getLogin(@PathVariable("loginId") String loginId,
			@PathVariable("password") String password) throws Exception {
		Student response = studentService.getLoginDetails(loginId, password);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Student>> getStudentDetailsByNameParam(@RequestParam("studentName") String studentName)
			throws Exception {
		List<Student> response = studentService.getStudentDetailsByNameParam(studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudentDetails(@PathVariable("studentId") Integer studentId) throws Exception {
		String response = studentService.deleteData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateStudentRecord(@RequestBody Student student) throws Exception {
		String response = studentService.updateStudent(student);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PutMapping("/update/name/{studentId}/{studentName}")
	public ResponseEntity<String> updateStudentName(@PathVariable("studentId") Integer studentId,
			@PathVariable("studentName") String studentName) throws Exception {
		String response = studentService.updateStudentName(studentId, studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}


}
