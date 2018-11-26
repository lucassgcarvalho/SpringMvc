package br.com.accountmanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import br.com.accountmanager.model.Restaurant;
import br.com.accountmanager.strategy.DAO;

public interface RestaurantService extends DAO {
	
	public List<Restaurant> findAllRestaurants() throws FileNotFoundException, IOException, ParseException;
	public Restaurant findRestaurantById(Restaurant restaurant) throws FileNotFoundException, IOException, ParseException;
}
