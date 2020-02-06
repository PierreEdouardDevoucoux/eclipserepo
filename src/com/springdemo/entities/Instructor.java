package com.springdemo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name="instructor")
public class Instructor {
	@Column(name="id") 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="email")
	private String email;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")
	private InstructorDetail instructorDetail; 
	
	@OneToMany(mappedBy="instructor", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	private List<Course> cours;
	
	public void addCours(Course cour) {
		if(this.cours == null)
		{
			this.cours = new ArrayList<>();
		}
		cour.setInstructor(this);
        cours.add(cour);
    }
 
    public List<Course> getCours() {
		return cours;
	}

	public void setCours(List<Course> cours) {
		this.cours = cours;
	}

	public void removeCours(Course cour) {
		cour.setInstructor(null);
        cours.remove(cour);
    }
    
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	public Instructor()
	{
		
	}

	public Instructor(int id)
	{
		this.id = id;
	}
	public Instructor(String first_name, String last_name, String email)
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}
	
	public String toString()
	{
		String newLine = System.getProperty("line.separator");
		String val="";
		
		val += newLine+"Instructeur>>>>"+this.getId()+"|"+this.first_name+" "+this.last_name;
		InstructorDetail insD = this.getInstructorDetail();
		val += newLine+"InsDetail>>>>"+insD.getId()+":"+insD.getHobby()+" "+insD.getYoutube_channel();
				for (Course course : this.cours) {
					val += 	newLine+"Cours>>>>"+course.getId()+":"+course.getTitle();
					for (Review review : course.getReviews()) {
						val += 	newLine+"Review>>>>"+review.getId()+":"+review.getComment();
					}
					for (Student student : course.getStudents()) {
						val += 	newLine+"Student>>>>"+student.getId()+":"+student.getFirst_name()+""+student.getLast_name();
					}
				}
		
		return val;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
