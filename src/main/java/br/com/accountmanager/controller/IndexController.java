package br.com.accountmanager.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.accountmanager.model.User;
import br.com.accountmanager.service.RestaurantService;


@Controller
@CrossOrigin
public class IndexController {
		

	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping("/testee")
	public String index(){
		return "/teste";
	}

	@RequestMapping(value = "/restaurants", method = RequestMethod.GET)
	@ResponseBody
	public String getRestaurants(){
		return restaurantService.findAllRestaurants();
	}

	@ResponseBody
	@RequestMapping(value = "/restaurants/{id}", method= RequestMethod.GET)
	public String findRestaurantById(@PathVariable("id") String id) {
		return restaurantService.findRestaurantById(id);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/restaurants/{id}/menu", method= RequestMethod.GET)
	public String findMenuByRestaurantId(@PathVariable("id") String id) {
		return restaurantService.findMenuByRestaurantId(id);
	}
	
	///hello/{name:.+}
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("teste");
		model.addObject("msg", name);

		return model;
	}
	
	// ///hello/{name:.+}
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
