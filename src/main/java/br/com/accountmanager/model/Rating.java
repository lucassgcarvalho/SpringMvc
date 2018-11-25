package br.com.accountmanager.model;

import java.io.Serializable;

/**
 * @author Lucas
 *
 */
public class Rating implements Serializable{
	
	private static final long serialVersionUID = -4407480729754802359L;

	private String rating;

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}
	
}
