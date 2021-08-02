package com.trg.student.service;

import java.util.List;

import com.trg.crud.exception.StudentException;
import com.trg.crud.student.data.Student;

public interface StudentService {
	Student getStudent(int id);
	
	void deleteStudent(int id)throws StudentException;
	void saveStudent(Student s) throws StudentException;
	
	void raiseMarks(int id, double percent) throws StudentException;
	List<Student> getAllStudents();
	
	List<Student> getQalifiedStudents();
	
	List<Student> getStudentOnAge(int age);
	
	List<Student> getTopper();

}
