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


/**
 * @author Lucas
 *
 */
@Controller
@CrossOrigin
public class MenuController {
		
	private final static Logger LOGGER = Logger.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	/**
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/menu/{id}", method= RequestMethod.GET)
	public String findMenuById(@PathVariable("id") String id) {
		String response = "" ;
		try {
			response = menuService.findMenuById(id);
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
	
	
	/**
	 * Search for Menu passing restaurant ID
	 * @param id
	 * @return
	 */
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
}
