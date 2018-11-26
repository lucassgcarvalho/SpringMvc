package br.com.accountmanager.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Lucas
 *
 */
public class OrderItems implements Serializable{

	private static final long serialVersionUID = -925209116373955698L;
	
	@NotNull(message="Quantity can't be null.")
	@Size(min=0, max=1000000, message="Quantity can't has more than 1.000.000.")
	private Integer quantity;
	
	@NotNull(message="Menu can't be null.")
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
