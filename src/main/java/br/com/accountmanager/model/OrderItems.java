package br.com.accountmanager.model;

import java.io.Serializable;

/**
 * @author Lucas
 *
 */
public class OrderItems implements Serializable{

	private static final long serialVersionUID = -925209116373955698L;
	
	private Integer quantity;
	
    private Menu menu;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}
    

}
