package br.com.accountmanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public interface RestaurantService {
	
	public String findAllRestaurants() throws FileNotFoundException, IOException, ParseException;
	public String findRestaurantById(String id) throws FileNotFoundException, IOException, ParseException;
}
