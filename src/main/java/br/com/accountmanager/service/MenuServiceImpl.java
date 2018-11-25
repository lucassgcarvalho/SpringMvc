package br.com.accountmanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.accountmanager.dao.JsonDAO;

/**
 * @author Lucas
 */
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
    private JsonDAO jsonDAO;

    public MenuServiceImpl() {
    	super();
    }

    
    /**
     * Method returns all restaurants 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public String findAllMenu() throws FileNotFoundException, IOException, ParseException {
    	return ((JSONArray) ((JSONObject) jsonDAO.read()).get("menu")).toJSONString();
    }


    /**
     * Method returns all restaurants by id 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	public String findMenuById(String id) throws FileNotFoundException, IOException, ParseException {
		JSONArray jSONArray = (JSONArray) ((JSONObject) jsonDAO.read()).get("menu");
		Optional<Object> findFirst = Arrays.stream( jSONArray.toArray()  )
        .filter(x -> id.equals( ((JSONObject)x).get("id").toString() ))
        .findFirst();
        return findFirst.isPresent()?findFirst.get().toString():null;
	}

	/**
     * Method returns all menus by restaurant id  
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	public String findMenuByRestaurantId(String id) throws FileNotFoundException, IOException, ParseException {
		JSONArray jSONArray = (JSONArray) ((JSONObject) jsonDAO.read()).get("menu"); 
		Object[] findFirst = Arrays.stream( (jSONArray).toArray()  )
		        .filter(x -> id.equals(((JSONObject)x).get("restaurantId").toString()))
		        .toArray();
		return Arrays.toString(findFirst);
	}
	
}
