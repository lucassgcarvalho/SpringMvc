package br.com.accountmanager.model;

/**
 * @author Lucas
 *
 */
public class Menu extends CommonModel{
	
	private static final long serialVersionUID = 5906279557583799640L;
	
	private String price;
	private Restaurant restaurant;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
}
