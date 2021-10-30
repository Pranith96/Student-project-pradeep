package com.demo.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_table")
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "mobile_number", unique = true)
	private String mobileNumber;
	@Column(name = "student_address")
	private String address;
	@Column(name = "login_id", unique = true)
	private String loginId;
	@Column(name = "password")
	private String password;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student(Integer studentId, String address, String studentName, String mobileNumber, String loginId,
			String password) {
		this.studentId = studentId;
		this.address = address;
		this.studentName = studentName;
		this.mobileNumber = mobileNumber;
		this.loginId = loginId;
		this.password = password;
	}

	public Student() {
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", address=" + address + ", studentName=" + studentName
				+ ", mobileNumber=" + mobileNumber + ", loginId=" + loginId + ", password=" + password + "]";
	}

}
