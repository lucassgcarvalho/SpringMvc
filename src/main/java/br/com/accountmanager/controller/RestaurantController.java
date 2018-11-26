package br.com.accountmanager.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.accountmanager.model.Restaurant;
import br.com.accountmanager.service.RestaurantService;


/**
 * @author Lucas
 *
 */
@Controller
@CrossOrigin
public class RestaurantController {
		
	private final static Logger LOGGER = Logger.getLogger(RestaurantController.class);

	@Autowired
	@Qualifier(value="RestaurantServiceImpl")
	private RestaurantService restaurantService;

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	@ResponseBody
	public String getRestaurants(){
		String response = "" ;
		try {
			response = restaurantService.findAllRestaurants();
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			response = e.getMessage();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			response = e.getMessage();
		}catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
			response = e.getMessage();
		}
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/restaurants/{id}", method= RequestMethod.GET)
	public String findRestaurantById(@PathVariable("id") String id) {
		String response = "" ;
		try {
			Restaurant restaurant = new Restaurant();
			restaurant.setId(id);
			response = restaurantService.findRestaurantById(restaurant);
		} catch (FileNotFoundException e) {
			LOGGER.error(e.getMessage(), e);
			response = e.getMessage();
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
			response = e.getMessage();
		}catch (ParseException e) {
			LOGGER.error(e.getMessage(), e);
			response = e.getMessage();
		}
		return response;
		
	}
	
}
