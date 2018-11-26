package br.com.accountmanager.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.accountmanager.model.Restaurant;
import br.com.accountmanager.service.RestaurantService;


/**
 * @author Lucas
 *
 */
@RestController
@RequestMapping(value="/restaurants")
@CrossOrigin
public class RestaurantController {
		
	private final static Logger LOGGER = Logger.getLogger(RestaurantController.class);

	@Autowired
	@Qualifier(value="RestaurantServiceImpl")
	private RestaurantService restaurantService;

	@GetMapping
	public ResponseEntity<List<Restaurant>> findRestaurants(){
		try {
			return ResponseEntity.ok().body(restaurantService.findAllRestaurants());
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<Restaurant> findRestaurantById(@PathVariable("id") String id) {
		try {
			Restaurant restaurant = new Restaurant();
			restaurant.setId(id);
			return ResponseEntity.ok().body(restaurantService.findRestaurantById(restaurant));
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
}
