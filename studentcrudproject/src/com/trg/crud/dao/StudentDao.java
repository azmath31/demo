package com.trg.crud.dao;

import java.util.List;

import com.trg.crud.exception.StudentException;
import com.trg.crud.student.data.Student;

public interface StudentDao {

	void  save(Student s) throws StudentException; // Create

	void  update(Student s) throws StudentException; // Update

	void delete(int sid) throws StudentException; // Delete

	Student getStudent(int sid);  //Retireve

	List<Student> getAllStudents(); // Retieve

}
