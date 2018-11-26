package br.com.accountmanager.enums;

import javax.validation.constraints.NotBlank;

public enum Category {

	SAUDAVEL("Saudável"), COFFE_SHOP("Coffee Shop"), HAMBURGERS("Hamburgers"), BAKERY("Bakery"), ICE_CREAMS("Ice Creams"), DOCES("Doces") ;
	 
	@NotBlank(message="Category's name can't be empty.")
	private String name;
	
	Category(String category) {
		this.name = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
