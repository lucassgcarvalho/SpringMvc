package br.com.accountmanager.controller;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import br.com.accountmanager.model.User;


@Controller
public class IndexController {
		
	@RequestMapping("/testee")
	public String index(){
		return "/teste";
	}

	///hello/{name:.+}
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public ModelAndView hello(@PathVariable("name") String name) {

		ModelAndView model = new ModelAndView();
		model.setViewName("teste");
		model.addObject("msg", name);

		return model;
	}
	
	///hello/{name:.+}
	@RequestMapping(value = "/ajaxTeste", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView ajaxTeste(Model model) {

		User user = new User("Lucas Carvalho", 24);
		
		JSONObject obj = new JSONObject();
	    obj.put("user", user);
	    HashMap<String, String> map = new HashMap<String, String>();
	    map.put("user", obj.toString());
		model.addAllAttributes(map);
		
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("teste");
	    modelAndView.addObject("user", user);

		return modelAndView.addAllObjects(map);
	}
	
}
