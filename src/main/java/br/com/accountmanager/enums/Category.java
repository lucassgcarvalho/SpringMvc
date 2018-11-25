package br.com.accountmanager.enums;

public enum Category {

	SAUDAVEL("Saudável"), COFFE_SHOP("Coffee Shop"), HAMBURGERS("Hamburgers"), BAKERY("Bakery"), ICE_CREAMS("Ice Creams"), DOCES("Doces") ;
	 
	private String category;
	
	Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
