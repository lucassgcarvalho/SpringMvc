package br.com.accountmanager.dao;

import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import br.com.accountmanager.service.RestaurantServiceImpl;

/**
 * @author Lucas
 *
 */
@Component
public class JsonDAOImpl implements JsonDAO  {
	
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
	
	public JsonDAOImpl() {
		super();
		jsonParser = new JSONParser();
	}
	
	public JSONObject read() throws IOException  {
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
		} catch (ParseException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
		} finally {
			if(fileReader!=null) {
				fileReader.close();
			}
		}
		return null;
	}
	
	
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
	
}
