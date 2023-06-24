package com.ss.movie.app.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 

	@ManyToOne
	private User user;
	
	@ManyToOne
	private Movie movie;
	private Date creatorDate;
	private Date lastUpdatedDate;
	private float rating;
	private String description;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Date getCreatorDate() {
		return creatorDate;
	}
	public void setCreatorDate(Date creatorDate) {
		this.creatorDate = creatorDate;
	}
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Review(long id, User user, Movie movie, Date creatorDate, Date lastUpdatedDate, float rating,
			String description) {
		super();
		this.id = id;
		this.user = user;
		this.movie = movie;
		this.creatorDate = creatorDate;
		this.lastUpdatedDate = lastUpdatedDate;
		this.rating = rating;
		this.description = description;
	}

	public Review() {
		super();
	}



}
