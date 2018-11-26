package br.com.accountmanager.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.accountmanager.StrategyService;
import br.com.accountmanager.exceptions.StrategyException;
import br.com.accountmanager.model.Restaurant;
import br.com.accountmanager.strategy.Strategy;

/**
 * @author Lucas
 */
@Service
@Qualifier(value="RestaurantServiceImpl")
public class RestaurantServiceImpl implements RestaurantService{
	
	private final static Logger LOGGER = Logger.getLogger(RestaurantServiceImpl.class);

	@Autowired
	@Qualifier(value="Strategy")
	@StrategyService(value="RestaurantService")
	private Strategy strategy;

    public RestaurantServiceImpl() {
    	super();
    }

    
    /**
     * Method returns all restaurants 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public String findAllRestaurants() throws FileNotFoundException, IOException, ParseException {
    	try {
			return ((RestaurantService) strategy.getStrategy()).findAllRestaurants();
		} catch (StrategyException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			return e.getMessage();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			return e.getMessage();
		}
    }


    /**
     * Method returns all restaurants by id 
     * @throws ParseException 
     * @throws IOException 
     * @throws FileNotFoundException 
     */
	public String findRestaurantById(Restaurant restaurant) throws FileNotFoundException, IOException, ParseException {
		try {
			return ((RestaurantService) this.strategy.getStrategy()).findRestaurantById(restaurant);
		} catch (ClassNotFoundException | StrategyException e) {
			e.printStackTrace();
			LOGGER.error(e.getMessage(), e);
			return e.getMessage();
		}
	}


	@Override
	public void create(Object object) {
	}


	@Override
	public void update(Object object) {
	}


	@Override
	public void detele(Object object) {
	}


	@Override
	public List<Object> findAll(Object object) {
		return null;
	}

}
