package br.com.accountmanager.model;

import java.util.List;

import br.com.accountmanager.enums.Category;

/**
 * @author Lucas
 *
 */
public class Restaurant extends CommonModel {
	
	private static final long serialVersionUID = -5340317865536390461L;

	public static final Object RESTAURANT_ID = "restaurantId";
	public static final Object RESTAURANT = "restaurants";

	private Category category;
	private String  deliveryEstimate;
	private Rating  rating;
	private String  about;
	private String  hours;
	private List<Menu> menu;

	
	public String getDeliveryEstimate() {
		return deliveryEstimate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public void setDeliveryEstimate(String deliveryEstimate) {
		this.deliveryEstimate = deliveryEstimate;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public List<Menu> getMenu() {
		return menu;
	}
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}

}

