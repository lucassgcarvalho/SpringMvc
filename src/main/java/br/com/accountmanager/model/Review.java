package br.com.accountmanager.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Lucas
 *
 */
public class Review implements Serializable{

	private static final long serialVersionUID = -9069235644076343112L;

	private User user;
    private Date date;
    private Rating rating;
    private String comments;
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
