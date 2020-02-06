package com.springdemo.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.springdemo.entities.Course;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Repository
public class CoursDao implements Dao{
	@Autowired
	private SessionFactory factory;
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Transactional
	public void insertCours(Course p_cours)
	{
		Session session = factory.getCurrentSession();
		
		session.persist(p_cours);
	}
	
	@Transactional
	public void deleteCours(Course p_cours)
	{
		Session session = factory.getCurrentSession();
		
		Course s = (Course)session.get(Course.class, p_cours.getId());
		session.delete(s);
	}
	
	@Transactional
	public void updateCours(Course p_cours)
	{
		Session session = factory.getCurrentSession();
		Course s = (Course)session.get(Course.class, p_cours.getId());
		s.setTitle(p_cours.getTitle());
		session.persist(s);
	}
	
	@Transactional
	public Course getCours(int id)
	{
		Session session = factory.getCurrentSession();
		
		Course s = (Course)session.get(Course.class, id);
		return s;	
	}
	
	@Transactional
	public List<Course> getCourss()
	{
		Session session = factory.getCurrentSession();
		Query query = session.createQuery("from Course");
		  List<Course> coursList = query.list();
		  for (Course c : coursList) {
			System.out.println(c.toString());
		}
		return coursList;	
	}
}
