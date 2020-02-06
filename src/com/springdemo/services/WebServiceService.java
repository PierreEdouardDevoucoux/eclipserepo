package com.springdemo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springdemo.daos.CoursDao;
import com.springdemo.daos.StudentDao;
import com.springdemo.entities.Course;
import com.springdemo.entities.Student;

@Service
public class WebServiceService implements AppliService{
	
	@Autowired
	CoursDao coursDao;
	@Autowired
	StudentDao studentDao;
	
	public List<Course> callgetCourss()
	{
		 return coursDao.getCourss();
	}
	
	public List<Student> callgetStudents()
	{
		 return studentDao.getStudents();
	}
	
	public Student callgetStudent(int id)
	{
		 return studentDao.getStudent(id);
	}

	public List<Student> callgetStudents(String searchattribut, String searchvalue)
	{
		 return studentDao.getStudents(searchattribut, searchvalue);
	}
	
	public void calldeleteStudent(Student p_student)
	{
		 studentDao.deleteStudent(p_student);
	}
	public void callinsertStudent(Student p_student)
	{
		 studentDao.insertStudent(p_student);
	}
	public void callupdateStudent(Student p_student)
	{
		 studentDao.updateStudent(p_student);
	}
	/*
	
	
	
	
	public Student callgetStudent(int id)
	{
		 return studentDao.getStudent(id);
	}
	
	public List<Student> callgetStudents()
	{
		 return studentDao.getStudents();
	}*/
}
