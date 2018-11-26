package br.com.accountmanager.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

/**
 * @author Lucas
 *
 */
public class Rating implements Serializable{
	
	private static final long serialVersionUID = -4407480729754802359L;

	@NotBlank(message="Rating can't be empty.")
	private String value;

	public Rating() {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
