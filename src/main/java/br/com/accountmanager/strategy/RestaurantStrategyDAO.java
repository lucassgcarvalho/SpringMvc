package br.com.accountmanager.strategy;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.accountmanager.model.Restaurant;
import br.com.accountmanager.service.RestaurantService;

/**
 * @author Lucas
 *
 */
@Component
@Qualifier(value="RestaurantStrategyDAO")
public class RestaurantStrategyDAO implements RestaurantService, DAO {
	
	@Resource(name = "JsonDAOImpl")
	private RestaurantService factory;
	
	public RestaurantStrategyDAO() {
		super();
	}
	
	@Override
	public String findAllRestaurants() throws FileNotFoundException, IOException, ParseException {
		return factory.findAllRestaurants();
	}

	@Override
	public String findRestaurantById(Restaurant restaurant) throws FileNotFoundException, IOException, ParseException {
		return factory.findRestaurantById(restaurant);
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
