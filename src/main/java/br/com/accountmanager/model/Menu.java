package br.com.accountmanager.model;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Lucas
 *
 */
public class Menu extends CommonModel{
	
	private static final long serialVersionUID = 5906279557583799640L;
	

	public static final Object MENU_ID = "menuId";
	public static final Object MENU = "menu";
	
	@NotBlank(message="Price can't be empty.")
	@Min(value=0, message="Price must be more than 0.")
	private BigDecimal price;
	
	@NotNull(message="Restaurant can't be null.")
	private Restaurant restaurant;
	

	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}
