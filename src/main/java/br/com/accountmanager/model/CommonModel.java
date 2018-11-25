package br.com.accountmanager.model;

import java.io.Serializable;

/**
 * @author Lucas
 *
 */
public abstract class CommonModel implements Serializable{
	
	private static final long serialVersionUID = -7023762459019066844L;
	
	private String id;
	private String imagePath;
	private String name;
	private String description;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
