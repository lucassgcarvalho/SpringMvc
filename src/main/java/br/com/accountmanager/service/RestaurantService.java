package br.com.accountmanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import br.com.accountmanager.model.Restaurant;
import br.com.accountmanager.strategy.DAO;

public interface RestaurantService extends DAO {
	
	public String findAllRestaurants() throws FileNotFoundException, IOException, ParseException;
	public String findRestaurantById(Restaurant restaurant) throws FileNotFoundException, IOException, ParseException;
}
