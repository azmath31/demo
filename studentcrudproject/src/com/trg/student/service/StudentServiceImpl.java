package com.trg.student.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import com.trg.crud.dao.StudentDao;
import com.trg.crud.dao.StudentDaoMapImpl;
import com.trg.crud.exception.StudentException;
import com.trg.crud.student.data.Student;

public class StudentServiceImpl implements StudentService {

	StudentDao dao = new StudentDaoMapImpl();

	@Override
	public Student getStudent(int id) {
		return dao.getStudent(id);

	}

	@Override
	public void raiseMarks(int id, double percent) throws StudentException {
		Student s = dao.getStudent(id);
		if (s == null)
			throw new StudentException("Student with id " + id + "does not exist");

		double marks = s.getMarks();
		double newMarks = marks + marks * percent / 100;
		s.setMarks(newMarks);
		dao.update(s);
	}

	@Override
	public void deleteStudent(int id) throws StudentException {
		dao.delete(id);
	}

	@Override
	public void saveStudent(Student s) throws StudentException {
		dao.save(s);

	}

	@Override
	public List<Student> getAllStudents() {
		return dao.getAllStudents();

	}

	@Override
	public List<Student> getQalifiedStudents() {
		List<Student> list = dao.getAllStudents();
		List<Student> qualifiedList = new ArrayList<Student>();
		for (Student s : list) {
			if (s.getMarks() > 40)
				qualifiedList.add(s);
		}
		return qualifiedList;
	}

	@Override
	public List<Student> getStudentOnAge(int age) {
		List<Student> list = dao.getAllStudents();
		List<Student> ageList = new ArrayList<Student>();

		for (Student s : list) {

			Period p = Period.between(s.getDateofBirth(), LocalDate.now());

			int studentAge = p.getYears();
			if (studentAge < age)

				ageList.add(s);
		}

		return ageList;
	}

	public Student getTopper() {
		List<Student> list = dao.getAllStudents();
		Student topper=list.get(0);
		
		
		for(Student s:list)
		{
			if(s.getMarks()>topper.getMarks())
				topper=s;
		}
		return topper;
		
	}
}
