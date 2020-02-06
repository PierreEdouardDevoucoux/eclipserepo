package com.springdemo.entities;

import javax.persistence.*;

@Entity
@Table (name="review")
public class Review {
	@Column(name="id") 
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int  id;
	@Column(name="comment")
	private String comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	public Review()
	{
		
	}

	public Review(int id)
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
