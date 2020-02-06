package com.springdemo.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springdemo.daos.CoursDao;
import com.springdemo.daos.Dao;
import com.springdemo.daos.StudentDao;
import com.springdemo.entities.Course;
import com.springdemo.entities.Student;

@Service
public class StudentInstructorService implements AppliService{
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	CoursDao coursDao;
	
	
	public void callinsertStudent(Student p_student)
	{
		 studentDao.insertStudent(p_student);
	}

	public void calldeleteStudent(Student p_student)
	{
		 studentDao.deleteStudent(p_student);
	}
	
	public void callupdateStudent(Student p_student)
	{
		 studentDao.updateStudent(p_student);
	}
	
	public Student callgetStudent(int id)
	{
		 return studentDao.getStudent(id);
	}
	
	public List<Student> callgetStudents()
	{
		 return studentDao.getStudents();
	}
	
	public void callinsertCours(Course p_cours)
	{
		 coursDao.insertCours(p_cours);
	}

	public void calldeleteCours(Course p_cours)
	{
		 coursDao.deleteCours(p_cours);
	}
	
	public void callupdateCours(Course p_cours)
	{
		 coursDao.updateCours(p_cours);
	}
	
	public Course callgetCours(int id)
	{
		 return coursDao.getCours(id);
	}
	
	public List<Course> callgetCourss()
	{
		 return coursDao.getCourss();
	}

	public List<Student> callgetStudents(String searchattribut, String searchvalue) {
		return studentDao.getStudents(searchattribut, searchvalue);
	}
}
