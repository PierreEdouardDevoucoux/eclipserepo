package com.springdemo.daos;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.cj.jdbc.Blob;
import com.springdemo.entities.Student;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Repository
public class StudentDao implements Dao{
	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Transactional
	public void insertStudent(Student p_student)
	{
		Session session = factory.getCurrentSession();
		
		session.save(p_student);
		//session.persist(p_student);
	}
	
	@Transactional
	public void deleteStudent(Student p_Student)
	{
		Session session = factory.getCurrentSession();
		
		Student s = (Student)session.get(Student.class, p_Student.getId());
		session.delete(s);
	}
	
	@Transactional
	public void updateStudent(Student p_student)
	{
		Session session = factory.getCurrentSession();
		Student s = (Student)session.get(Student.class, p_student.getId());
		s.setFirst_name(p_student.getFirst_name());
		s.setLast_name(p_student.getLast_name());
		s.setEmail(p_student.getEmail());
		session.persist(s);
	}
	
	@Transactional
	public Student getStudent(int id)
	{
		Session session = factory.getCurrentSession();
		
		Student s = (Student)session.get(Student.class, id);
		return s;	
	}
	
	@Transactional
	public List<Student> getStudents()
	{
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from Student");
		  List<Student> studentList = query.list();
		  for (Student c : studentList) {
			System.out.println(c.toString());
		}
		return studentList;	
	}

	@Transactional
	public List<Student> getStudents(String searchattribut, String searchvalue) {
		Session session = factory.getCurrentSession();
		List<Student> listStudent  = this.getStudents();
		List<Student> listStudentReturn =  new ArrayList<Student>();
		System.out.println(searchattribut+" "+searchvalue);
		for (Student s1 : listStudent) {
			switch(searchattribut)
			{
			case "id":
				if(Integer.toString(s1.getId()).equals(searchvalue))
				{
					listStudentReturn.add(s1);
				}
				break;
			case "first_name":
				if(s1.getFirst_name().equals(searchvalue))
				{
					listStudentReturn.add(s1);
				}
				break;
			case "last_name":
				if(s1.getLast_name().equals(searchvalue))
				{
					listStudentReturn.add(s1);
				}
				break;
			case "email":
				if(s1.getEmail().equals(searchvalue))
				{
					listStudentReturn.add(s1);
				}
				break;
				
			}
		}
				
		return listStudentReturn;
	}
	
}
