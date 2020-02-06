package com.springdemo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table (name="student")
public class Student {
	@Column(name="id") 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@Column(name="first_name")
	private String first_name;
	public Student(String first_name, String last_name, String email, List<Course> cours) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.cours = cours;
	}
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	
	@Column(name="photo")
	private byte[] photo;
	
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinTable( name = "course_student", joinColumns = { @JoinColumn(name = "student_id") }, inverseJoinColumns = { @JoinColumn(name = "course_id") })
	private List<Course> cours;
	public void addCours(Course cour) {
		if(this.cours == null)
		{
			this.cours = new ArrayList<>();
		}
        cours.add(cour);
    }
	
	public String toString()
	{
		String newLine = System.getProperty("line.separator");
		String val="";
		val += newLine+"Student>>>>>"+this.getId()+"|"+this.first_name+" "+this.last_name;
		for (Course course : this.cours) {
			val += 	newLine+"Cours>>>>"+course.getId()+":"+course.getTitle();
			for (Review review : course.getReviews()) {
				val += 	newLine+"Review>>>>"+review.getId()+":"+review.getComment();
			}
			Instructor ins = course.getInstructor();
			val += newLine+"Instructeur>>>>"+ins.getId()+"|"+ins.getFirst_name()+" "+ins.getLast_name();
			InstructorDetail insD = ins.getInstructorDetail();
			val += newLine+"InsDetail>>>>"+insD.getId()+":"+insD.getHobby()+" "+insD.getYoutube_channel();		
		}
		return val;
	}
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCours() {
		return cours;
	}

	public void setCours(List<Course> cours) {
		this.cours = cours;
	}

	public Student()
	{
		
	}

	public Student(int id)
	{
		this.id = id;
	}
	
	public Student(int studentid, String first_name, String last_name, String email) {
		this.id = studentid;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
