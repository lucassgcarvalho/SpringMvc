package br.com.accountmanager.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.accountmanager.model.CommonModel;
import br.com.accountmanager.model.Menu;
import br.com.accountmanager.model.Restaurant;
import br.com.accountmanager.service.MenuService;
import br.com.accountmanager.service.RestaurantService;
import br.com.accountmanager.service.RestaurantServiceImpl;
import br.com.accountmanager.strategy.DAO;

/**
 * @author Lucas
 *
 */
@Component("JsonDAOImpl")
public class JsonDAOImpl implements DAO, MenuService, RestaurantService  {
	
	private final static Logger LOGGER = Logger.getLogger(RestaurantServiceImpl.class);

	private static final String DB_JSON_FILE_PATH = "WEB-INF\\resources\\db.json";

	private static final long FIVE_MINUTES = 300000;
	private static final long ONE_MINUTE = 60000;
	private static final long TEN_SECONDS = 10000;
	
	
	@Autowired
	private ResourceLoader resourceLoader;
	
	private JSONParser jsonParser;
	private JSONObject jSONObject;
	private Calendar timeInitial;
	private Type type;
	private Gson gson ;
	
	public JsonDAOImpl() {
		super();
		jsonParser = new JSONParser();
		type = new TypeToken<List<Restaurant>>() {}.getType();
		gson = new Gson();
	}
	
	private synchronized JSONObject read() throws IOException, ParseException  {
		if(jSONObject!=null && !isUpdateJson(timeInitial)) {
			return jSONObject;
		}
		FileReader fileReader = null; 
		try {
			String canonicalPath = resourceLoader.getResource(DB_JSON_FILE_PATH).getFile().getCanonicalPath();
			fileReader = new FileReader(canonicalPath);
			jSONObject =  (JSONObject) jsonParser.parse(fileReader);
			timeInitial = Calendar.getInstance();
			return jSONObject;
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			throw new IOException("Error to pick the file up.", e);
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			throw new ParseException(e.getPosition(), e.getErrorType(), e);
		} finally {
			if(fileReader!=null) {
				fileReader.close();
			}
		}
	}
	
	

	@Override
	public void create(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detele(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> findAll(Object object) {
		return null;
	}
	
	/**
	 * Check if is time to update the JsonObject
	 * @param timeInitial
	 * @return
	 */
	private boolean isUpdateJson(Calendar timeInitial) {
		if(timeInitial==null) {
			return true;
		}
		Calendar instance = Calendar.getInstance();
		long compareTo = instance.getTimeInMillis();
		long comparedTime = compareTo - timeInitial.getTimeInMillis();
		if(comparedTime > ONE_MINUTE) {
			return true;
		}
		return false;
	}

	@Override
	public List<Restaurant> findAllRestaurants() throws FileNotFoundException, IOException, ParseException {
		return gson.fromJson(((JSONArray) ((JSONObject) read()).get("restaurants")).toJSONString(), type);
//		return ((JSONArray) ((JSONObject) read()).get("restaurants")).toJSONString();
	}

	@Override
	public Restaurant findRestaurantById(Restaurant restaurant) throws FileNotFoundException, IOException, ParseException {
		JSONArray jSONArray = (JSONArray) ((JSONObject) read()).get(Restaurant.RESTAURANT);
		Optional<Object> findFirst = Arrays.stream( jSONArray.toArray()  )
        .filter(x -> restaurant.getId().equals( ((JSONObject)x).get(CommonModel.ID).toString() ))
        .findFirst();
        return findFirst.isPresent()?gson.fromJson(findFirst.get().toString(), Restaurant.class):null;
	}

	@Override
	public String findAllMenu() throws FileNotFoundException, IOException, ParseException {
		return ((JSONArray) ((JSONObject) read()).get("menu")).toJSONString();
	}

	@Override
	public String findMenuById(String id) throws FileNotFoundException, IOException, ParseException {
		JSONArray jSONArray = (JSONArray) ((JSONObject) read()).get(Menu.MENU);
		Optional<Object> findFirst = Arrays.stream( jSONArray.toArray()  )
        .filter(x -> id.equals( ((JSONObject)x).get(CommonModel.ID).toString() ))
        .findFirst();
        return findFirst.isPresent()?findFirst.get().toString():null;
	}

	@Override
	public String findMenuByRestaurantId(String id) throws FileNotFoundException, IOException, ParseException {
		JSONArray jSONArray = (JSONArray) ((JSONObject) read()).get(Menu.MENU); 
		Object[] findFirst = Arrays.stream( (jSONArray).toArray()  )
		        .filter(x -> id.equals(((JSONObject)x).get(Restaurant.RESTAURANT_ID).toString()))
		        .toArray();
		return Arrays.toString(findFirst);
	}
	
}
