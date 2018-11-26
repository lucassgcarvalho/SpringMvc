package br.com.accountmanager.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class User implements Serializable {

	private static final long serialVersionUID = 5824100396598360713L;

	@NotBlank(message="Name can't be empty.")
	@Max(value=255, message="Name can't has more than 255 characters.")
	private String name;
	
	private Integer age;
	
	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	
}
