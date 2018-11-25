package br.com.accountmanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

/**
 * @author Lucas
 *
 */
@Component
public interface MenuService {
	
	public String findAllMenu() throws FileNotFoundException, IOException, ParseException;
	public String findMenuById(String id) throws FileNotFoundException, IOException, ParseException;
	public String findMenuByRestaurantId(String id) throws FileNotFoundException, IOException, ParseException;
	
}
