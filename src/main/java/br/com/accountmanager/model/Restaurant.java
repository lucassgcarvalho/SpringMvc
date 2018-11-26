package br.com.accountmanager.model;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import br.com.accountmanager.enums.Category;

/**
 * @author Lucas
 *
 */
public class Restaurant extends CommonModel {
	
	private static final long serialVersionUID = -5340317865536390461L;

	public static final Object RESTAURANT_ID = "restaurantId";
	public static final Object RESTAURANT = "restaurants";

	@NotBlank(message="Category can't be null.")
	private Category category;
	
	@NotBlank(message="Delivery estimate can't be empty.")
	private String deliveryEstimate;
	
	@NotBlank(message="Rating can't be null.")
	private Rating  rating;
	
	@NotBlank(message="About can't be empty.")
	@Max(value=1024, message="About can't has more than 1024 characters.")
	private String  about;
	
	@NotBlank(message="Hours can't be empty.")
	private String  hours;
	
	private List<Menu> menu;

	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDeliveryEstimate() {
		return deliveryEstimate;
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

//	public String getRating() {
//		return this.rating.getRating();
//	}
	public void setRating(String rating) {
		this.rating = new Rating();
	}

	
}

