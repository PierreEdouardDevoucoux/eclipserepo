package com.springdemo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="course")
public class Course {
	@Column(name="id") 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST })
	@JoinColumn (name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(cascade = { CascadeType.ALL })
	@JoinColumn (name="course_id")
	private List<Review> reviews;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable( name = "course_student", joinColumns = { @JoinColumn(name = "course_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private List<Student> students;
	
	public List<Student> getStudents() {
		return students;
	}
	
	public void addStudent(Student student) {
		if(this.students == null)
		{
			this.students = new ArrayList<>();
		}
        students.add(student);
    }	

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addReview(Review rev) {
		if(this.reviews == null)
		{
			this.reviews = new ArrayList <>();
		}
        reviews.add(rev);
    }
 
	public void removeReview(Review rev) {
        reviews.remove(rev);
    }
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Course()
	{
		
	}

	public Course(int id)
	{
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
