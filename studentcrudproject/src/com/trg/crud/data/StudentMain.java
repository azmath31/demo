package com.trg.crud.data;

import java.util.List;

import com.trg.crud.exception.StudentException;
import com.trg.crud.student.data.Student;
import com.trg.student.service.StudentService;
import com.trg.student.service.StudentServiceImpl;

public class StudentMain {

	public static void main(String[] args) {
		
		
		StudentService service = new StudentServiceImpl();
//		Student s= service.getStudent(100);
//		if(s==null)
//		{
//			System.out.println("Not found");
//		}
//		else
//		{
//			System.out.println(s);
//		}
//		
		List<Student> list= service.getStudentOnAge(20);
		display(list);
		
		System.out.println("List of Qualified Students");
		List<Student> qualified = service.getQalifiedStudents();
		
		display(qualified);
		
		try
		{
			service.deleteStudent(100);
			System.out.println("Deleted successfully");
			
		}catch(StudentException e)
		{
			System.out.println(e);
		}
		System.out.println("Topper: "+service.getTopper());
		

	}

	static void display(List<Student> list) {

		for (Student s : list) {
			System.out.println(s);
		}
	}
}
