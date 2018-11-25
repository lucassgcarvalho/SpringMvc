package br.com.accountmanager.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.accountmanager.service.MenuService;
import br.com.accountmanager.service.RestaurantService;


/**
 * @author Lucas
 *
 */
@Controller
@CrossOrigin
public class IndexController {
		
	private final static Logger LOGGER = Logger.getLogger(IndexController.class);

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private MenuService menuService;

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
			response = restaurantService.findRestaurantById(id);
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
	@RequestMapping(value = "/restaurants/{id}/menu", method= RequestMethod.GET)
	public String findMenuByRestaurantId(@PathVariable("id") String id) {
		String response = "" ;
		try {
			response = menuService.findMenuByRestaurantId(id);
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
	
//	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
//	public ModelAndView hello(@PathVariable("name") String name) {
//
//		ModelAndView model = new ModelAndView();
//		model.setViewName("teste");
//		model.addObject("msg", name);
//
//		return model;
//	}
	
	// @RequestMapping(value = "/ajaxTeste", method = RequestMethod.GET)
	// @ResponseBody
	// public ModelAndView ajaxTeste(Model model) {

	// 	User user = new User("Lucas Carvalho", 24);
		
	// 	JSONObject obj = new JSONObject();
	//     obj.put("user", user);
	//     HashMap<String, String> map = new HashMap<String, String>();
	//     map.put("user", obj.toString());
	// 	model.addAllAttributes(map);
		
	//     ModelAndView modelAndView = new ModelAndView();
	//     modelAndView.setViewName("teste");
	//     modelAndView.addObject("user", user);

	// 	return modelAndView.addAllObjects(map);
	// }
	
}
