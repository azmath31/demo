package com.trg.crud.student.data;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
	private int studentId;
	private String name;
	private LocalDate dateofBirth;
	private double marks;

	public Student(int studentId, String name, LocalDate dateofBirth, double marks) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.dateofBirth = dateofBirth;
		this.marks = marks;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateofBirth() {
		return dateofBirth;
	}

	public void setDateofBirth(LocalDate dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public int hashCode() {
		return studentId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentId != other.studentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentId=" + studentId + " Name=" + name + " DateofBirth=" + dateofBirth + " Marks=" + marks;
	}

	@Override
	public int compareTo(Student e) {
		return this.studentId - e.studentId;
	}

}
