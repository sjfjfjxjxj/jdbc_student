package com.kh.jdbc.day01.student.controller;

import java.util.List;

import com.kh.jdbc.day01.student.model.dao.StudentDAO;
import com.kh.jdbc.day01.student.model.vo.Student;

public class StudentController {
	
	public List<Student> printAll() {
		StudentDAO sDao = new StudentDAO();
		List<Student> sList = sDao.selectAll();
		return sList;
	}

	public List<Student> printAllByName(String studentName) {
		StudentDAO sDao = new StudentDAO();
		List<Student> sList = sDao.selectAllByName(studentName);
		return sList;
	}

	public Student printOneById(String studentId) {
		StudentDAO sDao = new StudentDAO();
		Student student = sDao.selectOneById(studentId);
		return student; // 런 2번케이스로 감
	}

	public int registerStudent(Student student) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.insertStudent(student); // 성공실패(0/1~) 리턴
		return result;
	}
	
	public int removeStudent(String studentId) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.deleteStudent(studentId);
		return result;
	}
	
	
	public int modifyStudent(Student student) {
		StudentDAO sDao = new StudentDAO();
		int result = sDao.updateStudent(student);
		return result;
	}
	
	
	
}
