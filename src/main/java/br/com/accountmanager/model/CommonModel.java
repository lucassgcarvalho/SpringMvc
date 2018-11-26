package br.com.accountmanager.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

/**
 * @author Lucas
 *
 */
public abstract class CommonModel implements Serializable{
	
	private static final long serialVersionUID = -7023762459019066844L;
	
	public static final Object ID = "id";
	
	private String id;
	
	@NotBlank(message="Image path can't be empty.")
	private String imagePath;
	
	@NotBlank(message="Name can't be empty.")
	private String name;
	
	@NotBlank(message="Description can't be empty.")
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
