package com.springdemo.entities;

import javax.persistence.*;

@Entity
@Table (name="instructor_detail")
public class InstructorDetail {
	@Column(name="id") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@Column(name="hobby")
	private String hobby;
	@Column(name="youtube_channel")
	private String youtube_channel;
	
	@OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST })
	private Instructor instructor;
	
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getYoutube_channel() {
		return youtube_channel;
	}
	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}
	public InstructorDetail()
	{
		
	}
	public InstructorDetail(int id)
	{
		this.id = id;
	}
	public InstructorDetail(String hobby, String youtube_channel)
	{
		this.hobby = hobby;
		this.youtube_channel = youtube_channel;
	}
}
