package br.com.accountmanager.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Lucas
 *
 */
public class Review implements Serializable{

	private static final long serialVersionUID = -9069235644076343112L;

	@NotNull(message="User can't be null.")
	private User user;
	
	@NotNull(message="Date can't be null.")
    private Date date;
    
	@NotNull(message="Rating can't be null.")
    private Rating rating;
    
	@NotBlank(message="Comments can't be empty.")
	@Max(value=1024, message="Comments can't has more than 1024 characters.")
    private String comments;
    
	@NotNull(message="Restaurant can't be null.")
    private Restaurant restaurant;
	
    public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
    
    
}
